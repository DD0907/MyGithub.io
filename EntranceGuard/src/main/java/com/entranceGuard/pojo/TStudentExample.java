package com.entranceGuard.pojo;

import java.util.ArrayList;
import java.util.List;

public class TStudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TStudentExample() {
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

        public Criteria andStuidIsNull() {
            addCriterion("stuID is null");
            return (Criteria) this;
        }

        public Criteria andStuidIsNotNull() {
            addCriterion("stuID is not null");
            return (Criteria) this;
        }

        public Criteria andStuidEqualTo(String value) {
            addCriterion("stuID =", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotEqualTo(String value) {
            addCriterion("stuID <>", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidGreaterThan(String value) {
            addCriterion("stuID >", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidGreaterThanOrEqualTo(String value) {
            addCriterion("stuID >=", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLessThan(String value) {
            addCriterion("stuID <", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLessThanOrEqualTo(String value) {
            addCriterion("stuID <=", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLike(String value) {
            addCriterion("stuID like", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotLike(String value) {
            addCriterion("stuID not like", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidIn(List<String> values) {
            addCriterion("stuID in", values, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotIn(List<String> values) {
            addCriterion("stuID not in", values, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidBetween(String value1, String value2) {
            addCriterion("stuID between", value1, value2, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotBetween(String value1, String value2) {
            addCriterion("stuID not between", value1, value2, "stuid");
            return (Criteria) this;
        }

        public Criteria andStunameIsNull() {
            addCriterion("stuName is null");
            return (Criteria) this;
        }

        public Criteria andStunameIsNotNull() {
            addCriterion("stuName is not null");
            return (Criteria) this;
        }

        public Criteria andStunameEqualTo(String value) {
            addCriterion("stuName =", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotEqualTo(String value) {
            addCriterion("stuName <>", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameGreaterThan(String value) {
            addCriterion("stuName >", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameGreaterThanOrEqualTo(String value) {
            addCriterion("stuName >=", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLessThan(String value) {
            addCriterion("stuName <", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLessThanOrEqualTo(String value) {
            addCriterion("stuName <=", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameLike(String value) {
            addCriterion("stuName like", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotLike(String value) {
            addCriterion("stuName not like", value, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameIn(List<String> values) {
            addCriterion("stuName in", values, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotIn(List<String> values) {
            addCriterion("stuName not in", values, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameBetween(String value1, String value2) {
            addCriterion("stuName between", value1, value2, "stuname");
            return (Criteria) this;
        }

        public Criteria andStunameNotBetween(String value1, String value2) {
            addCriterion("stuName not between", value1, value2, "stuname");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("classID is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("classID is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Integer value) {
            addCriterion("classID =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Integer value) {
            addCriterion("classID <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Integer value) {
            addCriterion("classID >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("classID >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Integer value) {
            addCriterion("classID <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Integer value) {
            addCriterion("classID <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Integer> values) {
            addCriterion("classID in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Integer> values) {
            addCriterion("classID not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Integer value1, Integer value2) {
            addCriterion("classID between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("classID not between", value1, value2, "classid");
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

        public Criteria andLouhaoidIsNull() {
            addCriterion("louhaoID is null");
            return (Criteria) this;
        }

        public Criteria andLouhaoidIsNotNull() {
            addCriterion("louhaoID is not null");
            return (Criteria) this;
        }

        public Criteria andLouhaoidEqualTo(String value) {
            addCriterion("louhaoID =", value, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidNotEqualTo(String value) {
            addCriterion("louhaoID <>", value, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidGreaterThan(String value) {
            addCriterion("louhaoID >", value, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidGreaterThanOrEqualTo(String value) {
            addCriterion("louhaoID >=", value, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidLessThan(String value) {
            addCriterion("louhaoID <", value, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidLessThanOrEqualTo(String value) {
            addCriterion("louhaoID <=", value, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidLike(String value) {
            addCriterion("louhaoID like", value, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidNotLike(String value) {
            addCriterion("louhaoID not like", value, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidIn(List<String> values) {
            addCriterion("louhaoID in", values, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidNotIn(List<String> values) {
            addCriterion("louhaoID not in", values, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidBetween(String value1, String value2) {
            addCriterion("louhaoID between", value1, value2, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andLouhaoidNotBetween(String value1, String value2) {
            addCriterion("louhaoID not between", value1, value2, "louhaoid");
            return (Criteria) this;
        }

        public Criteria andQinshihaoIsNull() {
            addCriterion("qinshihao is null");
            return (Criteria) this;
        }

        public Criteria andQinshihaoIsNotNull() {
            addCriterion("qinshihao is not null");
            return (Criteria) this;
        }

        public Criteria andQinshihaoEqualTo(String value) {
            addCriterion("qinshihao =", value, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoNotEqualTo(String value) {
            addCriterion("qinshihao <>", value, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoGreaterThan(String value) {
            addCriterion("qinshihao >", value, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoGreaterThanOrEqualTo(String value) {
            addCriterion("qinshihao >=", value, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoLessThan(String value) {
            addCriterion("qinshihao <", value, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoLessThanOrEqualTo(String value) {
            addCriterion("qinshihao <=", value, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoLike(String value) {
            addCriterion("qinshihao like", value, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoNotLike(String value) {
            addCriterion("qinshihao not like", value, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoIn(List<String> values) {
            addCriterion("qinshihao in", values, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoNotIn(List<String> values) {
            addCriterion("qinshihao not in", values, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoBetween(String value1, String value2) {
            addCriterion("qinshihao between", value1, value2, "qinshihao");
            return (Criteria) this;
        }

        public Criteria andQinshihaoNotBetween(String value1, String value2) {
            addCriterion("qinshihao not between", value1, value2, "qinshihao");
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