package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.webMessageDAO;
import com.Command.Command;

public class MessageDeleteService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String num = request.getParameter("num");

		webMessageDAO dao = new webMessageDAO();

		int cnt = dao.messageDelete(num);

		String nextPage = "";

		if (cnt > 0) {

			System.out.println("message delete S");
			nextPage = "main.jsp";

		} else {

			System.out.println("message delete F");
			nextPage = "main.jsp";

		}

		return nextPage;

	}

}
