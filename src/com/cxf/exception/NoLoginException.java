package com.cxf.exception;

public class NoLoginException extends Exception{
		
	private String msg = null; 
	
	public NoLoginException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return msg;
	}
}
