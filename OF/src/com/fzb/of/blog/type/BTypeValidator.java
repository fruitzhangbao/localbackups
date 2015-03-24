package com.fzb.of.blog.type;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class BTypeValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("bType.name", "nameMsg", "请输入Blog的分类名称");
		validateRequiredString("bType.userId", "userMsg", "不存在有效用户");
	}
	
	//此方法只有在校验失败后才会被调用
	protected void handleError(Controller controller) {
		controller.keepModel(BType.class);

		String actionKey = getActionKey();
		if (actionKey.equals("/blog/bt/save"))
			controller.render("add.jsp");
		else if (actionKey.equals("/blog/bt/update"))
			controller.render("edit.jsp");
	}
}
