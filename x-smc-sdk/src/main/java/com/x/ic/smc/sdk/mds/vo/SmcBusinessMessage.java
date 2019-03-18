package com.x.ic.smc.sdk.mds.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

public class SmcBusinessMessage  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Header header;
	private JSONObject body;
	
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public JSONObject getBody() {
		return body;
	}
	public void setBody(JSONObject body) {
		this.body = body;
	}
	
	
	
}
