package com.ai.baas.dshm.test.api.dshmprocess;

import com.x.ic.dshm.api.dshmprocess.interfaces.IdshmSV;
import com.x.ic.dshm.api.dshmprocess.params.*;
import com.x.base.vo.PageInfo;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import net.sf.json.JSONObject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/context/core-context.xml" })
public class DshmTest {
    
    @Autowired
    protected ApplicationContext ctx;
    
    @Autowired
    protected IdshmSV dshmSV;

    public <T> T getBean(Class<T> type) {
        return ctx.getBean(type);
    }

    public Object getBean(String beanName) {
        return ctx.getBean(beanName);
    }

    @Ignore
    @Test
    public void testListTaleName() {
        
        String[] stra = new String[]{"AAA", "BBB"};
        System.out.println("参数：" + new Gson().toJson(stra));
        
        Long flag = dshmSV.delByHashKey("bl_userinfo:32", new String[]{"subs_id:tenant_id:204:VLV-BYD"});
        
        System.out.println("查询结果：" + flag);
    }
    
    @Ignore
    @Test
    public void testQueryByHashKey() {
        
        String str = dshmSV.queryByHashKey("bl_subs_comm:2", "subs_id:tenant_id:30:1111");
        
        System.out.println("查询结果：" + str);
    }
    
    @Ignore
    @Test
    public void testListDBName() {
        String[] dbNameArr = dshmSV.ListDBName();
        System.out.println("查询结果：" + new Gson().toJson(dbNameArr));
    }
    
    @Ignore
    @Test
    public void testListTableName() {
        TableQuery request = new TableQuery();
        request.setDbName("dev_baas_sys1");
        System.out.println("请求参数：" + JSONObject.fromObject(request));
        List<String> listTableName = dshmSV.ListTableName(request);
        System.out.println("查询结果：" + new Gson().toJson(listTableName));
    }

    @Test
    public void testListFieldName() {

        List<FieldInfo> fieldInfos = dshmSV.ListFiledName("dev_baas_sys1", "ebilling_shm_table_db");
        System.out.println(JSON.toJSONString(fieldInfos));
    }

    @Ignore
    @Test
    public void testDeleteTable() {

        Map<String,String> tableInfos = new HashMap<String,String>();
        tableInfos.put("bl_subs_comm","1");
        String s = dshmSV.deleteTable(tableInfos);
        System.out.println(s);
    }

//    @Ignore
    @Test
    public void testAddTable() {

//        String listDBName = dshmSV.ListDBName();
//        System.out.println("查询结果：" + listDBName);
        //System.out.println("查询结果：" + JSONObject.fromObject(""));

    	AddEbillingShmTableRecord entity = new AddEbillingShmTableRecord();
		entity.setDbConnect("ebilling");
		entity.setTableName("bl_subs_comm");

		List<String> isIndexKey = new ArrayList<String>();
		isIndexKey.add("SUBS_ID");
		isIndexKey.add("TENANT_ID");
		entity.setIsIndexKey(isIndexKey);

		List<ShmTableRecordVo> voList = new ArrayList<ShmTableRecordVo>();
		String[] fileds = new String[]{"SUBS_ID","TENANT_ID","SUBS_PRODUCT_ID","PRODUCT_ID","RES_CLEAR_CYCLE","RES_BONUS_FLAG","RES_END_TYPE","DEFINE_FLAG","BILLING_TYPE"}; 
		for(String name:fileds){
			ShmTableRecordVo vo = new ShmTableRecordVo();
			vo.setFieldName(name);
			vo.setFieldType(0);
			vo.setIsHashkey(0);
			vo.setIsPrimary(0);
			voList.add(vo);
		}

		entity.setShmTableRecordVoList(voList);

		System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(entity));

    	String success = dshmSV.addTable(entity);
    	 System.out.println("查询结果：" + success);
    	
    }

    @Ignore
    @Test
    public void testFullLoader() {
         int fullLoader = dshmSV.fullLoader();
        System.out.println("查询结果：" + fullLoader);
        //System.out.println("查询结果：" + JSONObject.fromObject(""));
    }

    @Ignore
    @Test
    public void testShmDelete(){
    	ReqParam req =new ReqParam();
    	String[] a=new String[]{"1"};
    	req.setTableId(a);
    	String[] b=new String[]{"ebilling_shm_table_db"};
    	req.setTableNames(b);
    	int shmDelete = dshmSV.shmDelete(req);
        System.out.println("查询结果：" + shmDelete);
    }
    
    @Ignore
    @Test
    public void testRefreshLoader() {
         
	    ReqParam param = new ReqParam();
	    param.setTableNames(new String[]{"bl_userinfo"});
	    param.setTableId(new String[]{"34"});
	    int success = dshmSV.refreshLoader(param);
        System.out.println("查询结果：" + success);
    }

    @Test
    public void testPagingTableInfo(){
    	PagingTableInfoRequest pagingTableInfoRequest = new PagingTableInfoRequest();
    	PageInfo<ShmTableInfoVo> pageInfo = new PageInfo<ShmTableInfoVo>();
    	pageInfo.setPageNo(2);
    	pageInfo.setPageSize(3);
    	pagingTableInfoRequest.setPageInfo(pageInfo);
    	System.out.println("请求参数：" + JSONObject.fromObject(pagingTableInfoRequest));
    	PageInfo<ShmTableInfoVo> retPage = dshmSV.pagingTableInfo(pagingTableInfoRequest);
    	System.out.println("请求结果：" + JSONObject.fromObject(retPage));
    	if(retPage!=null && retPage.getResult()!=null){
    		for(int i=0;i<retPage.getResult().size();i++){
    			System.out.println(retPage.getResult().get(i).getId());
    		}
    	}
    }
    @Test
    public void testQueryField(){
    	FieldQueryRequest request=new FieldQueryRequest();
    	request.setTableId(12000);
    	request.setTableName("cp_price_info");
    	System.out.println(JSON.toJSONString(dshmSV.getTableFieldRecord(request)));;
    }

}
