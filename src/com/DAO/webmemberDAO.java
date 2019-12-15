package com.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class webmemberDAO {
	// DAO 장점
	// 소스코드의 간결화 (메소드화 / 멤버변수)
	// DAO 단점 
	// 결합도가 높아지기 때문에 DAO클래스 중요도가너무 높아짐 

	Connection conn = null;
	PreparedStatement pst = null;

	public Connection getConn() throws Exception {
		System.out.println("Conn 에 들어옴");
		
		InputStream in = getClass().getResourceAsStream("../../../../db.properties");
		Properties p = new Properties();
		p.load(in);
		
		System.out.println("properties Loaded");
		
		Class.forName(p.getProperty("dbclass"));

		String url = p.getProperty("dburl");
		String dbid = p.getProperty("dbid");
		String dbpw = p.getProperty("dbpw");

		conn = DriverManager.getConnection(url, dbid, dbpw);
		System.out.println("Conn 빠져나옴");
		return conn;

	}

	public int Join(memberVO vo) {

		int cnt = 0;

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			
			
			String sql = "insert into Son_User values(?, ?, ?, ?, ?, ?)";

			pst = conn.prepareStatement(sql);

			pst.setString(1, vo.getID());
			pst.setString(2, vo.getPw());
			pst.setString(3, vo.getAge());
			pst.setString(4, vo.getSex());
			pst.setString(5, vo.getHp());
			pst.setString(6, vo.getAlergy());

			cnt = pst.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return cnt;

	}

	public memberVO Login(memberVO vo) {

		int cnt = 0;

		memberVO vo_1 = null;

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			String sql = "select * from Son_User where User_ID = ? and User_PW = ?";

			pst = conn.prepareStatement(sql);

			pst.setString(1, vo.getID());
			pst.setString(2, vo.getPw());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				vo_1 = new memberVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6));

				cnt = 1;

			} else {
				cnt = 0;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return vo_1;

	}

	public int update(memberVO vo) {

		int cnt = 0;

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			String sql = "update web_member set pw = ?";

			pst = conn.prepareStatement(sql);

			pst.setString(1, vo.getPw());

			cnt = pst.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return cnt;

	}



	public int memberDelete(String email) {

		int cnt = 0;

		try {

			conn = getConn();
			String sql = "delete from web_member where email = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, email);

			cnt = pst.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return cnt;

	}

}
