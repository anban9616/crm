package zhku.zhou.crm.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoleExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andCrtmIsNull() {
            addCriterion("crtm is null");
            return (Criteria) this;
        }

        public Criteria andCrtmIsNotNull() {
            addCriterion("crtm is not null");
            return (Criteria) this;
        }

        public Criteria andCrtmEqualTo(Date value) {
            addCriterion("crtm =", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmNotEqualTo(Date value) {
            addCriterion("crtm <>", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmGreaterThan(Date value) {
            addCriterion("crtm >", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmGreaterThanOrEqualTo(Date value) {
            addCriterion("crtm >=", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmLessThan(Date value) {
            addCriterion("crtm <", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmLessThanOrEqualTo(Date value) {
            addCriterion("crtm <=", value, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmIn(List<Date> values) {
            addCriterion("crtm in", values, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmNotIn(List<Date> values) {
            addCriterion("crtm not in", values, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmBetween(Date value1, Date value2) {
            addCriterion("crtm between", value1, value2, "crtm");
            return (Criteria) this;
        }

        public Criteria andCrtmNotBetween(Date value1, Date value2) {
            addCriterion("crtm not between", value1, value2, "crtm");
            return (Criteria) this;
        }

        public Criteria andMdtmIsNull() {
            addCriterion("mdtm is null");
            return (Criteria) this;
        }

        public Criteria andMdtmIsNotNull() {
            addCriterion("mdtm is not null");
            return (Criteria) this;
        }

        public Criteria andMdtmEqualTo(Date value) {
            addCriterion("mdtm =", value, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmNotEqualTo(Date value) {
            addCriterion("mdtm <>", value, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmGreaterThan(Date value) {
            addCriterion("mdtm >", value, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmGreaterThanOrEqualTo(Date value) {
            addCriterion("mdtm >=", value, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmLessThan(Date value) {
            addCriterion("mdtm <", value, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmLessThanOrEqualTo(Date value) {
            addCriterion("mdtm <=", value, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmIn(List<Date> values) {
            addCriterion("mdtm in", values, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmNotIn(List<Date> values) {
            addCriterion("mdtm not in", values, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmBetween(Date value1, Date value2) {
            addCriterion("mdtm between", value1, value2, "mdtm");
            return (Criteria) this;
        }

        public Criteria andMdtmNotBetween(Date value1, Date value2) {
            addCriterion("mdtm not between", value1, value2, "mdtm");
            return (Criteria) this;
        }

        public Criteria andSysPowerIsNull() {
            addCriterion("sys_power is null");
            return (Criteria) this;
        }

        public Criteria andSysPowerIsNotNull() {
            addCriterion("sys_power is not null");
            return (Criteria) this;
        }

        public Criteria andSysPowerEqualTo(Integer value) {
            addCriterion("sys_power =", value, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerNotEqualTo(Integer value) {
            addCriterion("sys_power <>", value, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerGreaterThan(Integer value) {
            addCriterion("sys_power >", value, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_power >=", value, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerLessThan(Integer value) {
            addCriterion("sys_power <", value, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerLessThanOrEqualTo(Integer value) {
            addCriterion("sys_power <=", value, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerIn(List<Integer> values) {
            addCriterion("sys_power in", values, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerNotIn(List<Integer> values) {
            addCriterion("sys_power not in", values, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerBetween(Integer value1, Integer value2) {
            addCriterion("sys_power between", value1, value2, "sysPower");
            return (Criteria) this;
        }

        public Criteria andSysPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_power not between", value1, value2, "sysPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerIsNull() {
            addCriterion("cus_power is null");
            return (Criteria) this;
        }

        public Criteria andCusPowerIsNotNull() {
            addCriterion("cus_power is not null");
            return (Criteria) this;
        }

        public Criteria andCusPowerEqualTo(Integer value) {
            addCriterion("cus_power =", value, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerNotEqualTo(Integer value) {
            addCriterion("cus_power <>", value, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerGreaterThan(Integer value) {
            addCriterion("cus_power >", value, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerGreaterThanOrEqualTo(Integer value) {
            addCriterion("cus_power >=", value, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerLessThan(Integer value) {
            addCriterion("cus_power <", value, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerLessThanOrEqualTo(Integer value) {
            addCriterion("cus_power <=", value, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerIn(List<Integer> values) {
            addCriterion("cus_power in", values, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerNotIn(List<Integer> values) {
            addCriterion("cus_power not in", values, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerBetween(Integer value1, Integer value2) {
            addCriterion("cus_power between", value1, value2, "cusPower");
            return (Criteria) this;
        }

        public Criteria andCusPowerNotBetween(Integer value1, Integer value2) {
            addCriterion("cus_power not between", value1, value2, "cusPower");
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