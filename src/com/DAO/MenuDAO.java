package com.DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class MenuDAO {

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

	public ArrayList<MenuVO> menuSelect(String Store_code) {

		MenuVO vo = null;
		ArrayList<MenuVO> arr = new ArrayList<>();

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			String sql = "select menu_code,menu_item_cost from menu";

			System.out.println("sql문 만들었고");

			pst = conn.prepareStatement(sql);

			System.out.println("sql문 붙히고");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String menu_Code = rs.getString(1);
				String menu_Item_Cost = rs.getString(2);

				vo = new MenuVO(menu_Code, menu_Item_Cost);
				arr.add(vo);
			}

			System.out.println("while문 끝나고");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return arr;

	}

	public ArrayList<MenuVO> recommenationMenuSelect(String Id) {
		
		MenuVO vo = null;
		ArrayList<MenuVO> recArr = new ArrayList<>();

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			//sql문 수정 해야
			System.out.println("menuDAO에 들어온 아이디 : " + Id);
			//내꺼에선 잘 안돌아감 이부분 수정해야할 가능 성 많
			String sql = "select menu_code,menu_item_cost from son_user_info where id= ? ;";
			
			String memID = Id;
			pst = conn.prepareStatement(sql);
			System.out.println(pst);
			pst.setString(1, memID);
			

			System.out.println("sqlQuery : " + sql);
			System.out.println("sql문 만들었고");

			ResultSet rs = pst.executeQuery();

			System.out.println("sqlQuery : " + sql);
			while (rs.next()) {

				String menu_Code = rs.getString(1);
				String menu_Item_Cost = rs.getString(2);

				vo = new MenuVO(menu_Code, menu_Item_Cost);
				recArr.add(vo);
			}

			System.out.println("while문 끝나고");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return recArr;

	}
	
	public ArrayList<messageVO> messageSelect(String Id) {

		messageVO vo = null;
		ArrayList<messageVO> addedArr = new ArrayList<>();

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			String sql = "select * from son_user where user_id=?";

			pst = conn.prepareStatement(sql);

			pst.setString(1, Id);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				String num = rs.getString(1);
				String send_name = rs.getString(2);
				String receive_name = rs.getString(3);
				String content = rs.getString(4);
				String date = rs.getString(5);

				vo = new messageVO(num, send_name, receive_name, content, date);
				addedArr.add(vo);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return addedArr;

	}

	public int menuInsert(String Id, String addedproduct, String menu_Item_Cost) {

		int cnt = 0;

		try {

			conn = getConn();

			if (conn != null) {
				System.out.println("conn S");
			} else {
				System.out.println("conn F");
			}

			String sql = "insert into son_user_info(Id, Store_Code, order_date, menu_code, menu_item_div, menu_item_cost, menu_input) values(?, (select store_code from menu where menu_code = ?), now(), ?, (select menu_item_div from menu where menu_code = ?), ?, \n"
					+ "(select Menu_Material\n" + "from menu\n" + "where menu_code = ?));";

			pst = conn.prepareStatement(sql);

			pst.setString(1, Id);
			pst.setString(2, addedproduct);
			pst.setString(3, addedproduct);
			pst.setString(4, addedproduct);
			pst.setString(5, menu_Item_Cost);
			pst.setString(6, addedproduct);

			cnt = pst.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return cnt;

	}

}
