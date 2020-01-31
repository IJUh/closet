package service.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.GoogleAuthProperties;
import model.GoogleJWT;
import service.AuthService;
import service.LoginService;
@Service
public class GoogleAuthServiceImpl implements AuthService {

	@Inject
	LoginService loginService;
	
	@Inject
	GoogleAuthProperties googleAuthProperties;
	
	@Inject
	GoogleJWT googleJwt;
	
	/*@Autowired
	GoogleJWT gg;
	
	public void setGg(GoogleJWT gg) {
		this.gg = gg;
	}*/

	@Override
	public String authLogin(HttpServletResponse response, HttpServletRequest request) {
		// Create a state token to prevent request forgery.
		// Store it in the session for later validation.
		String state = new BigInteger(130, new SecureRandom()).toString(32);
		request.getSession().setAttribute("state", state);

		final String servletURL = googleAuthProperties.getAccountUrl();
		final String clientId = googleAuthProperties.getClientId();
		final String redirectUri = googleAuthProperties.getRedirectUri();

		//바디 작성
		Map<String, String> params = new HashMap<>();
		params.put("client_id", clientId);
		params.put("scope", "openid profile email");
		params.put("redirect_uri", redirectUri);
		params.put("state", state);
		params.put("response_type", "code");

		// adding the query params to the URL
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(servletURL);
		for (Map.Entry<String, String> entry : params.entrySet()) {
			builder.queryParam(entry.getKey(), entry.getValue());
		}

		builder.build(false); 			// 자동으로 encode해주는 것을 막기 위해 false
		
		return builder.toUriString();
	}

	public int siginIn(HttpServletResponse response, HttpServletRequest request) throws JsonMappingException, UnsupportedEncodingException, JsonProcessingException, DecoderException {
		String code = request.getParameter("code");
		final String servletURL = googleAuthProperties.getAuthUrl();
		final String clientId = googleAuthProperties.getClientId();
		final String clientSecret = googleAuthProperties.getClientSecret();
		final String redirectUrl = googleAuthProperties.getRedirectUri();

		//바디 작성
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("code", code);
		params.add("client_id", clientId);
		params.add("client_secret", clientSecret);
		params.add("redirect_uri", redirectUrl);
		params.add("grant_type", "authorization_code");
	        
		//헤더 작성
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		//method 파라미터에 보낼 헤더와 바디를 HttpEntity를 사용하여 캡슐화
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		
        //RestTemplate을 사용하여 Access Token 및 profile을 요청한다.
        RestTemplate restTemplate = new RestTemplate();
        
        //restTemplate으로 request요청 uri 지정 및 Method호출방식, requestEntity, 응답결과를 넘겨준다.
        ResponseEntity<Map> responseEntity = restTemplate.exchange(servletURL, HttpMethod.POST, requestEntity, Map.class);
        Map<String, Object> responseMap = responseEntity.getBody();
 
        getGoogleAuthInfo(responseMap);
       
        //로그인 계정이 존재하는 지 여부 확인
        //1. 존재하면 application session을 google API에서 받은 정보로 시작한다.
        //2. 존재하지 않으면 회원가입창으로 이동
        
        if(loginService.getGoogleUserInfo(googleJwt) != 1) {
        	return -1;
        } else {
        	request.getSession().setAttribute("id_token",(String)responseMap.get("id_token"));
        }
        
        return 1;
		/*
		 * if(login.getGoogleUserInfo(result.get("azp")) == 1) {
		 * request.getSession().setAttribute("idToken", tokens); } else { //new user
		 * register login.registerGoogleUserInfo(result.get("azp")); }
		 */
	}

	private void getGoogleAuthInfo(Map<String, Object> responseMap) throws UnsupportedEncodingException, JsonMappingException, JsonProcessingException, DecoderException {
		// 응답 결과 JSON 배열로 access_token, expires_in 등의 정보가 들어있지만 제일 중요한 유저 정보는 id_token에 들어있다.
        // id_token은 JWT(Json Web Token)형태이고 Base64로 인코딩 되어 있어 디코딩 후 사용 
		//콤마 단위로 끊어서 첫 번째는 현 토큰에 대한 메타 정보, 두 번째는 우리가 필요한 내용이 존재한다.
        // 세번째 부분에는 위변조를 방지하기 위한 특정 알고리즘으로 암호화되어 사이닝에 사용한다.
		
		String[] tokens = ((String)responseMap.get("id_token")).split("\\.");
        Base64 base64 = new Base64(true);
        String body = new String(base64.decode(tokens[1]));

        //Jackson을 사용한 JSON을 자바 Map 형식으로 변환
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> result = mapper.readValue(body, Map.class);
        
		googleJwt.setSub(result.get("sub"));
		googleJwt.setEmail(result.get("email"));
		
		/*Map<String,Object> jwt = new HashMap<String, Object>();
		Base64 base64 = new Base64(true);
		JSONObject json = (JSONObject) base64.decode(responseMap.get("id_token"));
        //String[] tokens = ((String)responseMap.get("id_token")).split("\\.");
*/
        //Jackson을 사용한 JSON을 자바 Map 형식으로 변환
        //ObjectMapper mapper = new ObjectMapper();
        //Map<String, String> result = mapper.readValue(new JsonParser(responseMap.get("id_token")), Map.class);
	}

}
