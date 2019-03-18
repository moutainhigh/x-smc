package com.x.ic.msg.exception;

public class NodeTransferException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NodeTransferException(){
		super("节点转换异常！");
	}
	public NodeTransferException(String message){
		super(message);
	}
}
