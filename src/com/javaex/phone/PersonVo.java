package com.javaex.phone;

public class PersonVo {

	
	// 필드
	static String name;
	static String hp;
	static String company;

	
	
	
	
	//생성자 
	public PersonVo() {
	}
	public PersonVo(String name, String hp, String company) {
		
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	
	
	
	
	//gs
	public static String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public static String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	







	//일반
	@Override
	public String toString() {
		return "PhoneVo [name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	public static int getpersonId() {
		// TODO Auto-generated method stub
		return 0;
	}
	





}
