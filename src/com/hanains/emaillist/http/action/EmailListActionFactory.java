package com.hanains.emaillist.http.action;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;

public class EmailListActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("form".equals(actionName)){
			
			// Action는 execute 메서드가 선언된 인터페이스이므로 이를 상위 클래스로 객체를 생성하면 객체 생성 클래스에서 execute를 구현해야 한다.
			action=new FormAction();
			
		} else if("insert".equals(actionName)){
			
			action=new InsertAction();
			
		} else{
			
			action = new IndexAction();
			
		}
		
		return action;
	}

}
