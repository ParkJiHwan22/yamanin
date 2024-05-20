package com.yamanin.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "User")
public class User {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, length = 20, unique = true)
    private String loginId;

    @Column(nullable = false, length = 30)
    private String password;

    @Column(length = 30)
    private String name;

    @Column(length = 20)
    private String phone;

    @Column(length = 30)
    private String email;

    @Column(name = "created_date", updatable = false, insertable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private String createdDate;

    private Integer age;

    @Column(length = 1)
    private int gender;

    @Column(length = 20)
    private String nickName;
	
	public User() {
	}

	public User(int userId, String loginId, String password, String name, String phone, String email,
			String createdDate, int age, int gender, String nickName) {
		this.userId = userId;
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.createdDate = createdDate;
		this.age = age;
		this.gender = gender;
		this.nickName = nickName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int isGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", loginId=" + loginId + ", password=" + password + ", name=" + name
				+ ", phone=" + phone + ", email=" + email + ", createdDate=" + createdDate + ", age=" + age
				+ ", gender=" + gender + ", nickName=" + nickName + "]";
	}
	
	
	
}
