package com.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogStatisticsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BlogStatisticsExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNull() {
            addCriterion("blog_id is null");
            return (Criteria) this;
        }

        public Criteria andBlogIdIsNotNull() {
            addCriterion("blog_id is not null");
            return (Criteria) this;
        }

        public Criteria andBlogIdEqualTo(Integer value) {
            addCriterion("blog_id =", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotEqualTo(Integer value) {
            addCriterion("blog_id <>", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThan(Integer value) {
            addCriterion("blog_id >", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("blog_id >=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThan(Integer value) {
            addCriterion("blog_id <", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdLessThanOrEqualTo(Integer value) {
            addCriterion("blog_id <=", value, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdIn(List<Integer> values) {
            addCriterion("blog_id in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotIn(List<Integer> values) {
            addCriterion("blog_id not in", values, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdBetween(Integer value1, Integer value2) {
            addCriterion("blog_id between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andBlogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("blog_id not between", value1, value2, "blogId");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNull() {
            addCriterion("view_count is null");
            return (Criteria) this;
        }

        public Criteria andViewCountIsNotNull() {
            addCriterion("view_count is not null");
            return (Criteria) this;
        }

        public Criteria andViewCountEqualTo(Integer value) {
            addCriterion("view_count =", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotEqualTo(Integer value) {
            addCriterion("view_count <>", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThan(Integer value) {
            addCriterion("view_count >", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("view_count >=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThan(Integer value) {
            addCriterion("view_count <", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountLessThanOrEqualTo(Integer value) {
            addCriterion("view_count <=", value, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountIn(List<Integer> values) {
            addCriterion("view_count in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotIn(List<Integer> values) {
            addCriterion("view_count not in", values, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountBetween(Integer value1, Integer value2) {
            addCriterion("view_count between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andViewCountNotBetween(Integer value1, Integer value2) {
            addCriterion("view_count not between", value1, value2, "viewCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountIsNull() {
            addCriterion("reply_comment_count is null");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountIsNotNull() {
            addCriterion("reply_comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountEqualTo(Integer value) {
            addCriterion("reply_comment_count =", value, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountNotEqualTo(Integer value) {
            addCriterion("reply_comment_count <>", value, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountGreaterThan(Integer value) {
            addCriterion("reply_comment_count >", value, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("reply_comment_count >=", value, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountLessThan(Integer value) {
            addCriterion("reply_comment_count <", value, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("reply_comment_count <=", value, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountIn(List<Integer> values) {
            addCriterion("reply_comment_count in", values, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountNotIn(List<Integer> values) {
            addCriterion("reply_comment_count not in", values, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("reply_comment_count between", value1, value2, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andReplyCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("reply_comment_count not between", value1, value2, "replyCommentCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNull() {
            addCriterion("collect_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNotNull() {
            addCriterion("collect_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectCountEqualTo(Integer value) {
            addCriterion("collect_count =", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotEqualTo(Integer value) {
            addCriterion("collect_count <>", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThan(Integer value) {
            addCriterion("collect_count >", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_count >=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThan(Integer value) {
            addCriterion("collect_count <", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_count <=", value, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountIn(List<Integer> values) {
            addCriterion("collect_count in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotIn(List<Integer> values) {
            addCriterion("collect_count not in", values, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountBetween(Integer value1, Integer value2) {
            addCriterion("collect_count between", value1, value2, "collectCount");
            return (Criteria) this;
        }

        public Criteria andCollectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_count not between", value1, value2, "collectCount");
            return (Criteria) this;
        }

        public Criteria andShareCountIsNull() {
            addCriterion("share_count is null");
            return (Criteria) this;
        }

        public Criteria andShareCountIsNotNull() {
            addCriterion("share_count is not null");
            return (Criteria) this;
        }

        public Criteria andShareCountEqualTo(Integer value) {
            addCriterion("share_count =", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountNotEqualTo(Integer value) {
            addCriterion("share_count <>", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountGreaterThan(Integer value) {
            addCriterion("share_count >", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_count >=", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountLessThan(Integer value) {
            addCriterion("share_count <", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountLessThanOrEqualTo(Integer value) {
            addCriterion("share_count <=", value, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountIn(List<Integer> values) {
            addCriterion("share_count in", values, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountNotIn(List<Integer> values) {
            addCriterion("share_count not in", values, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountBetween(Integer value1, Integer value2) {
            addCriterion("share_count between", value1, value2, "shareCount");
            return (Criteria) this;
        }

        public Criteria andShareCountNotBetween(Integer value1, Integer value2) {
            addCriterion("share_count not between", value1, value2, "shareCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountIsNull() {
            addCriterion("admire_count is null");
            return (Criteria) this;
        }

        public Criteria andAdmireCountIsNotNull() {
            addCriterion("admire_count is not null");
            return (Criteria) this;
        }

        public Criteria andAdmireCountEqualTo(Integer value) {
            addCriterion("admire_count =", value, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountNotEqualTo(Integer value) {
            addCriterion("admire_count <>", value, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountGreaterThan(Integer value) {
            addCriterion("admire_count >", value, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("admire_count >=", value, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountLessThan(Integer value) {
            addCriterion("admire_count <", value, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountLessThanOrEqualTo(Integer value) {
            addCriterion("admire_count <=", value, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountIn(List<Integer> values) {
            addCriterion("admire_count in", values, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountNotIn(List<Integer> values) {
            addCriterion("admire_count not in", values, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountBetween(Integer value1, Integer value2) {
            addCriterion("admire_count between", value1, value2, "admireCount");
            return (Criteria) this;
        }

        public Criteria andAdmireCountNotBetween(Integer value1, Integer value2) {
            addCriterion("admire_count not between", value1, value2, "admireCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNull() {
            addCriterion("like_count is null");
            return (Criteria) this;
        }

        public Criteria andLikeCountIsNotNull() {
            addCriterion("like_count is not null");
            return (Criteria) this;
        }

        public Criteria andLikeCountEqualTo(Integer value) {
            addCriterion("like_count =", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotEqualTo(Integer value) {
            addCriterion("like_count <>", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThan(Integer value) {
            addCriterion("like_count >", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_count >=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThan(Integer value) {
            addCriterion("like_count <", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountLessThanOrEqualTo(Integer value) {
            addCriterion("like_count <=", value, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountIn(List<Integer> values) {
            addCriterion("like_count in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotIn(List<Integer> values) {
            addCriterion("like_count not in", values, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountBetween(Integer value1, Integer value2) {
            addCriterion("like_count between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andLikeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("like_count not between", value1, value2, "likeCount");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(Date value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(Date value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(Date value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(Date value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(Date value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<Date> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<Date> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(Date value1, Date value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(Date value1, Date value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
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