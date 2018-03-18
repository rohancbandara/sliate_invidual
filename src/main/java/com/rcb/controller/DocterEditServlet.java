package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcb.service.DocterService;

/**
 * Servlet implementation class DocterEditServlet
 */
@WebServlet("/docterEdit")
public class DocterEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int did = Integer.parseInt(request.getParameter("id"));
		System.out.println(did + " will delete");
		DocterService docterService = new DocterService();
		boolean result = docterService.deleteDocter(did);
		if (result) {
			response.sendRedirect("DocterList.jsp");
		}
		System.out.println("error");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
