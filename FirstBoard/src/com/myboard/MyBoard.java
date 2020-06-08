package com.myboard;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mydao.FirstBoardDAO;
import com.mydto.FirstBoardDTO;

/**
 * Servlet implementation class MyBoard
 */
@WebServlet("/MyBoard")
public class MyBoard extends HttpServlet {
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FirstBoardDAO boardDAO = new FirstBoardDAO();
		ArrayList<FirstBoardDTO> arrayList = boardDAO.selectAll();
		
		request.setAttribute("writeList", arrayList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("board.jsp");
		dispatcher.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
