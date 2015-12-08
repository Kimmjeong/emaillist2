package com.hanains.emaillist.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.emaillist.http.action.EmailListActionFactory;
import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;

@WebServlet("/el")
public class EmailListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// getAction 메서드를 구현하도록 하기 위해 상위 클래스로 ActionFactory를 두고 EmailListActionFactory는 getAction메서드를 구현해야 한다.
		ActionFactory actionFactory=new EmailListActionFactory();
		
		String actionName=request.getParameter("a"); // a를 통해 actionName(jsp페이지 이름)을 받아온다.
		Action action = actionFactory.getAction(actionName); // 어떤 클래스 안의 execute를 사용할지를 반환한다.
		
		action.execute(request, response); // 해당 클래스의 execute를 실행한다.
		
		
		
		/*
		if("form".equals(actionName)){
			
			HttpUtil.forwarding(request, response, "/WEB-INF/views/form.jsp");
			
		} else if("insert".equals(actionName)){
			
			String firstName=request.getParameter("fn");
			String lastName=request.getParameter("ln");
			String email=request.getParameter("email");
			
			EmailListVo vo=new EmailListVo();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			
			EmailListDao dao=new EmailListDao();
			dao.insert(vo);
			
			response.sendRedirect("/emaillist2/el");
			
		} else { // index (default action)
			EmailListDao dao=new EmailListDao();
			List<EmailListVo> list=dao.getList();
			
			request.setAttribute("list", list);
			
			// forwarding
			HttpUtil.forwarding(request, response, "/WEB-INF/views/index.jsp");
		}
		*/
		
	}

}
