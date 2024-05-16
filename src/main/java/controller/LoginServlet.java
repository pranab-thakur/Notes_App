package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import dto.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		UserDao userdao=new UserDao();
	    User user=userdao.FetchUserByEmailAndPassword(email, password);
	    
	    HttpSession session=req.getSession();
	    
	    if(user!=null) {
	    	session.setAttribute("userobj", user);
	    	resp.sendRedirect("home.jsp");
	    }
	    session.setAttribute("fail", "Invalid credentials");
	    resp.sendRedirect("login.jsp");
		
		
	}

}
