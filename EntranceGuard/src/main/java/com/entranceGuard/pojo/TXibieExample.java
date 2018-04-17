package com.entranceGuard.pojo;

import java.util.ArrayList;
import java.util.List;

public class TXibieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TXibieExample() {
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

        public Criteria andXibieidIsNull() {
            addCriterion("xibieID is null");
            return (Criteria) this;
        }

        public Criteria andXibieidIsNotNull() {
            addCriterion("xibieID is not null");
            return (Criteria) this;
        }

        public Criteria andXibieidEqualTo(Long value) {
            addCriterion("xibieID =", value, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidNotEqualTo(Long value) {
            addCriterion("xibieID <>", value, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidGreaterThan(Long value) {
            addCriterion("xibieID >", value, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidGreaterThanOrEqualTo(Long value) {
            addCriterion("xibieID >=", value, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidLessThan(Long value) {
            addCriterion("xibieID <", value, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidLessThanOrEqualTo(Long value) {
            addCriterion("xibieID <=", value, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidIn(List<Long> values) {
            addCriterion("xibieID in", values, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidNotIn(List<Long> values) {
            addCriterion("xibieID not in", values, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidBetween(Long value1, Long value2) {
            addCriterion("xibieID between", value1, value2, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibieidNotBetween(Long value1, Long value2) {
            addCriterion("xibieID not between", value1, value2, "xibieid");
            return (Criteria) this;
        }

        public Criteria andXibienameIsNull() {
            addCriterion("xibieName is null");
            return (Criteria) this;
        }

        public Criteria andXibienameIsNotNull() {
            addCriterion("xibieName is not null");
            return (Criteria) this;
        }

        public Criteria andXibienameEqualTo(String value) {
            addCriterion("xibieName =", value, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameNotEqualTo(String value) {
            addCriterion("xibieName <>", value, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameGreaterThan(String value) {
            addCriterion("xibieName >", value, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameGreaterThanOrEqualTo(String value) {
            addCriterion("xibieName >=", value, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameLessThan(String value) {
            addCriterion("xibieName <", value, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameLessThanOrEqualTo(String value) {
            addCriterion("xibieName <=", value, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameLike(String value) {
            addCriterion("xibieName like", value, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameNotLike(String value) {
            addCriterion("xibieName not like", value, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameIn(List<String> values) {
            addCriterion("xibieName in", values, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameNotIn(List<String> values) {
            addCriterion("xibieName not in", values, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameBetween(String value1, String value2) {
            addCriterion("xibieName between", value1, value2, "xibiename");
            return (Criteria) this;
        }

        public Criteria andXibienameNotBetween(String value1, String value2) {
            addCriterion("xibieName not between", value1, value2, "xibiename");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNull() {
            addCriterion("isUse is null");
            return (Criteria) this;
        }

        public Criteria andIsuseIsNotNull() {
            addCriterion("isUse is not null");
            return (Criteria) this;
        }

        public Criteria andIsuseEqualTo(String value) {
            addCriterion("isUse =", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotEqualTo(String value) {
            addCriterion("isUse <>", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThan(String value) {
            addCriterion("isUse >", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseGreaterThanOrEqualTo(String value) {
            addCriterion("isUse >=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThan(String value) {
            addCriterion("isUse <", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLessThanOrEqualTo(String value) {
            addCriterion("isUse <=", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseLike(String value) {
            addCriterion("isUse like", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotLike(String value) {
            addCriterion("isUse not like", value, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseIn(List<String> values) {
            addCriterion("isUse in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotIn(List<String> values) {
            addCriterion("isUse not in", values, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseBetween(String value1, String value2) {
            addCriterion("isUse between", value1, value2, "isuse");
            return (Criteria) this;
        }

        public Criteria andIsuseNotBetween(String value1, String value2) {
            addCriterion("isUse not between", value1, value2, "isuse");
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