package com.jzfblog.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jzfblog.dao.impl.CityDaoImpl;
import com.jzfblog.domain.CityBean;
import com.thoughtworks.xstream.XStream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class CityServlet02 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取客户端提交上来的省份pid
			int pid = Integer.parseInt(request.getParameter("pid"));
			System.out.println("ajax来了");
			// 2.拿到pid后，使用dao进行查询封装
			CityDaoImpl dao = new CityDaoImpl();
			List<CityBean> cityList = dao.findCity(pid);
			
			// 3.转化成json对象
			// JSONObject,jsonArray
			JSONArray jsonArray = JSONArray.fromObject(cityList);
			String json = jsonArray.toString();
			 System.out.println(json);
			
			// 4.返回给页面
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(json);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
