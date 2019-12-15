package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.memberVO;
import com.DAO.webmemberDAO;
import com.Command.Command;

public class UpdateService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		memberVO vo = (memberVO) session.getAttribute("vo");
		String pw = request.getParameter("pw");
		String age = request.getParameter("age");
		String sex = request.getParameter("sex");
		String hp = request.getParameter("hp");
		String alergy = request.getParameter("alergy");

		int cnt = 0;

		String nextPage = "";

		webmemberDAO dao = new webmemberDAO();

		memberVO vo_1 = new memberVO(vo.getID(), pw, age, sex, hp, alergy);

		cnt = dao.update(vo_1);

		if (cnt > 0) {

			System.out.println("update S");
			nextPage = "main.jsp";

		} else {

			System.out.println("update F");
			nextPage = "main.jsp";

		}

		return nextPage;

	}

}
