package com.Java.Service;

import java.io.IOException;

import javax.print.DocFlavor.STRING;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Command.Command;
import com.DAO.memberVO;
import com.DAO.webmemberDAO;

public class JoinService implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		System.out.println("JoinService 실행되었습니다");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String age = request.getParameter("age");
		System.out.println("잘 받아먹고 있니?");
		String sex = request.getParameter("sex");
		String hp = request.getParameter("hp");
		String alergy = request.getParameter("alergy");
		System.out.println("받아먹기 END");

		webmemberDAO dao = new webmemberDAO();
		
		memberVO vo = new memberVO(id, pw, age, sex, hp, alergy);
		
		System.out.println("여기서 잘못되고 있다");
		int cnt = dao.Join(vo);
		
		System.out.println("JoinService 중간 보고");
		String nextPage = "";
		if(cnt>0) {
			
			request.setAttribute("vo", vo);
			
			nextPage = "joinSuccess.jsp";
		}
		return nextPage;
	}
	
}
