package com.x.ic.dshm.api.dshmprocess.params;

import java.io.Serializable;

/**
 * 请求参数
 */
public class TableQuery implements Serializable{

	private static final long serialVersionUID = -5452699762452333281L;
	
	private String dbName;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

}
