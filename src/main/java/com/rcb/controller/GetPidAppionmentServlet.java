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
public class GetPidAppionmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Appinment appinment = new Appinment();
		int pid = Integer.parseInt(request.getParameter("id"));
		appinment.setP_id(pid);

		response.sendRedirect("AppointmentAddPatient.jsp");
		// set dId in Patient Update jsp pase using session
		HttpSession session = request.getSession();
		session.setAttribute("pid", pid);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
