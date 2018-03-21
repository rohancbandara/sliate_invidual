package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rcb.model.Appinment;
import com.rcb.service.AppoinmentService;

/**
 * Servlet implementation class AppoinmentAddServlet
 */
@WebServlet("/appoinmentAdd")
public class AppoinmentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pId = Integer.parseInt(request.getParameter("patient"));

		Appinment appoinment = new Appinment();
		HttpSession session = request.getSession();

		int aId = (int) session.getAttribute("aId");

		appoinment.setId(aId);
		appoinment.setP_id(pId);
		AppoinmentService apS = new AppoinmentService();
		boolean result = apS.setPatient(appoinment);
		if (result) {
			response.sendRedirect("AppointmentList.jsp");
		}
	}

}
