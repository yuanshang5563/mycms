package org.ys.core.model;

import java.io.Serializable;
import java.util.Date;

public class CoreParameter implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4534483465953647116L;

	/**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_parameter.core_param_id
     *
     * @mbg.generated
     */
    private Long coreParamId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_parameter.param_name
     *
     * @mbg.generated
     */
    private String paramName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_parameter.param_type
     *
     * @mbg.generated
     */
    private String paramType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_parameter.param_code
     *
     * @mbg.generated
     */
    private String paramCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_parameter.param_value
     *
     * @mbg.generated
     */
    private String paramValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_parameter.param_desc
     *
     * @mbg.generated
     */
    private String paramDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_parameter.created_time
     *
     * @mbg.generated
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column core_parameter.modified_time
     *
     * @mbg.generated
     */
    private Date modifiedTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_parameter.core_param_id
     *
     * @return the value of core_parameter.core_param_id
     *
     * @mbg.generated
     */
    public Long getCoreParamId() {
        return coreParamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_parameter.core_param_id
     *
     * @param coreParamId the value for core_parameter.core_param_id
     *
     * @mbg.generated
     */
    public void setCoreParamId(Long coreParamId) {
        this.coreParamId = coreParamId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_parameter.param_name
     *
     * @return the value of core_parameter.param_name
     *
     * @mbg.generated
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_parameter.param_name
     *
     * @param paramName the value for core_parameter.param_name
     *
     * @mbg.generated
     */
    public void setParamName(String paramName) {
        this.paramName = paramName == null ? null : paramName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_parameter.param_type
     *
     * @return the value of core_parameter.param_type
     *
     * @mbg.generated
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_parameter.param_type
     *
     * @param paramType the value for core_parameter.param_type
     *
     * @mbg.generated
     */
    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_parameter.param_code
     *
     * @return the value of core_parameter.param_code
     *
     * @mbg.generated
     */
    public String getParamCode() {
        return paramCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_parameter.param_code
     *
     * @param paramCode the value for core_parameter.param_code
     *
     * @mbg.generated
     */
    public void setParamCode(String paramCode) {
        this.paramCode = paramCode == null ? null : paramCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_parameter.param_value
     *
     * @return the value of core_parameter.param_value
     *
     * @mbg.generated
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_parameter.param_value
     *
     * @param paramValue the value for core_parameter.param_value
     *
     * @mbg.generated
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue == null ? null : paramValue.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_parameter.param_desc
     *
     * @return the value of core_parameter.param_desc
     *
     * @mbg.generated
     */
    public String getParamDesc() {
        return paramDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_parameter.param_desc
     *
     * @param paramDesc the value for core_parameter.param_desc
     *
     * @mbg.generated
     */
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc == null ? null : paramDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_parameter.created_time
     *
     * @return the value of core_parameter.created_time
     *
     * @mbg.generated
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_parameter.created_time
     *
     * @param createdTime the value for core_parameter.created_time
     *
     * @mbg.generated
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column core_parameter.modified_time
     *
     * @return the value of core_parameter.modified_time
     *
     * @mbg.generated
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column core_parameter.modified_time
     *
     * @param modifiedTime the value for core_parameter.modified_time
     *
     * @mbg.generated
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_parameter
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
        CoreParameter other = (CoreParameter) that;
        return (this.getCoreParamId() == null ? other.getCoreParamId() == null : this.getCoreParamId().equals(other.getCoreParamId()))
            && (this.getParamName() == null ? other.getParamName() == null : this.getParamName().equals(other.getParamName()))
            && (this.getParamType() == null ? other.getParamType() == null : this.getParamType().equals(other.getParamType()))
            && (this.getParamCode() == null ? other.getParamCode() == null : this.getParamCode().equals(other.getParamCode()))
            && (this.getParamValue() == null ? other.getParamValue() == null : this.getParamValue().equals(other.getParamValue()))
            && (this.getParamDesc() == null ? other.getParamDesc() == null : this.getParamDesc().equals(other.getParamDesc()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getModifiedTime() == null ? other.getModifiedTime() == null : this.getModifiedTime().equals(other.getModifiedTime()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_parameter
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCoreParamId() == null) ? 0 : getCoreParamId().hashCode());
        result = prime * result + ((getParamName() == null) ? 0 : getParamName().hashCode());
        result = prime * result + ((getParamType() == null) ? 0 : getParamType().hashCode());
        result = prime * result + ((getParamCode() == null) ? 0 : getParamCode().hashCode());
        result = prime * result + ((getParamValue() == null) ? 0 : getParamValue().hashCode());
        result = prime * result + ((getParamDesc() == null) ? 0 : getParamDesc().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getModifiedTime() == null) ? 0 : getModifiedTime().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_parameter
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coreParamId=").append(coreParamId);
        sb.append(", paramName=").append(paramName);
        sb.append(", paramType=").append(paramType);
        sb.append(", paramCode=").append(paramCode);
        sb.append(", paramValue=").append(paramValue);
        sb.append(", paramDesc=").append(paramDesc);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", modifiedTime=").append(modifiedTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}