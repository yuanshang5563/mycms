package org.ys.core.model;

import java.io.Serializable;

public class CoreDept implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_dept.core_dept_id
     *
     * @mbg.generated
     */
    private Long coreDeptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_dept.parent_core_dept_id
     *
     * @mbg.generated
     */
    private Long parentCoreDeptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_dept.dept_name
     *
     * @mbg.generated
     */
    private String deptName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_dept.dept_code
     *
     * @mbg.generated
     */
    private String deptCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_dept.dept_desc
     *
     * @mbg.generated
     */
    private String deptDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_dept.order_num
     *
     * @mbg.generated
     */
    private Integer orderNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_dept.del_flag
     *
     * @mbg.generated
     */
    private Integer delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table core_dept
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_dept.core_dept_id
     *
     * @return the value of core_dept.core_dept_id
     *
     * @mbg.generated
     */
    public Long getCoreDeptId() {
        return coreDeptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_dept.core_dept_id
     *
     * @param coreDeptId the value for core_dept.core_dept_id
     *
     * @mbg.generated
     */
    public void setCoreDeptId(Long coreDeptId) {
        this.coreDeptId = coreDeptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_dept.parent_core_dept_id
     *
     * @return the value of core_dept.parent_core_dept_id
     *
     * @mbg.generated
     */
    public Long getParentCoreDeptId() {
        return parentCoreDeptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_dept.parent_core_dept_id
     *
     * @param parentCoreDeptId the value for core_dept.parent_core_dept_id
     *
     * @mbg.generated
     */
    public void setParentCoreDeptId(Long parentCoreDeptId) {
        this.parentCoreDeptId = parentCoreDeptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_dept.dept_name
     *
     * @return the value of core_dept.dept_name
     *
     * @mbg.generated
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_dept.dept_name
     *
     * @param deptName the value for core_dept.dept_name
     *
     * @mbg.generated
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_dept.dept_code
     *
     * @return the value of core_dept.dept_code
     *
     * @mbg.generated
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_dept.dept_code
     *
     * @param deptCode the value for core_dept.dept_code
     *
     * @mbg.generated
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_dept.dept_desc
     *
     * @return the value of core_dept.dept_desc
     *
     * @mbg.generated
     */
    public String getDeptDesc() {
        return deptDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_dept.dept_desc
     *
     * @param deptDesc the value for core_dept.dept_desc
     *
     * @mbg.generated
     */
    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc == null ? null : deptDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_dept.order_num
     *
     * @return the value of core_dept.order_num
     *
     * @mbg.generated
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_dept.order_num
     *
     * @param orderNum the value for core_dept.order_num
     *
     * @mbg.generated
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_dept.del_flag
     *
     * @return the value of core_dept.del_flag
     *
     * @mbg.generated
     */
    public Integer getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_dept.del_flag
     *
     * @param delFlag the value for core_dept.del_flag
     *
     * @mbg.generated
     */
    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dept
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CoreDept other = (CoreDept) that;
        return (this.getCoreDeptId() == null ? other.getCoreDeptId() == null : this.getCoreDeptId().equals(other.getCoreDeptId()))
            && (this.getParentCoreDeptId() == null ? other.getParentCoreDeptId() == null : this.getParentCoreDeptId().equals(other.getParentCoreDeptId()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getDeptCode() == null ? other.getDeptCode() == null : this.getDeptCode().equals(other.getDeptCode()))
            && (this.getDeptDesc() == null ? other.getDeptDesc() == null : this.getDeptDesc().equals(other.getDeptDesc()))
            && (this.getOrderNum() == null ? other.getOrderNum() == null : this.getOrderNum().equals(other.getOrderNum()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dept
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCoreDeptId() == null) ? 0 : getCoreDeptId().hashCode());
        result = prime * result + ((getParentCoreDeptId() == null) ? 0 : getParentCoreDeptId().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getDeptCode() == null) ? 0 : getDeptCode().hashCode());
        result = prime * result + ((getDeptDesc() == null) ? 0 : getDeptDesc().hashCode());
        result = prime * result + ((getOrderNum() == null) ? 0 : getOrderNum().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dept
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coreDeptId=").append(coreDeptId);
        sb.append(", parentCoreDeptId=").append(parentCoreDeptId);
        sb.append(", deptName=").append(deptName);
        sb.append(", deptCode=").append(deptCode);
        sb.append(", deptDesc=").append(deptDesc);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}