package se.zust.orm.entity;

import java.util.ArrayList;
import java.util.List;

public class RelationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RelationExample() {
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

        public Criteria andConcernIdIsNull() {
            addCriterion("concern_id is null");
            return (Criteria) this;
        }

        public Criteria andConcernIdIsNotNull() {
            addCriterion("concern_id is not null");
            return (Criteria) this;
        }

        public Criteria andConcernIdEqualTo(Integer value) {
            addCriterion("concern_id =", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotEqualTo(Integer value) {
            addCriterion("concern_id <>", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdGreaterThan(Integer value) {
            addCriterion("concern_id >", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("concern_id >=", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdLessThan(Integer value) {
            addCriterion("concern_id <", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdLessThanOrEqualTo(Integer value) {
            addCriterion("concern_id <=", value, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdIn(List<Integer> values) {
            addCriterion("concern_id in", values, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotIn(List<Integer> values) {
            addCriterion("concern_id not in", values, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdBetween(Integer value1, Integer value2) {
            addCriterion("concern_id between", value1, value2, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernIdNotBetween(Integer value1, Integer value2) {
            addCriterion("concern_id not between", value1, value2, "concernId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdIsNull() {
            addCriterion("concerned_id is null");
            return (Criteria) this;
        }

        public Criteria andConcernedIdIsNotNull() {
            addCriterion("concerned_id is not null");
            return (Criteria) this;
        }

        public Criteria andConcernedIdEqualTo(Integer value) {
            addCriterion("concerned_id =", value, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdNotEqualTo(Integer value) {
            addCriterion("concerned_id <>", value, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdGreaterThan(Integer value) {
            addCriterion("concerned_id >", value, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("concerned_id >=", value, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdLessThan(Integer value) {
            addCriterion("concerned_id <", value, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdLessThanOrEqualTo(Integer value) {
            addCriterion("concerned_id <=", value, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdIn(List<Integer> values) {
            addCriterion("concerned_id in", values, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdNotIn(List<Integer> values) {
            addCriterion("concerned_id not in", values, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdBetween(Integer value1, Integer value2) {
            addCriterion("concerned_id between", value1, value2, "concernedId");
            return (Criteria) this;
        }

        public Criteria andConcernedIdNotBetween(Integer value1, Integer value2) {
            addCriterion("concerned_id not between", value1, value2, "concernedId");
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