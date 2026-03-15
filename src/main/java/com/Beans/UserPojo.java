package com.Beans;

import java.util.Objects;

public class UserPojo {

	private String user;
	private String pass;
	private String secQuestion;
	private String ans;

	public UserPojo() {
	}

	public UserPojo(String user, String pass, String secQuestion, String ans) {
		super();
		this.user = user;
		this.pass = pass;
		this.secQuestion = secQuestion;
		this.ans = ans;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSecQuestion() {
		return secQuestion;
	}

	public void setSecQuestion(String secQuestion) {
		this.secQuestion = secQuestion;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	@Override
	public String toString() {
		return "UserPojo [user=" + user + ", pass=" + pass + ", secQuestion=" + secQuestion + ", ans=" + ans + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ans, pass, secQuestion, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserPojo other = (UserPojo) obj;
		return Objects.equals(ans, other.ans) && Objects.equals(pass, other.pass)
				&& Objects.equals(secQuestion, other.secQuestion) && Objects.equals(user, other.user);
	}

}
