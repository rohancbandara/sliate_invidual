package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.rcb.model.Docter;
import com.rcb.model.Special;
import com.rcb.service.DocterService;

@WebServlet("/")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class FailDocterAddServlet extends HttpServlet {
	private static final String SAVE_DIR = "Docter_IMG";
	Docter docter = new Docter();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Special special = new Special();
		docter.setD_FName(request.getParameter("txtFname"));
		docter.setD_LName(request.getParameter("txtLname"));
		docter.setD_email(request.getParameter("txtEmail"));
		docter.setD_special(Integer.parseInt(request.getParameter("special")));

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

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				// return docter.getD_FName() + docter.getD_FName() + s.substring(s.indexOf("=")
				// + 2, s.length() - 1);
				return "rcb" + s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

}
