package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rcb.model.Appinment;

/**
 * Servlet implementation class SetPID
 */
@WebServlet("/getPid")
public class GetAppionmentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Appinment appinment = new Appinment();
		int aId = Integer.parseInt(request.getParameter("id"));
		String d_fullname = request.getParameter("dFullname").toUpperCase();
		String date = request.getParameter("date");
		int comeTime = Integer.parseInt(request.getParameter("time"));

		appinment.setId(aId);

		response.sendRedirect("AppointmentDocter.jsp");
		// set dId in Patient Update jsp pase using session
		HttpSession session = request.getSession();
		session.setAttribute("aId", aId);
		session.setAttribute("dFullName", d_fullname);
		session.setAttribute("date", date);
		session.setAttribute("comeTime", comeTime);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
