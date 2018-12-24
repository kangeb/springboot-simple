package com.kang.springboot.simple.core.Exception;

public final class CustomException extends RuntimeException
	{
	private static final long serialVersionUID = 4184239072785931969L;
	
	
	private int code;
	
	
	private String msg;
	
	
	private String uri = null;
	
	public CustomException(int code)
	{
	  this.code = code;
	}
	
	
	
	
	public CustomException(String message)
	{
	  super(message);
	  this.code = 9999;
	  this.msg = message;
	}
	
	public CustomException(int code, String message) {
	  super(message);
	  this.code = code;
	  this.msg = message;
	}
	
	public CustomException(int code, Throwable cause) {
	  super(cause);
	  this.code = code;
	}
	
	public CustomException(String message, Throwable cause) {
	  super(message, cause);
	  this.code = 9999;
	  this.msg = message;
	}
	
	public CustomException(int code, String message, Throwable cause) {
	  super(message, cause);
	  this.code = code;
	  this.msg = message;
	}
	
	public CustomException(int code, String uri, String message) {
	  super(message);
	  this.code = code;
	  this.msg = message;
	  this.uri = uri;
	}
	
	public CustomException(int code, String uri, String message, Throwable cause) {
	  super(message, cause);
	  this.code = code;
	  this.msg = message;
	  this.uri = uri;
	}
	
	public void setCode(int code)
	{
	  this.code = code;
	}
	
	public int getCode() {
	  return this.code;
	}
	
	public String getMsg() {
	  return this.msg;
	}
	
	public void setMsg(String msg) {
	  this.msg = msg;
	}
	
	public String getUri() {
	  return this.uri;
	}
	
	public void setUri(String uri) {
	  this.uri = uri;
	}
}
