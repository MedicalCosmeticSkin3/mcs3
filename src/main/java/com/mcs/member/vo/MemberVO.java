package com.mcs.member.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private String member_id;
	private String member_pw;
	private int deli_num;
	private String gender;
	private String phone;
	private String email;
	private boolean confirm;
	private String name;
	private Date birth;
	private int pw_find;
	private String pw_answer;
	private int mileage;
	private boolean admin;
}
