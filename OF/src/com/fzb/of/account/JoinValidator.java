package com.fzb.of.account;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class JoinValidator extends Validator {

	@Override
	protected void validate(Controller c) {
		
		validateRequiredString("account.name", "nameMsg", "请输入账户名");
		validateRequiredString("account.pswd", "pswdMsg", "请输入密码");
		validateEmail("account.email", "emailMsg", "请输入正确的邮箱号");
		validateEqualField("account.pswd", "repswd", "pswdErrorMsg", "两次密码要输入一致");
	}

	@Override
	protected void handleError(Controller c) {
		c.keepModel(Account.class);
		c.render("join.jsp");
	}

}
