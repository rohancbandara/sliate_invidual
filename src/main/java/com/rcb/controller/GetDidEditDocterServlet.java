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
@WebServlet("/getDid")
public class GetDidEditDocterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Appinment ap = new Appinment();
		int apId = Integer.parseInt(request.getParameter("id"));
		ap.setId(apId);
		response.sendRedirect("AppointmentAddPatient.jsp");
		// set apId in Appoinment
		HttpSession session = request.getSession();
		session.setAttribute("apId", apId);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
