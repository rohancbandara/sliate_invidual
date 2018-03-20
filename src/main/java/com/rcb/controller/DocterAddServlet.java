package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcb.model.Docter;
import com.rcb.model.Special;
import com.rcb.service.DocterService;

@WebServlet("/addDocter")
public class DocterAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Docter docter = new Docter();
		Special special = new Special();
		docter.setD_FName(request.getParameter("txtFname"));
		docter.setD_LName(request.getParameter("txtLname"));
		docter.setD_email(request.getParameter("txtEmail"));
		docter.setD_special(Integer.parseInt(request.getParameter("special")));
		// special.setSp_name(request.getParameter("special"));

		String action = request.getParameter("btnSubmit");
		if (action.equals("save")) {
			DocterService regDocter = new DocterService();
			Boolean result = regDocter.putDocterData(docter);
			System.out.println(special.getSp_name());
			System.out.println(result);
			if (result) {

				response.sendRedirect("DocterAdd.jsp");
			}

		} else if (action.equals("back")) {
			response.sendRedirect("DocterList.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
