package com.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

public class webMessageDAO {

	Connection conn = null;
	PreparedStatement pst = null;

	public Connection getConn() throws Exception {

		InputStream in = getClass().getResourceAsStream("../../../../db.properties");
		Properties p = new Properties();
		p.load(in);

		Class.forName(p.getProperty("dbclass"));

		String url = p.getProperty("dburl");
		String dbid = p.getProperty("dbid");
		String dbpw = p.getProperty("dbpw");

		conn = DriverManager.getConnection(url, dbid, dbpw);

		return conn;

	}

	public int messageInsert(String send_name, String receive_name, String content) {

		int cnt = 0;

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			String sql = "insert into web_message(send_name, receive_name, content, in_date) values(?, ?, ?, now());";

			pst = conn.prepareStatement(sql);

			pst.setString(1, send_name);
			pst.setString(2, receive_name);
			pst.setString(3, content);

			cnt = pst.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return cnt;

	}

	public ArrayList<messageVO> messageSelect(String email) {

		messageVO vo = null;
		ArrayList<messageVO> arr = new ArrayList<>();

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			String sql = "select * from web_message where receive_name=?";

			pst = conn.prepareStatement(sql);

			pst.setString(1, email);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String num = rs.getString(1);
				String send_name = rs.getString(2);
				String receive_name = rs.getString(3);
				String content = rs.getString(4);
				String date = rs.getString(5);

				vo = new messageVO(num, send_name, receive_name, content, date);
				arr.add(vo);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return arr;

	}

	public int messageDelete(String num) {

		int cnt = 0;

		try {

			conn = getConn();
			String sql = "delete from web_message where m_num = ?";

			pst = conn.prepareStatement(sql);
			pst.setString(1, num);

			cnt = pst.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return cnt;

	}

}
