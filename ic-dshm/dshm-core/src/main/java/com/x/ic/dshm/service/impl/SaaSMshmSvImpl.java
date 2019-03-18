package com.x.ic.dshm.service.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.x.base.exception.BusinessException;
import com.x.sdk.util.CollectionUtil;
import com.x.ic.dshm.api.dshmprocess.params.FieldInfo;
import com.x.ic.dshm.api.dshmprocess.params.FieldQueryRequest;
import com.x.ic.dshm.api.dshmprocess.params.ShmTableRecordVo;
import com.x.ic.dshm.constants.MshmConstants;
import com.x.ic.dshm.dao.interfaces.EbillingShmTableDbMapper;
import com.x.ic.dshm.dao.interfaces.EbillingShmTableInfoMapper;
import com.x.ic.dshm.dao.interfaces.EbillingShmTableRecordMapper;
import com.x.ic.dshm.dto.EbillingShmTableDb;
import com.x.ic.dshm.dto.EbillingShmTableDbCriteria;
import com.x.ic.dshm.dto.EbillingShmTableInfo;
import com.x.ic.dshm.dto.EbillingShmTableInfoCriteria;
import com.x.ic.dshm.dto.EbillingShmTableRecord;
import com.x.ic.dshm.dto.EbillingShmTableRecordCriteria;
import com.x.ic.dshm.service.interfaces.ITransportService;
import com.x.ic.dshm.service.interfaces.SaasMshmSv;
import com.x.ic.dshm.util.CommonDbByJdbc;
import com.x.ic.dshm.util.JDBCPropertiesUtils;

@Service
@Transactional
public class SaaSMshmSvImpl implements SaasMshmSv {
    
    private static final Logger LOG = LoggerFactory.getLogger(SaaSMshmSvImpl.class);
    
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private ITransportService transportService;

	@Override
    public List<EbillingShmTableDb> ListDbName() {
        EbillingShmTableDbCriteria ebillingShmTableDbCriteria = new EbillingShmTableDbCriteria();
        EbillingShmTableDbMapper ebillingShmTableDbMapper = sqlSessionTemplate.getMapper(EbillingShmTableDbMapper.class);
        List<EbillingShmTableDb> ebillingShmTableDb = ebillingShmTableDbMapper.selectByExample(ebillingShmTableDbCriteria);

        return ebillingShmTableDb;
    }
	
	@Override
	public List<String> ListTableName(String params) {
		List<String> resultSet = new ArrayList<String>();
		JDBCPropertiesUtils jdbcPropertiesUtils = JDBCPropertiesUtils.getInstance(sqlSessionTemplate, params);
		if(jdbcPropertiesUtils == null){
		    LOG.error("jdbcPropertiesUtils is null !");
		    return resultSet;
		}
		
		CommonDbByJdbc commonDbByJdbc = new CommonDbByJdbc(jdbcPropertiesUtils);
		commonDbByJdbc.getConnection();
		try {
			resultSet = commonDbByJdbc.getAllTableNames();
		} catch (Exception e) {
		    LOG.error("ListTableName(String params)方法获取表名异常", e);
		} finally {
			commonDbByJdbc.close();
		}
		
		return resultSet;
	}

	@Override
	public List ListFieldName(String dbConnect, String tableName) {
		List<String> lstr = new ArrayList<String>();

		JDBCPropertiesUtils jdbcPropertiesUtils = JDBCPropertiesUtils
				.getInstance(sqlSessionTemplate, dbConnect);
		String type = jdbcPropertiesUtils.getType();
		CommonDbByJdbc commonDbByJdbc = new CommonDbByJdbc(jdbcPropertiesUtils);

		String mySql = "select COLUMN_NAME from information_schema.COLUMNS where table_name = '"
				+ tableName + "'";

		String oracleSql = "select column_name from user_tab_columns where table_name='"
				+ tableName + "'";
		try {
			ResultSet resultset = null;// new ResultSet();
			if (type.equals("mysql")) {
				resultset = commonDbByJdbc.select(mySql);
			} else {
				resultset = commonDbByJdbc.select(oracleSql);
			}
			List<String> nameList = new ArrayList<String>();
			int columnIndex = 0;
			while (resultset.next()) {
				nameList.add(columnIndex, resultset.getString(1));
				columnIndex++;
			}
			lstr = nameList;
			for (int i = 0; i < lstr.size(); i++) {
				LOG.debug("###########################" + lstr.get(i));
			}
		} catch (Exception e) {
			LOG.error("查询数据库异常",e);
		} finally {
			commonDbByJdbc.close();
		}
		return lstr;
	}

