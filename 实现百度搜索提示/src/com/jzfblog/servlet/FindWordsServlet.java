package com.jzfblog.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzfblog.dao.impl.WordsDaoImpl;
import com.jzfblog.domain.WordBean;

/**
 * 查找关键字
 * @author 蒋振飞
 *
 */
public class FindWordsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			// 1.获取客户端提交的word参数
			String word = request.getParameter("word");
			System.out.println(word);
			
			// 2.直接使用dao获取查询关键字
			WordsDaoImpl dao = new WordsDaoImpl();
			List<WordBean> wordslist = dao.findWords(word);
			
			
			// 3.返回数据
			response.setContentType("text/html;charset=utf-8");
			request.setAttribute("wordslist", wordslist);
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
