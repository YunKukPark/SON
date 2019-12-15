package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.webMessageDAO;
import com.Command.Command;

public class MessageInsertService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String send_name = request.getParameter("send_name");
		String receive_name = request.getParameter("receive_name");
		String content = request.getParameter("content");

		webMessageDAO dao = new webMessageDAO();
		int cnt = dao.messageInsert(send_name, receive_name, content);

		String nextPage = "";

		if (cnt > 0) {

			System.out.println("send S");
			nextPage = "main.jsp";

		} else {

			System.out.println("send F");
			nextPage = "main.jsp";

		}

		return nextPage;

	}

}
