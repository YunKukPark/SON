package com.Java.Service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.webmemberDAO;
import com.Command.Command;

public class DeleteMemberService implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		System.out.println(email);
		// email값을 web_member테이블에서 삭제하고
		// 삭제가 성공하면 selectMember.jsp로 이동하시오.

		webmemberDAO dao = new webmemberDAO();

		int cnt = dao.memberDelete(email);

		String nextPage = "";

		if (cnt > 0) {

			System.out.println("delete S");
			nextPage = "selectMember.jsp";

		} else {

			System.out.println("delete F");
			nextPage = "selectMember.jsp";

		}

		return nextPage;

	}

}
