package org.ys.core.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.ys.core.model.CoreUser;
import org.ys.core.model.CoreUserExample;

public interface CoreUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    long countByExample(CoreUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    int deleteByExample(CoreUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long coreUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    int insert(CoreUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    int insertSelective(CoreUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    List<CoreUser> selectByExample(CoreUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    CoreUser selectByPrimaryKey(Long coreUserId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CoreUser record, @Param("example") CoreUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CoreUser record, @Param("example") CoreUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CoreUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CoreUser record);
}