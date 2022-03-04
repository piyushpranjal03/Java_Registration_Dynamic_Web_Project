package com.devdensify.servlets;

import com.devdensify.Person;
import com.devdensify.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class SignUp extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			Person user = new Person(email, password);
			boolean isRegistered = DAO.signUp(user);
			PrintWriter out = res.getWriter();
			if(isRegistered) {
				out.println(1);
			} else {
				out.println(0);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

