package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.memberVO;
import com.DAO.webmemberDAO;
import com.Command.Command;

public class LoginService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("euc-kr");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		webmemberDAO dao = new webmemberDAO();

		memberVO vo = new memberVO(id, pw);

		memberVO vo_1 = dao.Login(vo);

		String nextPage = "";

		if (vo_1 != null) {

			System.out.println("login S");
			HttpSession session = request.getSession();
			session.setAttribute("vo", vo_1);

			nextPage = "Just_Over_There.jsp";

		} else {

			System.out.println("login F");
			nextPage = "main.jsp";

		}

		return nextPage;

	}

}
