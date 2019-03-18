package com.x.ic.dshm.api.dshmprocess.interfaces;

import com.x.base.exception.BusinessException;
import com.x.base.vo.PageInfo;
import com.x.ic.dshm.api.dshmprocess.params.*;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 共享内存dubbo服务<br>
 * Date: 2016年1月14日 <br>
 * Copyright (c) 2016 asiainfo.com <br>
 * 
 * @author biancx
 */
@Path("/dshmprocess")
@Consumes({ MediaType.APPLICATION_JSON })
@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public interface IdshmSV {

    /**
     * 对ebilling_shm_table_info表全量加载
     * 
     * @return 加载成功标识符 1表示成功，-1 表示不成功
     * @throws BusinessException
     * @author yangql
     * @ApiDocMethod
     * @ApiCode DSHM-0001
     * @RestRelativeURL sdhmprocess/fullLoader
     */
    @POST
    @Path("/fullLoader")
    public int fullLoader() throws BusinessException;

    /**
     * 根据前台请求将具体表刷进缓存
     * 
     * @param req
     *            请求参数
     * @return 加载成功标识符 1表示成功，-1 表示不成功
     * @throws BusinessException
     * @author yangql
     * @ApiDocMethod
     * @ApiCode DSHM-0002
     * @RestRelativeURL sdhmprocess/refreshLoader
     */
    @POST
    @Path("/refreshLoader")
    public int refreshLoader(ReqParam req) throws BusinessException;

    /**
     * 释放具体表空间的缓存
     * 
     * @param req
     *            请求参数
     * @return 加载成功标识符 1表示成功，-1 表示不成功
     * @throws BusinessException
     * @author yangql
     * @ApiDocMethod
     * @ApiCode DSHM-0003
     * @RestRelativeURL sdhmprocess/shmDelete
     */
    @POST
    @Path("/shmDelete")
    public int shmDelete(ReqParam req) throws BusinessException;

    /**
     * 提供给采集平台用于实时向缓存刷入数据
     * 
     * @param table_name
     *            表示实时加载数据的表名 obj 是实时加载的数据 ,type=1 表示insert，type=0表示更新（或者是新delete 再insert）
     * @return 1 表示加载成功，-1 表示加载失败
     * @throws BusinessException
     * @author biancx
     * @ApiDocMethod
     * @ApiCode DSHM-0004
     * @RestRelativeURL sdhmprocess/initLoader
     */
    @POST
    @Path("/initLoader")
    public Integer initLoader(InitParams params) throws BusinessException;

    /**
     * 提供给采集平台用于实时删除缓存中的数据
     * 
     * @param tableName
     *            实时删除的表名 obj 实时删除的数据
     * @return 1 表示加载成功，-1 表示加载失败
     * @throws BusinessException
     * @author biancx
     * @ApiDocMethod
     * @ApiCode DSHM-0005
     * @RestRelativeURL sdhmprocess/initdel
     */
    @POST
    @Path("/initdel")
    public Integer initdel(String tableName, Object obj) throws BusinessException;

    /**
     * 数据库列表服务
     * 
     * @return 所有数据库
     * @throws BusinessException
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode BaaS-0001
     * @RestRelativeURL sdhmprocess/ListDBName
     */
    @POST
    @Path("/ListDBName")
    public String[] ListDBName() throws BusinessException;

    /**
     * 数据库表名列表服务
     * 
     * @param request
     * @return 该数据库中的所有表名
     * @throws BusinessException
     * @author liangbs
     * @ApiDocMethod
     * @ApiCode BaaS-0003
     * @RestRelativeURL sdhmprocess/ListTableName
     */
    @POST
    @Path("/ListTableName")
    public List<String> ListTableName(TableQuery request) throws BusinessException;

    /**
     * 根据数据库信息和表信息显示所有列
     * 
     * @param dbName
     *            数据库名称
     * @param tableName
     *            要显示的表名
     * @return 该数据库中的所有列信息
     * @throws BusinessException
     * @author wangyx13
     * @ApiDocMethod
     * @ApiCode DSHM-00013
     * @RestRelativeURL sdhmprocess/ListFiledName
     */
    @POST
    @Path("/ListFiledName")
    public List<FieldInfo> ListFiledName(String dbName, String tableName) throws BusinessException;

    /**
     * 删除指定的表
     * 
     * @param tableInfos
     *            删除表信息<tableName,tableId>
     * @return 是否删除成功
     * @throws BusinessException
     * @author wangyx13
     * @ApiDocMethod
     * @ApiCode DSHM-00014
     * @RestRelativeURL sdhmprocess/deleteTable
     */
    @POST
    @Path("/deleteTable")
    public String deleteTable(Map<String, String> tableInfos) throws BusinessException;

    /**
     * 获取配置好的表列表
     * 
     * @param pagingTableInfoRequest
     * @return 配置在表中的表列表
     * @throws BusinessException
     * @author wuhf
     * @ApiDocMethod
     * @ApiCode DSHM-0006
     * @RestRelativeURL sdhmprocess/pagingTableInfo
     */
    @POST
    @Path("/pagingTableInfo")
    public PageInfo<ShmTableInfoVo> pagingTableInfo(PagingTableInfoRequest pagingTableInfoRequest)
            throws BusinessException;

    /**
     * 增加新表
     * 
     * @param addResult
     *            增加新表
     * @return 是否删除成功
     * @throws BusinessException
     * @author wangly
     * @ApiDocMethod
     * @ApiCode DSHM-00015
     * @RestRelativeURL sdhmprocess/addTable
     */
    @POST
    @Path("/addTable")
    public String addTable(AddEbillingShmTableRecord addResult) throws BusinessException;

    /**
     * 通过key获取通过hset存储的数值
     * 
     * @param tableKey
     * @param fieldKey
     * @return
     * @throws BusinessException
     * @author liangbs
     * @ApiDocMethod
     * @RestRelativeURL sdhmprocess/queryByHashKey
     */
    @POST
    @Path("/queryByHashKey")
    public String queryByHashKey(String tableKey, String fieldKey) throws BusinessException;

    /**
     * 删除在key和field在缓存中的存储
     * 
     * @param tableKey
     * @param fieldKey
     * @return
     * @throws BusinessException
     * @author liangbs
     * @ApiDocMethod
     * @RestRelativeURL sdhmprocess/delByHashKey
     */
    @POST
    @Path("/delByHashKey")
    public Long delByHashKey(String tableKey, String[] fieldKey) throws BusinessException;
    
    /**
     * 查询添加表时被添加的字段
     * @return
     * @throws BusinessException
     * @author gaogang
     * @ApiDocMethod
     * @ApiCode
     * @RestRelativeURL sdhmprocess/getTableFieldRecord
     */
    @POST
    @Path("/getTableFieldRecord")
    FieldListResponse getTableFieldRecord(FieldQueryRequest request) throws BusinessException; 

}