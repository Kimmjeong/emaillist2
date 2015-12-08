package com.hanains.emaillist.http.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.emaillist.dao.EmailListDao;
import com.hanains.emaillist.vo.EmailListVo;
import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EmailListDao dao=new EmailListDao();
		List<EmailListVo> list=dao.getList();
		
		request.setAttribute("list", list);
		
		// forwarding
		HttpUtil.forwarding(request, response, "/WEB-INF/views/index.jsp");
	}

}
