package com.solimar.views;

public class ResponseView {
	
	private String responseMessage;
	
	private int responseStatus;
	
	private boolean responseStatusBool;
	
	public ResponseView(){};
	
	public ResponseView(String responseMessage, int responseStatus) {
		super();
		this.responseMessage = responseMessage;
		this.setResponseStatus(responseStatus);
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public int getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(int responseStatus) {
		this.responseStatus = responseStatus;
	}

	public boolean isResponseStatusBool() {
		return responseStatusBool;
	}

	public void setResponseStatusBool(boolean responseStatusBool) {
		this.responseStatusBool = responseStatusBool;
	}
}
