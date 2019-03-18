package com.x.hbase.base.model;

import java.util.List;

public class PutVO {

	private String rowkey;
	
	private List<FamilyVO> families;

	public String getRowkey() {
		return rowkey;
	}

	public void setRowkey(String rowkey) {
		this.rowkey = rowkey;
	}

	public List<FamilyVO> getFamilies() {
		return families;
	}

	public void setFamilies(List<FamilyVO> families) {
		this.families = families;
	}
}
