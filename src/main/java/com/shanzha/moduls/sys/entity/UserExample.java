package com.shanzha.moduls.sys.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public UserExample() {
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

		public Criteria andUsernameIsNull() {
			addCriterion("username is null");
			return (Criteria) this;
		}

		public Criteria andUsernameIsNotNull() {
			addCriterion("username is not null");
			return (Criteria) this;
		}

		public Criteria andUsernameEqualTo(String value) {
			addCriterion("username =", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotEqualTo(String value) {
			addCriterion("username <>", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThan(String value) {
			addCriterion("username >", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameGreaterThanOrEqualTo(String value) {
			addCriterion("username >=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThan(String value) {
			addCriterion("username <", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLessThanOrEqualTo(String value) {
			addCriterion("username <=", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameLike(String value) {
			addCriterion("username like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotLike(String value) {
			addCriterion("username not like", value, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameIn(List<String> values) {
			addCriterion("username in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotIn(List<String> values) {
			addCriterion("username not in", values, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameBetween(String value1, String value2) {
			addCriterion("username between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andUsernameNotBetween(String value1, String value2) {
			addCriterion("username not between", value1, value2, "username");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("email is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("email is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("email =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("email <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("email >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("email >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("email <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("email <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("email like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("email not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("email in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("email not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("email between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("email not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andNickNameIsNull() {
			addCriterion("nick_name is null");
			return (Criteria) this;
		}

		public Criteria andNickNameIsNotNull() {
			addCriterion("nick_name is not null");
			return (Criteria) this;
		}

		public Criteria andNickNameEqualTo(String value) {
			addCriterion("nick_name =", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotEqualTo(String value) {
			addCriterion("nick_name <>", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameGreaterThan(String value) {
			addCriterion("nick_name >", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameGreaterThanOrEqualTo(String value) {
			addCriterion("nick_name >=", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLessThan(String value) {
			addCriterion("nick_name <", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLessThanOrEqualTo(String value) {
			addCriterion("nick_name <=", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameLike(String value) {
			addCriterion("nick_name like", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotLike(String value) {
			addCriterion("nick_name not like", value, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameIn(List<String> values) {
			addCriterion("nick_name in", values, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotIn(List<String> values) {
			addCriterion("nick_name not in", values, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameBetween(String value1, String value2) {
			addCriterion("nick_name between", value1, value2, "nickName");
			return (Criteria) this;
		}

		public Criteria andNickNameNotBetween(String value1, String value2) {
			addCriterion("nick_name not between", value1, value2, "nickName");
			return (Criteria) this;
		}

		public Criteria andUserRoleIsNull() {
			addCriterion("user_role is null");
			return (Criteria) this;
		}

		public Criteria andUserRoleIsNotNull() {
			addCriterion("user_role is not null");
			return (Criteria) this;
		}

		public Criteria andUserRoleEqualTo(String value) {
			addCriterion("user_role =", value, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleNotEqualTo(String value) {
			addCriterion("user_role <>", value, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleGreaterThan(String value) {
			addCriterion("user_role >", value, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleGreaterThanOrEqualTo(String value) {
			addCriterion("user_role >=", value, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleLessThan(String value) {
			addCriterion("user_role <", value, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleLessThanOrEqualTo(String value) {
			addCriterion("user_role <=", value, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleLike(String value) {
			addCriterion("user_role like", value, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleNotLike(String value) {
			addCriterion("user_role not like", value, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleIn(List<String> values) {
			addCriterion("user_role in", values, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleNotIn(List<String> values) {
			addCriterion("user_role not in", values, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleBetween(String value1, String value2) {
			addCriterion("user_role between", value1, value2, "userRole");
			return (Criteria) this;
		}

		public Criteria andUserRoleNotBetween(String value1, String value2) {
			addCriterion("user_role not between", value1, value2, "userRole");
			return (Criteria) this;
		}

		public Criteria andLastLoginIsNull() {
			addCriterion("last_login is null");
			return (Criteria) this;
		}

		public Criteria andLastLoginIsNotNull() {
			addCriterion("last_login is not null");
			return (Criteria) this;
		}

		public Criteria andLastLoginEqualTo(Date value) {
			addCriterion("last_login =", value, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginNotEqualTo(Date value) {
			addCriterion("last_login <>", value, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginGreaterThan(Date value) {
			addCriterion("last_login >", value, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
			addCriterion("last_login >=", value, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginLessThan(Date value) {
			addCriterion("last_login <", value, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginLessThanOrEqualTo(Date value) {
			addCriterion("last_login <=", value, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginIn(List<Date> values) {
			addCriterion("last_login in", values, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginNotIn(List<Date> values) {
			addCriterion("last_login not in", values, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginBetween(Date value1, Date value2) {
			addCriterion("last_login between", value1, value2, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLastLoginNotBetween(Date value1, Date value2) {
			addCriterion("last_login not between", value1, value2, "lastLogin");
			return (Criteria) this;
		}

		public Criteria andLoginIpIsNull() {
			addCriterion("login_ip is null");
			return (Criteria) this;
		}

		public Criteria andLoginIpIsNotNull() {
			addCriterion("login_ip is not null");
			return (Criteria) this;
		}

		public Criteria andLoginIpEqualTo(String value) {
			addCriterion("login_ip =", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpNotEqualTo(String value) {
			addCriterion("login_ip <>", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpGreaterThan(String value) {
			addCriterion("login_ip >", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
			addCriterion("login_ip >=", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpLessThan(String value) {
			addCriterion("login_ip <", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpLessThanOrEqualTo(String value) {
			addCriterion("login_ip <=", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpLike(String value) {
			addCriterion("login_ip like", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpNotLike(String value) {
			addCriterion("login_ip not like", value, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpIn(List<String> values) {
			addCriterion("login_ip in", values, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpNotIn(List<String> values) {
			addCriterion("login_ip not in", values, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpBetween(String value1, String value2) {
			addCriterion("login_ip between", value1, value2, "loginIp");
			return (Criteria) this;
		}

		public Criteria andLoginIpNotBetween(String value1, String value2) {
			addCriterion("login_ip not between", value1, value2, "loginIp");
			return (Criteria) this;
		}

		public Criteria andEnabledIsNull() {
			addCriterion("enabled is null");
			return (Criteria) this;
		}

		public Criteria andEnabledIsNotNull() {
			addCriterion("enabled is not null");
			return (Criteria) this;
		}

		public Criteria andEnabledEqualTo(Integer value) {
			addCriterion("enabled =", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotEqualTo(Integer value) {
			addCriterion("enabled <>", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledGreaterThan(Integer value) {
			addCriterion("enabled >", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
			addCriterion("enabled >=", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledLessThan(Integer value) {
			addCriterion("enabled <", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledLessThanOrEqualTo(Integer value) {
			addCriterion("enabled <=", value, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledIn(List<Integer> values) {
			addCriterion("enabled in", values, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotIn(List<Integer> values) {
			addCriterion("enabled not in", values, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledBetween(Integer value1, Integer value2) {
			addCriterion("enabled between", value1, value2, "enabled");
			return (Criteria) this;
		}

		public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
			addCriterion("enabled not between", value1, value2, "enabled");
			return (Criteria) this;
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table sys_user
     *
     * @mbg.generated do_not_delete_during_merge Thu Dec 29 14:17:38 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}