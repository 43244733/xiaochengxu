package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WxuserExample
{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WxuserExample()
    {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause)
    {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause()
    {
        return orderByClause;
    }

    public void setDistinct(boolean distinct)
    {
        this.distinct = distinct;
    }

    public boolean isDistinct()
    {
        return distinct;
    }

    public List<Criteria> getOredCriteria()
    {
        return oredCriteria;
    }

    public void or(Criteria criteria)
    {
        oredCriteria.add(criteria);
    }

    public Criteria or()
    {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria()
    {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0)
        {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal()
    {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear()
    {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria
    {
        protected List<Criterion> criteria;

        protected GeneratedCriteria()
        {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid()
        {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria()
        {
            return criteria;
        }

        public List<Criterion> getCriteria()
        {
            return criteria;
        }

        protected void addCriterion(String condition)
        {
            if (condition == null)
            {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property)
        {
            if (value == null)
            {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property)
        {
            if (value1 == null || value2 == null)
            {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWxidIsNull()
        {
            addCriterion("wxid is null");
            return (Criteria) this;
        }

        public Criteria andWxidIsNotNull()
        {
            addCriterion("wxid is not null");
            return (Criteria) this;
        }

        public Criteria andWxidEqualTo(Integer value)
        {
            addCriterion("wxid =", value, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidNotEqualTo(Integer value)
        {
            addCriterion("wxid <>", value, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidGreaterThan(Integer value)
        {
            addCriterion("wxid >", value, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidGreaterThanOrEqualTo(Integer value)
        {
            addCriterion("wxid >=", value, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidLessThan(Integer value)
        {
            addCriterion("wxid <", value, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidLessThanOrEqualTo(Integer value)
        {
            addCriterion("wxid <=", value, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidIn(List<Integer> values)
        {
            addCriterion("wxid in", values, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidNotIn(List<Integer> values)
        {
            addCriterion("wxid not in", values, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidBetween(Integer value1, Integer value2)
        {
            addCriterion("wxid between", value1, value2, "wxid");
            return (Criteria) this;
        }

        public Criteria andWxidNotBetween(Integer value1, Integer value2)
        {
            addCriterion("wxid not between", value1, value2, "wxid");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNull()
        {
            addCriterion("nickname is null");
            return (Criteria) this;
        }

        public Criteria andNicknameIsNotNull()
        {
            addCriterion("nickname is not null");
            return (Criteria) this;
        }

        public Criteria andNicknameEqualTo(String value)
        {
            addCriterion("nickname =", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotEqualTo(String value)
        {
            addCriterion("nickname <>", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThan(String value)
        {
            addCriterion("nickname >", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameGreaterThanOrEqualTo(String value)
        {
            addCriterion("nickname >=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThan(String value)
        {
            addCriterion("nickname <", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLessThanOrEqualTo(String value)
        {
            addCriterion("nickname <=", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameLike(String value)
        {
            addCriterion("nickname like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotLike(String value)
        {
            addCriterion("nickname not like", value, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameIn(List<String> values)
        {
            addCriterion("nickname in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotIn(List<String> values)
        {
            addCriterion("nickname not in", values, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameBetween(String value1, String value2)
        {
            addCriterion("nickname between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andNicknameNotBetween(String value1, String value2)
        {
            addCriterion("nickname not between", value1, value2, "nickname");
            return (Criteria) this;
        }

        public Criteria andWxopenidIsNull()
        {
            addCriterion("wxopenid is null");
            return (Criteria) this;
        }

        public Criteria andWxopenidIsNotNull()
        {
            addCriterion("wxopenid is not null");
            return (Criteria) this;
        }

        public Criteria andWxopenidEqualTo(String value)
        {
            addCriterion("wxopenid =", value, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidNotEqualTo(String value)
        {
            addCriterion("wxopenid <>", value, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidGreaterThan(String value)
        {
            addCriterion("wxopenid >", value, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidGreaterThanOrEqualTo(String value)
        {
            addCriterion("wxopenid >=", value, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidLessThan(String value)
        {
            addCriterion("wxopenid <", value, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidLessThanOrEqualTo(String value)
        {
            addCriterion("wxopenid <=", value, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidLike(String value)
        {
            addCriterion("wxopenid like", value, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidNotLike(String value)
        {
            addCriterion("wxopenid not like", value, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidIn(List<String> values)
        {
            addCriterion("wxopenid in", values, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidNotIn(List<String> values)
        {
            addCriterion("wxopenid not in", values, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidBetween(String value1, String value2)
        {
            addCriterion("wxopenid between", value1, value2, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andWxopenidNotBetween(String value1, String value2)
        {
            addCriterion("wxopenid not between", value1, value2, "wxopenid");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNull()
        {
            addCriterion("registertime is null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIsNotNull()
        {
            addCriterion("registertime is not null");
            return (Criteria) this;
        }

        public Criteria andRegistertimeEqualTo(Date value)
        {
            addCriterion("registertime =", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotEqualTo(Date value)
        {
            addCriterion("registertime <>", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThan(Date value)
        {
            addCriterion("registertime >", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeGreaterThanOrEqualTo(Date value)
        {
            addCriterion("registertime >=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThan(Date value)
        {
            addCriterion("registertime <", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeLessThanOrEqualTo(Date value)
        {
            addCriterion("registertime <=", value, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeIn(List<Date> values)
        {
            addCriterion("registertime in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotIn(List<Date> values)
        {
            addCriterion("registertime not in", values, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeBetween(Date value1, Date value2)
        {
            addCriterion("registertime between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andRegistertimeNotBetween(Date value1, Date value2)
        {
            addCriterion("registertime not between", value1, value2, "registertime");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull()
        {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull()
        {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Integer value)
        {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Integer value)
        {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Integer value)
        {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Integer value)
        {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Integer value)
        {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Integer value)
        {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Integer> values)
        {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Integer> values)
        {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Integer value1, Integer value2)
        {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Integer value1, Integer value2)
        {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull()
        {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull()
        {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value)
        {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value)
        {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value)
        {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value)
        {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value)
        {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value)
        {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value)
        {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value)
        {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values)
        {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values)
        {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2)
        {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2)
        {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull()
        {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull()
        {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value)
        {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value)
        {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value)
        {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value)
        {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value)
        {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value)
        {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value)
        {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value)
        {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values)
        {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values)
        {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2)
        {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2)
        {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull()
        {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull()
        {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value)
        {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value)
        {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value)
        {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value)
        {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value)
        {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value)
        {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value)
        {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value)
        {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values)
        {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values)
        {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2)
        {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2)
        {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andIconstrIsNull()
        {
            addCriterion("iconstr is null");
            return (Criteria) this;
        }

        public Criteria andIconstrIsNotNull()
        {
            addCriterion("iconstr is not null");
            return (Criteria) this;
        }

        public Criteria andIconstrEqualTo(String value)
        {
            addCriterion("iconstr =", value, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrNotEqualTo(String value)
        {
            addCriterion("iconstr <>", value, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrGreaterThan(String value)
        {
            addCriterion("iconstr >", value, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrGreaterThanOrEqualTo(String value)
        {
            addCriterion("iconstr >=", value, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrLessThan(String value)
        {
            addCriterion("iconstr <", value, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrLessThanOrEqualTo(String value)
        {
            addCriterion("iconstr <=", value, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrLike(String value)
        {
            addCriterion("iconstr like", value, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrNotLike(String value)
        {
            addCriterion("iconstr not like", value, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrIn(List<String> values)
        {
            addCriterion("iconstr in", values, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrNotIn(List<String> values)
        {
            addCriterion("iconstr not in", values, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrBetween(String value1, String value2)
        {
            addCriterion("iconstr between", value1, value2, "iconstr");
            return (Criteria) this;
        }

        public Criteria andIconstrNotBetween(String value1, String value2)
        {
            addCriterion("iconstr not between", value1, value2, "iconstr");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria
    {

        protected Criteria()
        {
            super();
        }
    }

    public static class Criterion
    {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition()
        {
            return condition;
        }

        public Object getValue()
        {
            return value;
        }

        public Object getSecondValue()
        {
            return secondValue;
        }

        public boolean isNoValue()
        {
            return noValue;
        }

        public boolean isSingleValue()
        {
            return singleValue;
        }

        public boolean isBetweenValue()
        {
            return betweenValue;
        }

        public boolean isListValue()
        {
            return listValue;
        }

        public String getTypeHandler()
        {
            return typeHandler;
        }

        protected Criterion(String condition)
        {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler)
        {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>)
            {
                this.listValue = true;
            }
            else
            {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value)
        {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler)
        {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue)
        {
            this(condition, value, secondValue, null);
        }
    }
}