package com.x.ic.msg.exception;

public class NodeValidateException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NodeValidateException(String message){
		super(message);
	}
	public NodeValidateException(){
		super("节点验证失败!");
	}

}
