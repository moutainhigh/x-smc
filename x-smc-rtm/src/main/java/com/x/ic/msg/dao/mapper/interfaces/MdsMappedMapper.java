package com.x.ic.msg.dao.mapper.interfaces;

import com.x.ic.msg.dao.mapper.bo.MdsMapped;
import com.x.ic.msg.dao.mapper.bo.MdsMappedExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MdsMappedMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mds_mapped
     *
     * @mbg.generated Tue Jun 26 14:20:56 CST 2018
     */
    long countByExample(MdsMappedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mds_mapped
     *
     * @mbg.generated Tue Jun 26 14:20:56 CST 2018
     */
    int deleteByExample(MdsMappedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mds_mapped
     *
     * @mbg.generated Tue Jun 26 14:20:56 CST 2018
     */
    int insert(MdsMapped record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mds_mapped
     *
     * @mbg.generated Tue Jun 26 14:20:56 CST 2018
     */
    int insertSelective(MdsMapped record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mds_mapped
     *
     * @mbg.generated Tue Jun 26 14:20:56 CST 2018
     */
    List<MdsMapped> selectByExample(MdsMappedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mds_mapped
     *
     * @mbg.generated Tue Jun 26 14:20:56 CST 2018
     */
    int updateByExampleSelective(@Param("record") MdsMapped record, @Param("example") MdsMappedExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table mds_mapped
     *
     * @mbg.generated Tue Jun 26 14:20:56 CST 2018
     */
    int updateByExample(@Param("record") MdsMapped record, @Param("example") MdsMappedExample example);
}