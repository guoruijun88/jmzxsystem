package com.jm.pojo;

import java.util.ArrayList;
import java.util.List;

public class FunsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FunsExample() {
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

        public Criteria andFunidIsNull() {
            addCriterion("funid is null");
            return (Criteria) this;
        }

        public Criteria andFunidIsNotNull() {
            addCriterion("funid is not null");
            return (Criteria) this;
        }

        public Criteria andFunidEqualTo(Integer value) {
            addCriterion("funid =", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidNotEqualTo(Integer value) {
            addCriterion("funid <>", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidGreaterThan(Integer value) {
            addCriterion("funid >", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidGreaterThanOrEqualTo(Integer value) {
            addCriterion("funid >=", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidLessThan(Integer value) {
            addCriterion("funid <", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidLessThanOrEqualTo(Integer value) {
            addCriterion("funid <=", value, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidIn(List<Integer> values) {
            addCriterion("funid in", values, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidNotIn(List<Integer> values) {
            addCriterion("funid not in", values, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidBetween(Integer value1, Integer value2) {
            addCriterion("funid between", value1, value2, "funid");
            return (Criteria) this;
        }

        public Criteria andFunidNotBetween(Integer value1, Integer value2) {
            addCriterion("funid not between", value1, value2, "funid");
            return (Criteria) this;
        }

        public Criteria andMenuidIsNull() {
            addCriterion("menuid is null");
            return (Criteria) this;
        }

        public Criteria andMenuidIsNotNull() {
            addCriterion("menuid is not null");
            return (Criteria) this;
        }

        public Criteria andMenuidEqualTo(Integer value) {
            addCriterion("menuid =", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotEqualTo(Integer value) {
            addCriterion("menuid <>", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidGreaterThan(Integer value) {
            addCriterion("menuid >", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("menuid >=", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLessThan(Integer value) {
            addCriterion("menuid <", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidLessThanOrEqualTo(Integer value) {
            addCriterion("menuid <=", value, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidIn(List<Integer> values) {
            addCriterion("menuid in", values, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotIn(List<Integer> values) {
            addCriterion("menuid not in", values, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidBetween(Integer value1, Integer value2) {
            addCriterion("menuid between", value1, value2, "menuid");
            return (Criteria) this;
        }

        public Criteria andMenuidNotBetween(Integer value1, Integer value2) {
            addCriterion("menuid not between", value1, value2, "menuid");
            return (Criteria) this;
        }

        public Criteria andFunnameIsNull() {
            addCriterion("funname is null");
            return (Criteria) this;
        }

        public Criteria andFunnameIsNotNull() {
            addCriterion("funname is not null");
            return (Criteria) this;
        }

        public Criteria andFunnameEqualTo(String value) {
            addCriterion("funname =", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameNotEqualTo(String value) {
            addCriterion("funname <>", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameGreaterThan(String value) {
            addCriterion("funname >", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameGreaterThanOrEqualTo(String value) {
            addCriterion("funname >=", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameLessThan(String value) {
            addCriterion("funname <", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameLessThanOrEqualTo(String value) {
            addCriterion("funname <=", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameLike(String value) {
            addCriterion("funname like", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameNotLike(String value) {
            addCriterion("funname not like", value, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameIn(List<String> values) {
            addCriterion("funname in", values, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameNotIn(List<String> values) {
            addCriterion("funname not in", values, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameBetween(String value1, String value2) {
            addCriterion("funname between", value1, value2, "funname");
            return (Criteria) this;
        }

        public Criteria andFunnameNotBetween(String value1, String value2) {
            addCriterion("funname not between", value1, value2, "funname");
            return (Criteria) this;
        }

        public Criteria andFunurlIsNull() {
            addCriterion("funurl is null");
            return (Criteria) this;
        }

        public Criteria andFunurlIsNotNull() {
            addCriterion("funurl is not null");
            return (Criteria) this;
        }

        public Criteria andFunurlEqualTo(String value) {
            addCriterion("funurl =", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlNotEqualTo(String value) {
            addCriterion("funurl <>", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlGreaterThan(String value) {
            addCriterion("funurl >", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlGreaterThanOrEqualTo(String value) {
            addCriterion("funurl >=", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlLessThan(String value) {
            addCriterion("funurl <", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlLessThanOrEqualTo(String value) {
            addCriterion("funurl <=", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlLike(String value) {
            addCriterion("funurl like", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlNotLike(String value) {
            addCriterion("funurl not like", value, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlIn(List<String> values) {
            addCriterion("funurl in", values, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlNotIn(List<String> values) {
            addCriterion("funurl not in", values, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlBetween(String value1, String value2) {
            addCriterion("funurl between", value1, value2, "funurl");
            return (Criteria) this;
        }

        public Criteria andFunurlNotBetween(String value1, String value2) {
            addCriterion("funurl not between", value1, value2, "funurl");
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