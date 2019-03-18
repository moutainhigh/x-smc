package com.x.ic.dshm.dao.interfaces;

import java.util.List;
import java.util.Map;

import com.mysql.jdbc.Connection;
import com.x.ic.dshm.dto.EbillingShmTableDb;
import com.x.ic.dshm.dto.ShmTableLoad;
//用来对info、record、db三张表操作
public interface IDao {
	/**
	 * 对ebilling_shm_table_info、record 两张表的加载
	 * @return
	 */
	public Map<String, ShmTableLoad> LoadShmTableInfo();
	/**
	 * 对ebilling_shm_table_db表的加载
	 * @return
	 */
	public Map<String, EbillingShmTableDb> LoadShmTableDb();
	/**
	 * select 出具体要插入到缓存中的数据
	 * @param shmtable
	 * @return  field和value的具体值
	 */
	public Map<String,String> LoadTableData(String table_name,ShmTableLoad shmtable,String firstKey);

	
}
