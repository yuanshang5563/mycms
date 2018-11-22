package org.ys.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CoreDictionariesExample implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -6990339632376447934L;

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public CoreDictionariesExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria implements Serializable{
        /**
		 * 
		 */
		private static final long serialVersionUID = 6817642536764495199L;
		protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCoreDictIdIsNull() {
            addCriterion("core_dict_id is null");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdIsNotNull() {
            addCriterion("core_dict_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdEqualTo(Long value) {
            addCriterion("core_dict_id =", value, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdNotEqualTo(Long value) {
            addCriterion("core_dict_id <>", value, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdGreaterThan(Long value) {
            addCriterion("core_dict_id >", value, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdGreaterThanOrEqualTo(Long value) {
            addCriterion("core_dict_id >=", value, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdLessThan(Long value) {
            addCriterion("core_dict_id <", value, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdLessThanOrEqualTo(Long value) {
            addCriterion("core_dict_id <=", value, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdIn(List<Long> values) {
            addCriterion("core_dict_id in", values, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdNotIn(List<Long> values) {
            addCriterion("core_dict_id not in", values, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdBetween(Long value1, Long value2) {
            addCriterion("core_dict_id between", value1, value2, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andCoreDictIdNotBetween(Long value1, Long value2) {
            addCriterion("core_dict_id not between", value1, value2, "coreDictId");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNull() {
            addCriterion("dict_code is null");
            return (Criteria) this;
        }

        public Criteria andDictCodeIsNotNull() {
            addCriterion("dict_code is not null");
            return (Criteria) this;
        }

        public Criteria andDictCodeEqualTo(String value) {
            addCriterion("dict_code =", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotEqualTo(String value) {
            addCriterion("dict_code <>", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThan(String value) {
            addCriterion("dict_code >", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeGreaterThanOrEqualTo(String value) {
            addCriterion("dict_code >=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThan(String value) {
            addCriterion("dict_code <", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLessThanOrEqualTo(String value) {
            addCriterion("dict_code <=", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeLike(String value) {
            addCriterion("dict_code like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotLike(String value) {
            addCriterion("dict_code not like", value, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeIn(List<String> values) {
            addCriterion("dict_code in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotIn(List<String> values) {
            addCriterion("dict_code not in", values, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeBetween(String value1, String value2) {
            addCriterion("dict_code between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictCodeNotBetween(String value1, String value2) {
            addCriterion("dict_code not between", value1, value2, "dictCode");
            return (Criteria) this;
        }

        public Criteria andDictValueIsNull() {
            addCriterion("dict_value is null");
            return (Criteria) this;
        }

        public Criteria andDictValueIsNotNull() {
            addCriterion("dict_value is not null");
            return (Criteria) this;
        }

        public Criteria andDictValueEqualTo(String value) {
            addCriterion("dict_value =", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotEqualTo(String value) {
            addCriterion("dict_value <>", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueGreaterThan(String value) {
            addCriterion("dict_value >", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueGreaterThanOrEqualTo(String value) {
            addCriterion("dict_value >=", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLessThan(String value) {
            addCriterion("dict_value <", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLessThanOrEqualTo(String value) {
            addCriterion("dict_value <=", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueLike(String value) {
            addCriterion("dict_value like", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotLike(String value) {
            addCriterion("dict_value not like", value, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueIn(List<String> values) {
            addCriterion("dict_value in", values, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotIn(List<String> values) {
            addCriterion("dict_value not in", values, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueBetween(String value1, String value2) {
            addCriterion("dict_value between", value1, value2, "dictValue");
            return (Criteria) this;
        }

        public Criteria andDictValueNotBetween(String value1, String value2) {
            addCriterion("dict_value not between", value1, value2, "dictValue");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdIsNull() {
            addCriterion("core_dict_group_id is null");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdIsNotNull() {
            addCriterion("core_dict_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdEqualTo(Long value) {
            addCriterion("core_dict_group_id =", value, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdNotEqualTo(Long value) {
            addCriterion("core_dict_group_id <>", value, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdGreaterThan(Long value) {
            addCriterion("core_dict_group_id >", value, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("core_dict_group_id >=", value, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdLessThan(Long value) {
            addCriterion("core_dict_group_id <", value, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("core_dict_group_id <=", value, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdIn(List<Long> values) {
            addCriterion("core_dict_group_id in", values, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdNotIn(List<Long> values) {
            addCriterion("core_dict_group_id not in", values, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdBetween(Long value1, Long value2) {
            addCriterion("core_dict_group_id between", value1, value2, "coreDictGroupId");
            return (Criteria) this;
        }

        public Criteria andCoreDictGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("core_dict_group_id not between", value1, value2, "coreDictGroupId");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table core_dictionaries
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        /**
		 * 
		 */
		private static final long serialVersionUID = 8102118156031357365L;

		protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table core_dictionaries
     *
     * @mbg.generated
     */
    public static class Criterion implements Serializable{
        /**
		 * 
		 */
		private static final long serialVersionUID = 2173388031322695968L;

		private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}