package com.myboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydao.FirstBoardDAO;
import com.mydto.FirstBoardDTO;

/**
 * Servlet implementation class MyWrite
 */
@WebServlet("/MyWrite")
public class MyWrite extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String title = request.getParameter("m_title");
		System.out.println("Title : " + title);
		String content = request.getParameter("m_content");
		System.out.println("Content : " + content);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateFormat.format(new Date());
		System.out.println("Date : " + date);
		System.out.println("--------------------");
		
		FirstBoardDTO boardDTO = new FirstBoardDTO(title, content, date, "WRITER");
		FirstBoardDAO boardDAO = new FirstBoardDAO();
		boardDAO.insertWrite(boardDTO);
		
		response.sendRedirect("MyBoard");
		/*
		 * ArrayList<FirstBoardDTO> array = boardDAO.selectAll(); for(FirstBoardDTO i :
		 * array) { System.out.println(i.getNo()); System.out.println(i.getTitle());
		 * System.out.println(i.getContent()); System.out.println(i.getDate());
		 * System.out.println(i.getWriter());
		 * System.out.println("===================="); }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
