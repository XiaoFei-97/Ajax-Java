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


public class CityServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// 1.获取客户端提交上来的省份pid
			int pid = Integer.parseInt(request.getParameter("pid"));
			System.out.println("ajax来了");
			// 2.拿到pid后，使用dao进行查询封装
			CityDaoImpl dao = new CityDaoImpl();
			List<CityBean> cityList = dao.findCity(pid);
			
			// 3.转化成xml对象
			XStream xStream = new XStream();
			
			// 把id做成属性
			// xStream.useAttributeFor(CityBean.class, "id");
			
			// 设置别名
			xStream.alias("city", CityBean.class);
			
			// 转回javaBean对象:xStream.fromXML(file)
			String xml = xStream.toXML(cityList);
			System.out.println(xml);
			
			// 4.返回给页面
			response.setContentType("text/xml;charset=utf-8");
			response.getWriter().write(xml);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
