package service;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * The Class GoogleRetrofit2Api.
 *
 * @Class Name : GoogleRetrofit2Api.java
 * @Description : GoogleRetrofit2Api
 * @Modification Information
 *
 * @author
 * @version 1.0
 * @see  Copyright (C) by UIJ All right reserved.
 * @since 2020.03.09
 * @
 * @ 수정일			수정자		수정내용
 * @ -----------	---------   -------------------------------
 * @ 2020.03.09 	UIJ       최초생성 : 스티비 주소록에 구독자 추가, 구글 데이터 전송
 */
public abstract interface GoogleRetrofit2Api2 {

	@FormUrlEncoded
	@POST("/lists/{listId}/subscribers")
    public abstract Call<Object> addSubscribers(@Header("accessToken ") String accessToken 
											, @Path("listId") String listId
											, @Body HashMap<String, Object> bodyMap);


}