package com.Java.Service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.MenuDAO;
import com.DAO.MenuVO;
import com.Command.Command;

public class RecommandationService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Id = request.getParameter("Id");
		System.out.println("RecommandationService에 들어온 Id : " + Id);
		String nextPage = "";

		MenuDAO dao = new MenuDAO();
		ArrayList<MenuVO> cnt = dao.recommenationMenuSelect(Id);

		if (cnt != null) {
			
			System.out.println("send S");
			nextPage = "Just_Over_There.jsp";
			
		} else {

			System.out.println("send F");
			nextPage = "Just_Over_There.jsp";

		}

		return nextPage;

	}
}
