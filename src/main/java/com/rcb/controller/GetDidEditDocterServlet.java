package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rcb.model.Docter;

/**
 * Servlet implementation class SetPID
 */
@WebServlet("/getDid")
public class GetDidEditDocterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Docter docter = new Docter();
		int dId = Integer.parseInt(request.getParameter("id"));
		docter.setD_id(dId);
		response.sendRedirect("DocterUpdate.jsp");
		// set dId in Docter Details
		HttpSession session = request.getSession();
		session.setAttribute("dID", docter.getD_id());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
