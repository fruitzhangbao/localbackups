package com.fzb.of.account;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		
		validateRequiredString("account.name", "nameMsg", "请输入账户名");
		validateRequiredString("account.pswd", "pswdMsg", "请输入密码");
	}

	@Override
	protected void handleError(Controller c) {
		c.keepModel(Account.class);
		c.render("deng.jsp");
	}

}
