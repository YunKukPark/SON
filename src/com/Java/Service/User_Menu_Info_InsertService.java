package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MenuDAO;
import com.DAO.webMessageDAO;
import com.Command.Command;

public class User_Menu_Info_InsertService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Id = request.getParameter("Id");
		String menu_Code = request.getParameter("addedproduct");
		String menu_Item_Cost = request.getParameter("menu_Item_Cost");
		String nextPage = "";

		MenuDAO dao = new MenuDAO();
		int cnt = dao.menuInsert(Id, menu_Code, menu_Item_Cost);

		if (cnt > 0) {
			
			System.out.println("send S");
			nextPage = "end.jsp";
			
		} else {

			System.out.println("send F");
			nextPage = "checkOut.jsp";

		}

		return nextPage;

	}
}
