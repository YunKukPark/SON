package com.DAO;

public class memberVO {
	private String id;
	private String pw;
	private String age;
	private String sex;
	private String hp;
	private String alergy;

	//회원가입을 위한 곳 
	public memberVO(String id, String pw, String age, String sex, String hp, String alergy) {
		super();
		this.id = id;
		this.pw = pw;
		this.age = age;
		this.sex = sex;
		this.hp = hp;
		this.alergy = alergy;
	}

	//로그인을 위한 곳
	public memberVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getHp() {
		return hp;
	}

	public void setTel(String hp) {
		this.hp = hp;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAlergy() {
		return alergy;
	}

	public void setAlergy(String alergy) {
		this.alergy = alergy;
	}


	

}
