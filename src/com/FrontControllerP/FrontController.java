package com.FrontControllerP;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.memberVO;
import com.DAO.webMessageDAO;
import com.DAO.webmemberDAO;
import com.Java.Service.DeleteMemberService;
import com.Java.Service.JoinService;
import com.Java.Service.LoginService;
import com.Java.Service.LogoutService;
import com.Java.Service.MessageDeleteService;
import com.Java.Service.MessageInsertService;
import com.Java.Service.RecommandationService;
import com.Java.Service.UpdateService;
import com.Java.Service.User_Menu_Info_InsertService;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println(uri);
		String path = request.getContextPath();
		System.out.println(path);
		String command = uri.substring(path.length() + 1);
		System.out.println(command);

		String nextPage = "";

		if (command.equals("Login.do")) {

			LoginService login = new LoginService();
			nextPage = login.execute(request, response);

		} else if (command.equals("Join.do")) {

			JoinService join = new JoinService();
			nextPage = join.execute(request, response);

		} else if (command.equals("DeleteMemer.do")) {

			DeleteMemberService deleteMember = new DeleteMemberService();
			nextPage = deleteMember.execute(request, response);

		} else if (command.equals("MessageDelete.do")) {

			MessageDeleteService messageDelete = new MessageDeleteService();
			nextPage = messageDelete.execute(request, response);

		} else if (command.equals("MessageInsert.do")) {

			MessageInsertService messageInsert = new MessageInsertService();
			nextPage = messageInsert.execute(request, response);

		} else if (command.equals("Logout.do")) {

			LogoutService logout = new LogoutService();
			nextPage = logout.execute(request, response);

		} else if (command.equals("Update.do")) {

			UpdateService update = new UpdateService();
			nextPage = update.execute(request, response);

		} else if (command.equals("InsertUserinfo.do")) {

			User_Menu_Info_InsertService User_Menu_Info_Insert  = new User_Menu_Info_InsertService();
			nextPage = User_Menu_Info_Insert.execute(request, response);
			
		}
		
		else if (command.equals("recommand.do")) {

			RecommandationService Recommandation = new RecommandationService();
			nextPage = Recommandation.execute(request, response);
			
		}

		RequestDispatcher dis = request.getRequestDispatcher(nextPage);
		dis.forward(request, response);

	}

}
