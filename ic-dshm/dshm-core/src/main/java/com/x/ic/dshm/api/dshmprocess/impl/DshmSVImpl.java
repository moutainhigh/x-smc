package com.x.ic.dshm.api.dshmprocess.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.x.base.exception.BusinessException;
import com.x.base.vo.PageInfo;
import com.x.base.vo.ResponseHeader;
import com.x.sdk.util.BeanUtils;
import com.x.sdk.util.CollectionUtil;
import com.x.sdk.util.StringUtil;
import com.x.ic.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.x.ic.dshm.api.dshmprocess.params.AddEbillingShmTableRecord;
import com.x.ic.dshm.api.dshmprocess.params.FieldInfo;
import com.x.ic.dshm.api.dshmprocess.params.FieldListResponse;
import com.x.ic.dshm.api.dshmprocess.params.FieldQueryRequest;
import com.x.ic.dshm.api.dshmprocess.params.InitParams;
import com.x.ic.dshm.api.dshmprocess.params.PagingTableInfoRequest;
import com.x.ic.dshm.api.dshmprocess.params.ReqParam;
import com.x.ic.dshm.api.dshmprocess.params.ShmTableInfoVo;
import com.x.ic.dshm.api.dshmprocess.params.ShmTableRecordVo;
import com.x.ic.dshm.api.dshmprocess.params.TableQuery;
import com.x.ic.dshm.dao.interfaces.EbillingShmTableInfoMapper;
import com.x.ic.dshm.dso.interfaces.IDso;
import com.x.ic.dshm.dto.EbillingShmTableDb;
import com.x.ic.dshm.dto.EbillingShmTableInfo;
import com.x.ic.dshm.dto.EbillingShmTableInfoCriteria;
import com.x.ic.dshm.dto.FullTableLoad;
import com.x.ic.dshm.service.interfaces.ITransportService;
import com.x.ic.dshm.service.interfaces.SaasMshmSv;
import com.x.ic.dshm.util.ApplicationContextUtil;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;


@Service
public class DshmSVImpl implements IdshmSV{
	private static final Logger LOG =LoggerFactory.getLogger(DshmSVImpl.class);
    //private static final Logger LOG = LogManager.getLogger(DshmSVImpl.class);
    
	//注入服务对象
	@Autowired
	private ITransportService transportService;
	
	@Autowired
    private SaasMshmSv saasMshmSv;
	
	@Autowired
	private IDso dso;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	
	private JdbcTemplate jdbcTemplate;
	ApplicationContextUtil appContextUtil = ApplicationContextUtil.getInstance();
	public DshmSVImpl(){
//		ApplicationContextUtil appContextUtil = ApplicationContextUtil.getInstance();
//		jdbcTemplate =(JdbcTemplate) appContextUtil.getBean("mysqlJdbcTemplate");
	}
	@Override
	public int fullLoader() throws BusinessException {
		//首先需要加载表结构进内存
		jdbcTemplate =(JdbcTemplate) appContextUtil.getBean("mysqlJdbcTemplate");
		Boolean tableFlag=transportService.EbillingTable2Dso();
		if(tableFlag){
			//将表结构加载完毕之后需要选出需要加载的表名和租户id
			String sqlString=" select distinct table_name,tenant_id from ebilling_shm_table_info ";
			List<FullTableLoad> nameIds=jdbcTemplate.query(sqlString, new BeanPropertyRowMapper<FullTableLoad>(FullTableLoad.class));
			for(FullTableLoad nameid:nameIds){
				Map<String, String> infos=transportService.LoadTableInfo(nameid.getTableName().toLowerCase());
				for(Entry<String,String> infoentry:infos.entrySet()){
					String infoValue=infoentry.getValue();
					String tableId=infoentry.getKey();
					transportService.LoadData2Dso(nameid.getTableName().toLowerCase(), infoValue,tableId);
				}
			}
			return 1;
		}
		else{
			LOG.error("load table info is error.......");
			return -1;
		}
	}

	@Override
	public int refreshLoader(ReqParam req) throws BusinessException {
		String[] tableName=req.getTableNames();
		String[] tableId=req.getTableId();
		//String[] tenantId=req.getTenantIds();
		Boolean tableFlag=transportService.EbillingTable2Dso();
		if(tableFlag){
			if((tableName.length==tableId.length)){
				for(int i=0;i<tableName.length;i++){
					Map<String, String> infoMap=transportService.LoadTableInfo(tableName[i]);
					String infoValue=infoMap.get(tableId[i]);
					if(infoValue != null){//4.1 liangbs加
					    transportService.LoadData2Dso(tableName[i], infoValue,tableId[i]);
					}else{//4.1 liangbs加
					    LOG.error("没有找到tableId为［"+tableId[i]+"］且tableName为［"+tableName[i]+"］的对应数据。。。");//4.1 liangbs加
					    return -1;//4.1 liangbs加
					}//4.1 liangbs加
				}
				return 1;		
			}
			else{
				LOG.error("the param is error please check......");
				return -1;
			}
		}else{
			LOG.error("load table info is error.......");
			return -1;
		}	
	}

