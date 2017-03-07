package com.localhost.DbUtils;

import java.util.Date;

/**
 * 基础用户类
 * @author Administrator
 *
 */
public class User {

	/**
	 * 编号
	 */
	public int id;
	
	/**
	 * 用户名
	 */
	public String username;
	
	/**
	 * 密码
	 */
	public String password;
	
	/**
	 * 昵称
	 */
	public String nickname;
	
	/**
	 * 性别
	 */
	public String gender;
	
	/**
	 * 生日
	 */
	public Date birthday;
	
	/**
	 * 电子邮箱
	 */
	public String email;
	
	/**
	 * 手机号码
	 */
	public String mobile;
	
	/**
	 * QQ
	 */
	public String qq;
	
	/**
	 * 住址
	 */
	public String address;
	
	/**
	 * 邮编
	 */
	public String post_code;
	
	/**
	 * 是否删除
	 */
	public int is_delete = 0;
	
	/**
	 * 头像路径
	 */
	public String logo_path;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname the nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the qq
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * @param qq the qq to set
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the post_code
	 */
	public String getPost_code() {
		return post_code;
	}

	/**
	 * @param post_code the post_code to set
	 */
	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	/**
	 * @return the is_delete
	 */
	public int getIs_delete() {
		return is_delete;
	}

	/**
	 * @param is_delete the is_delete to set
	 */
	public void setIs_delete(int is_delete) {
		this.is_delete = is_delete;
	}

	/**
	 * @return the logo_path
	 */
	public String getLogo_path() {
		return logo_path;
	}

	/**
	 * @param logo_path the logo_path to set
	 */
	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", nickname=" + nickname + ", gender=" + gender
				+ ", birthday=" + birthday + ", email=" + email + ", mobile="
				+ mobile + ", qq=" + qq + ", address=" + address
				+ ", post_code=" + post_code + ", is_delete=" + is_delete
				+ ", logo_path=" + logo_path + "]";
	}
	
}
