package com.shanzha.moduls.article.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InviteAnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InviteAnswerExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andInviterIdIsNull() {
            addCriterion("inviter_id is null");
            return (Criteria) this;
        }

        public Criteria andInviterIdIsNotNull() {
            addCriterion("inviter_id is not null");
            return (Criteria) this;
        }

        public Criteria andInviterIdEqualTo(Long value) {
            addCriterion("inviter_id =", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotEqualTo(Long value) {
            addCriterion("inviter_id <>", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdGreaterThan(Long value) {
            addCriterion("inviter_id >", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdGreaterThanOrEqualTo(Long value) {
            addCriterion("inviter_id >=", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdLessThan(Long value) {
            addCriterion("inviter_id <", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdLessThanOrEqualTo(Long value) {
            addCriterion("inviter_id <=", value, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdIn(List<Long> values) {
            addCriterion("inviter_id in", values, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotIn(List<Long> values) {
            addCriterion("inviter_id not in", values, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdBetween(Long value1, Long value2) {
            addCriterion("inviter_id between", value1, value2, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInviterIdNotBetween(Long value1, Long value2) {
            addCriterion("inviter_id not between", value1, value2, "inviterId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdIsNull() {
            addCriterion("invited_id is null");
            return (Criteria) this;
        }

        public Criteria andInvitedIdIsNotNull() {
            addCriterion("invited_id is not null");
            return (Criteria) this;
        }

        public Criteria andInvitedIdEqualTo(Long value) {
            addCriterion("invited_id =", value, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdNotEqualTo(Long value) {
            addCriterion("invited_id <>", value, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdGreaterThan(Long value) {
            addCriterion("invited_id >", value, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("invited_id >=", value, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdLessThan(Long value) {
            addCriterion("invited_id <", value, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdLessThanOrEqualTo(Long value) {
            addCriterion("invited_id <=", value, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdIn(List<Long> values) {
            addCriterion("invited_id in", values, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdNotIn(List<Long> values) {
            addCriterion("invited_id not in", values, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdBetween(Long value1, Long value2) {
            addCriterion("invited_id between", value1, value2, "invitedId");
            return (Criteria) this;
        }

        public Criteria andInvitedIdNotBetween(Long value1, Long value2) {
            addCriterion("invited_id not between", value1, value2, "invitedId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNull() {
            addCriterion("article_id is null");
            return (Criteria) this;
        }

        public Criteria andArticleIdIsNotNull() {
            addCriterion("article_id is not null");
            return (Criteria) this;
        }

        public Criteria andArticleIdEqualTo(Long value) {
            addCriterion("article_id =", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotEqualTo(Long value) {
            addCriterion("article_id <>", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThan(Long value) {
            addCriterion("article_id >", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("article_id >=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThan(Long value) {
            addCriterion("article_id <", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdLessThanOrEqualTo(Long value) {
            addCriterion("article_id <=", value, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdIn(List<Long> values) {
            addCriterion("article_id in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotIn(List<Long> values) {
            addCriterion("article_id not in", values, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdBetween(Long value1, Long value2) {
            addCriterion("article_id between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andArticleIdNotBetween(Long value1, Long value2) {
            addCriterion("article_id not between", value1, value2, "articleId");
            return (Criteria) this;
        }

        public Criteria andInviteDateIsNull() {
            addCriterion("invite_date is null");
            return (Criteria) this;
        }

        public Criteria andInviteDateIsNotNull() {
            addCriterion("invite_date is not null");
            return (Criteria) this;
        }

        public Criteria andInviteDateEqualTo(Date value) {
            addCriterion("invite_date =", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateNotEqualTo(Date value) {
            addCriterion("invite_date <>", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateGreaterThan(Date value) {
            addCriterion("invite_date >", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("invite_date >=", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateLessThan(Date value) {
            addCriterion("invite_date <", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateLessThanOrEqualTo(Date value) {
            addCriterion("invite_date <=", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateIn(List<Date> values) {
            addCriterion("invite_date in", values, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateNotIn(List<Date> values) {
            addCriterion("invite_date not in", values, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateBetween(Date value1, Date value2) {
            addCriterion("invite_date between", value1, value2, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateNotBetween(Date value1, Date value2) {
            addCriterion("invite_date not between", value1, value2, "inviteDate");
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