	@Override
	public int shmDelete(ReqParam req) throws BusinessException {
		// 应该先删除然后在加载表结构到内存中
		String[] tableName=req.getTableNames();
		String[] tableId=req.getTableId();
		//String[] tenantId=req.getTenantIds();
		if((tableName.length==tableId.length)){
			for(int i=0;i<tableName.length;i++){
				int j =transportService.DeleteTableMem(tableName[i], tableId[i]).intValue();
			}
			return 1;
		}else{
			LOG.error("the param is error please check......");
			return -1;
		}
	}

	@Override
	public Integer initLoader(InitParams params) throws BusinessException {
		
		LOG.debug("the object is:"+params.getObj());
		Map<String, String> initMap=new HashMap<String, String>();
		initMap=transportService.json2Map(params.getObj().toString());
		//String tenantId=initMap.get("tenant_id");
		Map<String, String> infoMaps=transportService.LoadTableInfo(params.getTableName());
		int flag=0;
		for(Entry<String,String> infoentry:infoMaps.entrySet()){
			String infoValue=infoentry.getValue();
			String tableId=infoentry.getKey(); 
			LOG.debug("the table_id is "+tableId);
			LOG.debug("the infoValue is "+infoValue);
			Boolean suc=transportService.initCtp2Dso(infoValue, tableId,initMap,params.getTableName(),params.getType());
			LOG.debug("the suc is:"+suc);
			if(!suc){
				flag=-1;
				LOG.error("the tableId="+tableId+" initLoader is error.........");
			}
		}
		if(flag==-1)
			return -1;
		else {
			return 1;
		}
	}
	@Override
	public Integer initdel(String tableName, Object obj) throws BusinessException {
		//默认实时删除是的type=2；
		Map<String, String> initMap=new HashMap<String, String>();
		initMap=transportService.json2Map(obj.toString().toLowerCase());
		//String tenantId=initMap.get("tenant_id");
		Map<String, String> infoMaps=transportService.LoadTableInfo(tableName);
		int flag=0;
		for(Entry<String,String> infoentry:infoMaps.entrySet()){
			String infoValue=infoentry.getValue();
			String tableId=infoentry.getKey(); 
			Boolean suc=transportService.initCtp2Dso(infoValue, tableId,initMap,tableName,2);
			if(!suc){
				flag=-1;
				LOG.error("the tableId="+tableId+" initDel is error.........");
			}
		}
		if(flag==-1)
			return -1;
		else {
			return 1;
		}
	}
	public static void main(String[] args){
		LOG.debug("start fuller load ......");
		ApplicationContextUtil appContextUtil = ApplicationContextUtil.getInstance();
		DshmSVImpl dshmsv = (DshmSVImpl)appContextUtil.getBean("dshmsv");
		dshmsv.fullLoader();
	}
	
	
    @Override
    public String[] ListDBName() throws BusinessException{
        List<EbillingShmTableDb> dbNameList = saasMshmSv.ListDbName();
        
        String[] dbNameArray = null;
        if(!CollectionUtil.isEmpty(dbNameList)){
            //遍历得到db_connect字段
            int size = dbNameList.size();
            dbNameArray = new String[size];
            for(int i=0 ; i<size; i++){
                dbNameArray[i] = dbNameList.get(i).getDbConnect();
            }
        }
        
        return dbNameArray;
    }
    
    
    @Override
    public List<String> ListTableName(TableQuery request) throws BusinessException{
        if(request == null || StringUtil.isBlank(request.getDbName())){
            LOG.error("数据库表名列表服务。。。请求参数不能为空:" + JSONObject.toJSONString(request));
            return null;
        }
        
        List<String> tabNameList = saasMshmSv.ListTableName(request.getDbName());
            
        return tabNameList;
    }

	@Override
	public List<FieldInfo> ListFiledName(String dbName, String tableName) throws BusinessException {
		List<FieldInfo> fieldInfos = saasMshmSv.ListFieldInfo(dbName, tableName);
		return fieldInfos;
	}

