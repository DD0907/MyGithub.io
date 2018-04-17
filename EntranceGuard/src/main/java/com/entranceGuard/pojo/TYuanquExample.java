package com.entranceGuard.pojo;

import java.util.ArrayList;
import java.util.List;

public class TYuanquExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TYuanquExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
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

        public Criteria andYuanquidIsNull() {
            addCriterion("yuanquID is null");
            return (Criteria) this;
        }

        public Criteria andYuanquidIsNotNull() {
            addCriterion("yuanquID is not null");
            return (Criteria) this;
        }

        public Criteria andYuanquidEqualTo(String value) {
            addCriterion("yuanquID =", value, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidNotEqualTo(String value) {
            addCriterion("yuanquID <>", value, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidGreaterThan(String value) {
            addCriterion("yuanquID >", value, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidGreaterThanOrEqualTo(String value) {
            addCriterion("yuanquID >=", value, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidLessThan(String value) {
            addCriterion("yuanquID <", value, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidLessThanOrEqualTo(String value) {
            addCriterion("yuanquID <=", value, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidLike(String value) {
            addCriterion("yuanquID like", value, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidNotLike(String value) {
            addCriterion("yuanquID not like", value, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidIn(List<String> values) {
            addCriterion("yuanquID in", values, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidNotIn(List<String> values) {
            addCriterion("yuanquID not in", values, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidBetween(String value1, String value2) {
            addCriterion("yuanquID between", value1, value2, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanquidNotBetween(String value1, String value2) {
            addCriterion("yuanquID not between", value1, value2, "yuanquid");
            return (Criteria) this;
        }

        public Criteria andYuanqunameIsNull() {
            addCriterion("yuanquName is null");
            return (Criteria) this;
        }

        public Criteria andYuanqunameIsNotNull() {
            addCriterion("yuanquName is not null");
            return (Criteria) this;
        }

        public Criteria andYuanqunameEqualTo(String value) {
            addCriterion("yuanquName =", value, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameNotEqualTo(String value) {
            addCriterion("yuanquName <>", value, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameGreaterThan(String value) {
            addCriterion("yuanquName >", value, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameGreaterThanOrEqualTo(String value) {
            addCriterion("yuanquName >=", value, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameLessThan(String value) {
            addCriterion("yuanquName <", value, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameLessThanOrEqualTo(String value) {
            addCriterion("yuanquName <=", value, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameLike(String value) {
            addCriterion("yuanquName like", value, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameNotLike(String value) {
            addCriterion("yuanquName not like", value, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameIn(List<String> values) {
            addCriterion("yuanquName in", values, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameNotIn(List<String> values) {
            addCriterion("yuanquName not in", values, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameBetween(String value1, String value2) {
            addCriterion("yuanquName between", value1, value2, "yuanquname");
            return (Criteria) this;
        }

        public Criteria andYuanqunameNotBetween(String value1, String value2) {
            addCriterion("yuanquName not between", value1, value2, "yuanquname");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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