package com.javaex.phone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/*************************
* DAO(Data Access Object)
* DataBase(오라클) 관련된 일을 하는 클래스                             //ㅠㅠㅠㅠ... 
**************************/

public class PhoneDao {
	private String id = "phonedb";
	private String pw = "phonedb";
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//DB 연결 메소드
	private void getConnection() {
	
	
		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "phonedb", "phonedb");
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		
		}
	}
	//PhoneDB 전체 출력 
		public List<PersonVo> phoneSelect() {
			
			//리스트 준비
			List<PersonVo> personList = new ArrayList<PersonVo>();
		    
		    // 3. SQL문 준비 / 바인딩 / 실행
		 			//SQL문 준비 
		 			String query = "";
		 			query += " select * ";
					query += " from person ";
		 			System.out.println(query);
		 			
		 			//바인딩 
		 			pstmt = conn.prepareStatement(query);
		 	
		 			//실행
		 			rs = pstmt.executequrry();
		 			
		 	//결과처리
			while(rs.next()) {
				int personId = rs.getInt(1);
				String name = rs.getString(2);
				String hp = rs.getString(3);
				String company = rs.getString(4);
						
				personList.add(new PersonVo(personId, name, hp, company));
			}
				
			 } catch (SQLException e) {
			        System.out.println("error:" + e);
		
			 } finally {
				 
		   
		    // 5. 자원정리
		    

		}
		
		return personList;
		
	}
	

public int phoneInsert(String name, String hp, String company) {
	
	int count = -1;
	
	
	try {
		//DB 연결
		getConnection();
		
	    // 3. SQL문 준비 / 바인딩 / 실행
		//SQL문 준비 
		String query = "";
		query += " insert into person ";
		query += " values(seq_person_id.nextval, ?, ?) ";
		System.out.println(query);
		
		//바인딩 
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, personVo.getName());
		pstmt.setString(2, personVo.getHp());
		pstmt.setString(3, personVo.getCompany());
		
		//실행
		count = pstmt.executeUpdate();
		
	    // 4.결과처리
		System.out.println(count + "건이 등록 되었습니다.");
		
		
	} catch (ClassNotFoundException e) {
	    System.out.println("error: 드라이버 로딩 실패 - " + e);
	} catch (SQLException e) {
	    System.out.println("error:" + e);
	} finally {
		
		return count;
	}
	
	//--삭제 메소드
	public int phoneDelete(int person_Id) {
		int count = -1;
		
		try {
			//DB 연결
			getConnection();

			// 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query += " delete person ";
			query += " where person_id = ? ";
						
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, person_Id);
			
			//실행
			count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count + "건 삭제 되었습니다.");

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
			//자원 정리
			close();
		}
		
		return count;
	}
	
	
	//--수정 메소드
	public int phoneUpdate(int person_Id, String name, String hp, String company) {
		int count = -1;
		
	

		try {
			//DB 연결
			getConnection();
			
			// 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query += " update person ";
			query += " set name = ?, ";
			query += "     hp = ?, ";
			query += "     company = ? ";
			query += " where person_id = ? ";
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getHp());
			pstmt.setString(3, personVo.getCompany());
			pstmt.setInt(4, personVo.getPersonId());
			
			//실행
			count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count + "건이 수정 되었습니다.");
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
			//자원 정리
			close();
		}
		return count;
	}
	}
	}
		