	@Override
	public List<FieldInfo> ListFieldInfo(String dbConnect, String tableName) {
		List<FieldInfo> fieldInfos = new ArrayList<FieldInfo>();

		JDBCPropertiesUtils jdbcPropertiesUtils = JDBCPropertiesUtils
				.getInstance(sqlSessionTemplate, dbConnect);
		String type = jdbcPropertiesUtils.getType();
		CommonDbByJdbc commonDbByJdbc = new CommonDbByJdbc(jdbcPropertiesUtils);

		String mySql = "select COLUMN_NAME,COLUMN_TYPE,COLUMN_KEY,COLUMN_COMMENT,DATA_TYPE from information_schema.COLUMNS where table_name = '"
				+ tableName + "'";

		String oracleSql = "select column_name from user_tab_columns where table_name='"
				+ tableName + "'";
		try {
			ResultSet resultset = null;// new ResultSet();
			if (type.equals("mysql")) {
				resultset = commonDbByJdbc.select(mySql);
			} else {
				resultset = commonDbByJdbc.select(oracleSql);
			}
			while (resultset.next()) {
				FieldInfo fieldInfo = new FieldInfo();
				fieldInfo.setFieldName(resultset.getString("COLUMN_NAME"));
				fieldInfo.setFieldType(resultset.getString("DATA_TYPE"));
				fieldInfo.setComment(resultset.getString("COLUMN_COMMENT"));
				if(resultset.getString("COLUMN_KEY").equals("PRI")){
					fieldInfo.setPrimary(true);
					fieldInfo.setAsIndex(true);
					fieldInfo.setSupportIndex(true);
				}
				fieldInfos.add(fieldInfo);
			}
			for (int i = 0; i < fieldInfos.size(); i++) {
				LOG.debug("###########################" + fieldInfos.get(i));
			}
		} catch (Exception e) {
			LOG.error("查询数据库异常",e);
		} finally {
			commonDbByJdbc.close();
		}
		return fieldInfos;
	}

	@Override
	public String add(String dbConnect, String tableName,
			List<ShmTableRecordVo> names, List<String> isIndexKeysList) {
		// TODO Auto-generated method stub
	    LOG.error("the 11111111111111111  isIndexKeysList    "+isIndexKeysList);
		Collections.sort(isIndexKeysList);
		
		LOG.error("the isIndexKeysList    "+isIndexKeysList);
		EbillingShmTableInfoMapper ebillingShmTableInfoMapper = sqlSessionTemplate
				.getMapper(EbillingShmTableInfoMapper.class);
		EbillingShmTableInfo ebillingShmTableInfo = new EbillingShmTableInfo();
		ebillingShmTableInfo.setTableName(tableName);
		ebillingShmTableInfo.setDbConnect(dbConnect);
		EbillingShmTableInfoCriteria estiCriteria=new EbillingShmTableInfoCriteria();
		estiCriteria.createCriteria();
		List<EbillingShmTableInfo> eList=ebillingShmTableInfoMapper.selectByExample(estiCriteria);
		int tableId =0;
		if(eList!=null&&eList.size()!=0){
			tableId = ebillingShmTableInfoMapper.maxByTableId();
		}
		
		
		ebillingShmTableInfo.setTableId(tableId + 1);

		ebillingShmTableInfo.setIndexMode(0);
		ebillingShmTableInfo.setIndexCount(13l);
		ebillingShmTableInfo.setDataCount(10l);
		ebillingShmTableInfo.setIsPara(1);
		ebillingShmTableInfo.setIndexId(1);
		ebillingShmTableInfo.setHashType(0);
		ebillingShmTableInfo.setIsEnable(1);
		ebillingShmTableInfo.setStorageType(0);
		ebillingShmTableInfo.setLesseeName("ai");
		//2015-12-02 tenantid=BYD
		ebillingShmTableInfo.setTenantId("BYD");

		String str = "";
		Collections.sort(isIndexKeysList);
		
		LOG.error("the isIndexKeysList 22222222   "+isIndexKeysList);
		
		for (int i = 0; i < isIndexKeysList.size(); i++) {
			if (i == isIndexKeysList.size() - 1)
				str += isIndexKeysList.get(i);
			else {
				str += isIndexKeysList.get(i) + ":";
			}
		}
		
		EbillingShmTableRecordMapper ebillingShmTableRecordMapper = sqlSessionTemplate
				.getMapper(EbillingShmTableRecordMapper.class);
		EbillingShmTableRecordCriteria estrCriteria=new EbillingShmTableRecordCriteria();
		estrCriteria.createCriteria();
		List<EbillingShmTableRecord> estrList=ebillingShmTableRecordMapper.selectByExample(estrCriteria);
		int ID=1;
		if(estrList!=null&&estrList.size()!=0){
			ID = ebillingShmTableRecordMapper.maxById() + 1;
		}
		for (int i = 0; i < names.size(); i++) {
			ShmTableRecordVo shmTableRecordVo = new ShmTableRecordVo();
			shmTableRecordVo = names.get(i);
			String fieldName = shmTableRecordVo.getFieldName();
			// if (i == names.size() - 1) {
			// str += fieldName;
			// } else {
			// str += fieldName + ":";
			// }
			int fieldType = shmTableRecordVo.getFieldType();
			String fieldFormat = shmTableRecordVo.getFieldFormat();
			// int fieldSize = shmTableRecordVo.getFieldSize();
			int isHashkey = shmTableRecordVo.getIsHashkey();
			int isPrimary = shmTableRecordVo.getIsPrimary();
			String searchType = shmTableRecordVo.getSearchType();

			EbillingShmTableRecord ebillingShmTableRecord = new EbillingShmTableRecord();
			ebillingShmTableRecord.setTableName(tableName);
			ebillingShmTableRecord.setFieldSeq(i + 1);
			ebillingShmTableRecord.setFieldName(fieldName);
			ebillingShmTableRecord.setTableId(tableId + 1);
			ebillingShmTableRecord.setId(ID++);
			ebillingShmTableRecord.setFieldType(1);
			if (fieldFormat != null) {
				ebillingShmTableRecord.setFieldFormat(fieldFormat);
			}
			ebillingShmTableRecord.setFieldType(fieldType);
			if (shmTableRecordVo.getFieldSize() != null) {
				ebillingShmTableRecord.setFieldSize(shmTableRecordVo.getFieldSize());
			}
			ebillingShmTableRecord.setIsHashkey(isHashkey);
			ebillingShmTableRecord.setIsPrimary(isPrimary);
			if (searchType != null) {
				ebillingShmTableRecord.setSearchType(searchType);
			}
			//2015-12-02 tenantid=BYD
			ebillingShmTableRecord.setTenantId("BYD");
			ebillingShmTableRecordMapper.insert(ebillingShmTableRecord);
		}

		ebillingShmTableInfo.setIndexKey(str);
		ebillingShmTableInfoMapper.insert(ebillingShmTableInfo);

		return "000000";
	}

