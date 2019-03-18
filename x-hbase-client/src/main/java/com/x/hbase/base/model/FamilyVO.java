package com.x.hbase.base.model;

import java.util.List;

public class FamilyVO {

	private String family;
	
	private List<QualifierVO> qualifiers;

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public List<QualifierVO> getQualifiers() {
		return qualifiers;
	}

	public void setQualifiers(List<QualifierVO> qualifiers) {
		this.qualifiers = qualifiers;
	}
}
