package com.fzb.of.common;

import com.fzb.of.account.Account;
import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;
import com.jfinal.core.Controller;

/**
 * AcountInterceptor
 *
 */
public class SessionCheckInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		System.out.println("Before invoking " + ai.getActionKey());
		Controller controller = ai.getController();
		Account account = controller.getSessionAttr("user");  
		if (account != null){ ai.invoke(); 
		} else {
		   controller.redirect("/account"); 
		   return;
		}     
		System.out.println("After invoking " + ai.getActionKey());
	}

}
