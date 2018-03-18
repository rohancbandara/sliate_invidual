package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcb.model.TimeIntervel;
import com.rcb.service.CreateTimeIntervelService;

@WebServlet("/createTimeIntervel")
public class CreateTimeIntervelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CreateTimeIntervelService createTimeIntervel = new CreateTimeIntervelService();
		TimeIntervel tI = new TimeIntervel();

		tI.setdId(Integer.parseInt(request.getParameter("id")));
		tI.setDate(request.getParameter("txtDate"));
		tI.setIntervel(Integer.parseInt(request.getParameter("txtIntervel")));
		tI.setFromTime(Integer.parseInt(request.getParameter("txtFromTime")) * 60);
		tI.setToTime(Integer.parseInt(request.getParameter("txtToTime")) * 60);
		tI.setTbl_id(tI.getDate() + tI.getdId());

		boolean result2 = createTimeIntervel.createTable(tI);
		boolean result = createTimeIntervel.intervals(tI);
		System.out.println(result);
		System.out.println(result2);
		if (result && result2) {
			System.out.println("sucess intevels and tables ");
			response.sendRedirect("AppointmentList.jsp");
		} else {
			response.sendRedirect("AppointmentCreate.jsp");
		}
	}

}
