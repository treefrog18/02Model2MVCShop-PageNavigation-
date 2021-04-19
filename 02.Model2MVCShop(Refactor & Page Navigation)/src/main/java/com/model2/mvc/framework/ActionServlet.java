package com.model2.mvc.framework;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.util.HttpUtil;


public class ActionServlet extends HttpServlet {
	
	///Field
	private RequestMapping requestMapping;
	
	///Method
	@Override
	public void init() throws ServletException {
		super.init();
		String resources=getServletConfig().getInitParameter("resources");
		requestMapping=RequestMapping.getInstance(resources);
		System.out.println("Actionservlet init start");
		System.out.println("resources�� :"+resources);
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
																						throws ServletException, IOException {
		System.out.println("====actionservlet service start====");
		String url = request.getRequestURI();
		System.out.println("url��:"+url);
		String contextPath = request.getContextPath();
		System.out.println("contextPath��:"+contextPath);
		String reqeustPath = url.substring(contextPath.length());
		System.out.println("\nActionServlet.service() RequestURI : "+reqeustPath);
		
		try{
			System.out.println("requestMapping.getAction�� ���ڰ�:"+reqeustPath);
			Action action = requestMapping.getAction(reqeustPath);
			action.setServletContext(getServletContext());
			System.out.println("getServletContext()�� �� : "+ getServletContext());
			
			String resultPage=action.execute(request, response);
			System.out.println("resultPage �� :"+resultPage);
			String path=resultPage.substring(resultPage.indexOf(":")+1);
			System.out.println("path �� :"+path);
			if(resultPage.startsWith("forward:")){
				HttpUtil.forward(request, response, path);
			}else{
				HttpUtil.redirect(response, path);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
			System.out.println("====actionservlet service End====\n\n");
	}
}