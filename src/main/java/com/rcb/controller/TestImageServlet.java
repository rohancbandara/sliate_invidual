package com.rcb.controller;

import java.io.File;
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

@WebServlet("/test")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50)
public class TestImageServlet extends HttpServlet {
	private static final String SAVE_DIR = "Docter_IMG";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Docter docter = new Docter();
		// PrintWriter out = response.getWriter();
		String savePath = "D:/tecnosoft_JAVA_EE/workshop/RCB_Medicle_Center/WebContent/" + SAVE_DIR + "/";

		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		Part part = request.getPart("file");
		String fileName = extractFileName(part);

		part.write(savePath + fileName);

		String filePath = savePath + fileName;
		System.out.println("file path =" + filePath);
		System.out.println("file part =" + part);
		System.out.println(File.separator);

		Special special = new Special();
		docter.setD_FName(request.getParameter("txtFname"));
		docter.setD_LName(request.getParameter("txtLname"));
		docter.setD_email(request.getParameter("txtEmail"));
		docter.setD_special(Integer.parseInt(request.getParameter("special")));
		docter.setImg_path(filePath);

		System.out.println(docter.getImg_path() + "xxxxxxxxxx");

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

		// fu.saveFile(firstName, lastName, filePath);

	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return "rcb" + s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}