	@Override
	public String deleteTable(Map<String,String> tableInfos) {
		String result = "";
		int flag = 0;
		if(tableInfos!=null&&tableInfos.size()>0){
			for (Map.Entry<String,String> entry:tableInfos.entrySet()) {
				//删除表所对应的缓存
				String tableName =entry.getValue(); //entry.getKey();
				Integer tableId = Integer.parseInt(entry.getKey());
				transportService.DeleteTableMem(tableName, String.valueOf(tableId));
				//删除表配置信息
				EbillingShmTableInfoCriteria ebillingShmTableInfoCriteria = new EbillingShmTableInfoCriteria();
				EbillingShmTableInfoCriteria.Criteria criteria = ebillingShmTableInfoCriteria
						.createCriteria();
				criteria.andTableNameEqualTo(tableName);
				criteria.andTableIdEqualTo(tableId);

				EbillingShmTableInfoMapper ebillingShmTableInfoMapper = sqlSessionTemplate
						.getMapper(EbillingShmTableInfoMapper.class);
				int result1 = ebillingShmTableInfoMapper
						.deleteByExample(ebillingShmTableInfoCriteria);

				EbillingShmTableRecordCriteria ebillingShmTableRecordCriteria = new EbillingShmTableRecordCriteria();
				EbillingShmTableRecordCriteria.Criteria criteria2 = ebillingShmTableRecordCriteria
						.createCriteria();
				criteria2.andTableNameEqualTo(tableName);
				criteria2.andTableIdEqualTo(tableId);
				EbillingShmTableRecordMapper ebillingShmTableRecordMapper = sqlSessionTemplate
						.getMapper(EbillingShmTableRecordMapper.class);

				int result2 = ebillingShmTableRecordMapper
						.deleteByExample(ebillingShmTableRecordCriteria);

				if (result1 == 0 && result2 == 0) {
					flag = 1;
				}
			}
		}

		if (flag == 0) {
			result = MshmConstants.SUCCESS_CODE;
		} else {
			result = MshmConstants.FAIL_CODE;
		}
		return result;
	}

	@Override
	public List<String> getTableFieldRecord(FieldQueryRequest request) throws BusinessException {
	   EbillingShmTableRecordMapper mapper=sqlSessionTemplate.getMapper(EbillingShmTableRecordMapper.class);
	   EbillingShmTableRecordCriteria ebillingShmTableRecordCriteria = new EbillingShmTableRecordCriteria();
		EbillingShmTableRecordCriteria.Criteria criteria2 = ebillingShmTableRecordCriteria
				.createCriteria();
		criteria2.andTableIdEqualTo(request.getTableId());
		criteria2.andTableNameEqualTo(request.getTableName());
		List<EbillingShmTableRecord>  list=mapper.selectByExample(ebillingShmTableRecordCriteria);
		List<String> retList=new ArrayList<String>();
		if(CollectionUtil.isEmpty(list)){
			return retList;
		}else{
			//retList=new ArrayList<String>();
			for(EbillingShmTableRecord record:list){
				
				retList.add(record.getFieldName());
			}
		}
		return retList;
	}

}