	@Override
	public String deleteTable(Map<String,String> tableInfos) throws BusinessException {
		return saasMshmSv.deleteTable(tableInfos);
	}

	@Override
	public String addTable(AddEbillingShmTableRecord addResult) throws BusinessException {
		String dbConnect = addResult.getDbConnect();
		String tableName = addResult.getTableName();
		List<String> isIndexKeysList=addResult.getIsIndexKey();
	
		List<ShmTableRecordVo> names = new ArrayList<ShmTableRecordVo>();
		names = addResult.getShmTableRecordVoList();
		String bl = saasMshmSv.add(dbConnect, tableName, names,isIndexKeysList);
	
		return bl;
	}
	
	@Override
	public PageInfo<ShmTableInfoVo> pagingTableInfo(
			PagingTableInfoRequest pagingTableInfoRequest)
			throws BusinessException {
		EbillingShmTableInfoCriteria ebillingShmTableInfoCriteria = new EbillingShmTableInfoCriteria();
		EbillingShmTableInfoCriteria.Criteria criteria = ebillingShmTableInfoCriteria.createCriteria();
		String name = pagingTableInfoRequest.getTableName();
		if(!StringUtil.isBlank(name))
			criteria.andTableNameLike("%" + name + "%");
		
		PageInfo pageInfo = pagingTableInfoRequest.getPageInfo();

		LOG.info("search:" + pagingTableInfoRequest.getPageInfo());
		EbillingShmTableInfoMapper ebillingShmTableInfoMapper = sqlSessionTemplate
				.getMapper(EbillingShmTableInfoMapper.class);
		LOG.info("ebillingShmTableInfoMapper:" + ebillingShmTableInfoMapper);
		int totalCount = ebillingShmTableInfoMapper
				.countByExample(ebillingShmTableInfoCriteria);
		
		ebillingShmTableInfoCriteria.setLimitStart((pageInfo.getPageNo()-1)*pageInfo.getPageSize());
		ebillingShmTableInfoCriteria.setLimitEnd(pageInfo.getPageSize());//pageInfo.getPageNo()*pageInfo.getPageSize()
		List<EbillingShmTableInfo> ebillingShmTableInfos = ebillingShmTableInfoMapper
				.selectByExample(ebillingShmTableInfoCriteria);
		List<ShmTableInfoVo> shmTableInfoVos = new ArrayList<ShmTableInfoVo>();
		if (ebillingShmTableInfos != null && ebillingShmTableInfos.size() > 0) {
			for (int i = 0; i < ebillingShmTableInfos.size(); i++) {
				ShmTableInfoVo shmTableInfoVo = new ShmTableInfoVo();
				BeanUtils.copyProperties(shmTableInfoVo,ebillingShmTableInfos.get(i));
				shmTableInfoVos.add(shmTableInfoVo);
			}
		}
		PageInfo<ShmTableInfoVo> PageInfo = new PageInfo<ShmTableInfoVo>();
		pageInfo.setResult(shmTableInfoVos);
		
		pageInfo.setPageCount(totalCount/pageInfo.getPageSize()+1);
		pageInfo.setCount(totalCount);

		LOG.error("pageInfo:"+pageInfo);
		return pageInfo;
	}
	
    @Override
    public String queryByHashKey(String tableKey, String fieldKey) throws BusinessException {
        
        if(StringUtil.isBlank(tableKey) || StringUtil.isBlank(fieldKey)){
            LOG.error("参数里tableKey为空或者fieldKey为空");
            return null;
        }
        
        return dso.hget(tableKey, fieldKey);
    }
    
    @Override
    public Long delByHashKey(String tableKey, String[] fieldKey) throws BusinessException {
        
        if(StringUtil.isBlank(tableKey) || CollectionUtil.isEmpty(fieldKey)){
            LOG.error("参数里tableKey为空或者fieldKey为空");
            return null;
        }
        
        return dso.hdel(tableKey, fieldKey);
        
    }
	@Override
	public FieldListResponse getTableFieldRecord(FieldQueryRequest request) throws BusinessException {
		if(StringUtil.isBlank(request.getTableName())){
			throw new BusinessException("888888", "表名称不能为空");
		}
		if(null==request.getTableId()){
			throw new BusinessException("888888", "tableId不能为空");
		}
		List<String> list=saasMshmSv.getTableFieldRecord(request);
		ResponseHeader header=new ResponseHeader();
		header.setSuccess(true);
		header.setResultCode("000000");
		header.setResultMessage("查询成功");
		FieldListResponse res=new FieldListResponse();
		res.setFields(list);
		res.setResponseHeader(header);
		return res;
	}

}
