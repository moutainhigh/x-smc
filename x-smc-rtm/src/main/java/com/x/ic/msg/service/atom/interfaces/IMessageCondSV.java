package com.x.ic.msg.service.atom.interfaces;

import java.util.List;

import com.x.ic.msg.vo.MessageData;
import com.x.ic.smc.sdk.cache.vo.Policy;

public interface IMessageCondSV {
	
	public List<Policy> suitPolicy(MessageData messageData);
	
}
