package com.javaex.phone;

public class PhoneVo {

	
	// 필드
	String name;
	String hp;
	String company;

	
	
	
	
	//생성자 
	public PhoneVo() {
	}
	public PhoneVo(String name, String hp, String company) {
		
		this.name = name;
		this.hp = hp;
		this.company = company;
	}

	
	
	
	
	//gs
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCompany() {
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
	





}
