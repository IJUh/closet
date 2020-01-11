package model;

public class ErrorInfo {
	private final String url;
	private final String ex;

	public ErrorInfo(String url, Exception ex) {
		this.url = url;
		this.ex = ex.getLocalizedMessage();
	}
}