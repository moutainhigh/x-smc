package com.x.ic.msg.service.atom.interfaces;

import com.x.ic.msg.vo.MessageData;

public interface INodeTransferSV {
	
	public void vilidateNode(MessageData messageData);
	
	public void trans(MessageData messageData);
	
}
