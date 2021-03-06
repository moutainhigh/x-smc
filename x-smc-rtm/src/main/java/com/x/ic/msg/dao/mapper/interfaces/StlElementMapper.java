package com.x.ic.msg.dao.mapper.interfaces;

import com.x.ic.msg.dao.mapper.bo.StlElement;
import com.x.ic.msg.dao.mapper.bo.StlElementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StlElementMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	long countByExample(StlElementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	int deleteByExample(StlElementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	int deleteByPrimaryKey(Long elementId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	int insert(StlElement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	int insertSelective(StlElement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	List<StlElement> selectByExample(StlElementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	StlElement selectByPrimaryKey(Long elementId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	int updateByExampleSelective(@Param("record") StlElement record, @Param("example") StlElementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	int updateByExample(@Param("record") StlElement record, @Param("example") StlElementExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	int updateByPrimaryKeySelective(StlElement record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table stl_element
	 * @mbg.generated  Tue Jul 03 15:25:40 CST 2018
	 */
	int updateByPrimaryKey(StlElement record);
}