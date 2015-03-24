package com.fzb.of.blog;

import com.fzb.of.account.Account;
import com.fzb.of.blog.type.BType;
import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class BlogValidator extends Validator {
	
	protected void validate(Controller controller) {
		validateRequiredString("blog.title", "titleMsg", "请输入Blog标题!");
		validateRequiredString("blog.content", "contentMsg", "请输入Blog内容!");
		validateRequiredString("blog.typeId", "btyteMsg", "请输入Blog类型!");
	}
	
	//此方法只有在校验失败后才会被调用
	protected void handleError(Controller controller) {
		controller.keepModel(Blog.class);
		controller.getRequest().setAttribute("btypes", BType.me.findBTypesByUserId(((Account)controller.getSession().getAttribute("user")).getInt("id")));
		
		String actionKey = getActionKey();
		if (actionKey.equals("/blog/save"))
			controller.render("add.jsp");
		else if (actionKey.equals("/blog/update"))
			controller.render("edit.jsp");
	}
}
