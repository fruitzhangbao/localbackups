package com.fzb.of.account;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

/**
 * AcountInterceptor
 *
 */
public class AccountInterceptor implements Interceptor {

	@Override
	public void intercept(ActionInvocation ai) {
		System.out.println("Before invoking " + ai.getActionKey());
		ai.invoke();
		System.out.println("After invoking " + ai.getActionKey());
	}

}
