package com.javaex.phone;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {

		
		Scanner sc = new Scanner(System.in);

		PhoneDao phoneDao = new PhoneDao();

		System.out.println("****************************************");
		System.out.println("*            전화번호 관리 프로그램           *");
		System.out.println("****************************************");
		System.out.println("");

		boolean action;
		
		while (action) {
			System.out.println("");
			System.out.print("1.리스트  2.등록  3.수정  4.삭제  5.검색  6.종료");
			System.out.println("");
			System.out.println("-----------------------------------------");
			System.out.print("> 메뉴번호: ");
			
			int num = sc.nextInt();

			switch (num) {
			
			case 1://리스트출력
				System.out.println("1.리스트");
				
				List<PersonVo> phoneList = phoneDao.phoneSelect();
				for(int i = 0; i<phoneList.size(); i++) {
					
					PersonVo personVo = phoneList.get(i);
					System.out.println(PersonVo.getpersonId()+". "+
										PersonVo.getName()+"  "+PersonVo.getHp()+"  "+
										PersonVo.getCompany());
				
				}
				break;

			case 2://리스트등록
				
				System.out.println("2.등록");
				
				System.out.print("이름");
				String name = sc.next();
				
				System.out.print("휴대전화");
				String hp = sc.next();
				
				System.out.print("회사전화");
				String company = sc.next();
				
				phoneDao.phoneInsert(new PersonVo(personId, name, hp, company));

			
				break;
				
			case 3:
				System.out.println();
				System.out.println("3.수정");
				System.out.println();
				
				sc.nextLine();
				
				System.out.print("번호 ");
				int personId = sc.nextInt();
				
				sc.nextLine();
				
				System.out.print("이름 ");
				String name = sc.nextLine();
				
				System.out.print("휴대전화 ");
				String hp = sc.nextLine();
				
				System.out.print("회사번호 ");
				String company = sc.nextLine();
				
				
				phoneDao.phoneUpdate(new PersonVo(personId, name, hp, company));
				
				
				break;

			case 4:
				System.out.println("4.삭제");
				
				System.out.print("번호: ");
				int personId = sc.nextInt();
				
				
				phoneDao.phoneDelete(personId);


				break;

			case 5:
				System.out.println("5.검색");
				System.out.print("이름: ");
			
				
				break;

			case 6:
				System.out.println("6.종료");
				
				action = false;
				
				System.out.println("다시 입력해주세요.");
				
				
			}
		}
	}
}