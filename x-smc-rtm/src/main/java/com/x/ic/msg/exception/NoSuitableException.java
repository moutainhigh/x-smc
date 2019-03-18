package com.x.ic.msg.exception;

public class NoSuitableException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NoSuitableException(String message){
		super(message);
	}
	public NoSuitableException(){
		super("没有适配到合适的政策！");
	}
}
