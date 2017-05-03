package com.water.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Water on 17/4/14.
 * Email:water471871679@gmail.com
 */
public class MyServlet extends HttpServlet {
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
		HttpServletResponse response = (HttpServletResponse) resp;
		response.getWriter().write("hello servlet");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

//	@Override
//	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
//		HttpServletResponse response = (HttpServletResponse) servletResponse;
//		response.getWriter().write("hello servlet");
//	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {

	}
}
