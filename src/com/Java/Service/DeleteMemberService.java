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
		// email���� web_member���̺��� �����ϰ�
		// ������ �����ϸ� selectMember.jsp�� �̵��Ͻÿ�.

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
