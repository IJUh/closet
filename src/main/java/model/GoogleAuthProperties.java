package model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleAuthProperties {
	private String clientId;
	private String clientSecret;
	private String redirectUri;
	private String accountUrl;
	private String authUrl;
	private String applicationName;

	GoogleAuthProperties(@Value("${clientId}") String clientId, @Value("${client_secret}") String clientSecret,
			@Value("${redirect_uri}") String redirectUri, @Value("${account_url}") String accountUrl, @Value("${auth_url}") String authUrl, @Value("${applicationName}") String applicationName) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.redirectUri = redirectUri;
		this.accountUrl= accountUrl;
		this.authUrl = authUrl;
		this.applicationName = applicationName;
	}

	public String getClientId() {
		return clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public String getRedirectUri() {
		return redirectUri;
	}

	public String getAccountUrl() {
		return accountUrl;
	}

	public String getAuthUrl() {
		return authUrl;
	}

	public String getApplicationName() {
		return applicationName;
	}
}
