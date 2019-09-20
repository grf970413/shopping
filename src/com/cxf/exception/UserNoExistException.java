package com.cxf.exception;

/**
 * @author 
 * 用户不存在异常
 */
public class UserNoExistException extends Exception {
	
	private String msg = null;
	
	public UserNoExistException(String msg) {
		this.msg= msg;
	}
}
