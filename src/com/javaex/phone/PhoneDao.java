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
* DataBase(오라클) 관련된 일을 하는 클래스
**************************/

public class PhoneDao {
	//필드
	
	//생성자
	
	//메소드-gs
	
	//메소드-일반
	
	//--작가 등록 메소드
	public int PersonInsert(String name, String hp, String company) {
		
		int count = -1;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "phonedb", "phonedb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비 
			String query = "";
			query += " insert into person ";
			query += " values(seq_person_id.nextval, ?, ?) ";
			System.out.println(query);
			
			//바인딩 
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, hp);
			pstmt.setString(3, company);
			
			//실행
			count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count + "건이 등록 되었습니다.");
			
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        /*
		    	if (rs != null) {
		            rs.close();
		        } 
		        */               
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
		
		return count;
		
	}
	
	
	//--삭제 메소드
	public int PersonDelete(int person_Id) {
		int count = -1;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "phonedb", "phonedb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비 
			String query = "";
			query += " delete from Person ";
			query += " where person_id = ? ";
			System.out.println(query);
			
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
		   
		    // 5. 자원정리
		    try {
		        /*
		    	if (rs != null) {
		            rs.close();
		        } 
		        */               
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}

		return count;
	}
	
	
	//--수정 메소드
	public int authorUpdate(int person_Id, String name, String hp, String company) {
		int count = -1;
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "phonedb", "phonedb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비 
			String query ="";
			query += " update person ";
			query += " set person_name = ?, ";
			query += "     person_desc = ? ";
			query += " where person_id = ? ";
			System.out.println(query);
			
			//바인딩 
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, hp);
			pstmt.setString(3, company);
			pstmt.setInt(4, person_Id);
			
			//실행
			count = pstmt.executeUpdate();
			
		    // 4.결과처리
			System.out.println(count + "건이 수정 되었습니다.");
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        /*
		    	if (rs != null) {
		            rs.close();
		        } 
		        */               
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
		
		return count;
	}
	
	
	//--작가 전체리스트 가져오기 메소드
	public List<PhoneVo> PersonSelect() {
		
		//리스트 준비
		List<PhoneVo> PersonList = new ArrayList<PhoneVo>();
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		    // 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "phonedb", "phonedb");

		    // 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비 
			String query = "";
			query += " select  person_id, ";
			query += "         name, ";
			query += "         hp, ";
			query += "         company ";
			query += " from person ";
			System.out.println(query);
			
			//바인딩 
			pstmt = conn.prepareStatement(query);
			
			//실행
			//ResultSet 가져오기
			rs = pstmt.executeQuery();
			
		    // 4.결과처리
			//반복문으로 Vo 만들기  list에 추가하기
			while(rs.next()) {
				int personId =  rs.getInt("personid");
				String name = rs.getString("name");
				String hp = rs.getString("hp");
				String company = rs.getString("company");				
				
				PersonList PhoneVo = new PhoneVo(personId, name, hp, company);
				
				PersonList.add(PhoneVo);
			}
			
			
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}
		
		return PersonList;
	}
	
	
}