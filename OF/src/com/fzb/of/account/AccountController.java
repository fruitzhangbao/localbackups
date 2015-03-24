package com.fzb.of.account;

import java.util.Date;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

@Before(AccountInterceptor.class)
public class AccountController extends Controller {
	
	//进入到网站登录首页
	public void index() {
		render("deng.jsp");
	}
	
	//进入到网站登录首页
	@SuppressWarnings("unused")
	@Before(LoginValidator.class)
	public void deng() {
		
		//如果是填入登录数据后（/deng/o）的登录,则进行检验
		if(getPara().startsWith("o")) {
			Account a = Account.me.loginCheck(getModel(Account.class));
			
			//System.out.println(a.getStr("name")+" | "+a.getInt("id") + " | " +a.getStr("pswd"));
			
			//用户登录成功
			if(a != null) {
				setSessionAttr("user", a);
				redirect("/blog");
				return;
			} 
			
			//用户登录失败
			setAttr("loginErrorMsg", "账号与密码不匹配，请重新出入");
			setAttr("account.name", getModel(Account.class).getStr("name"));
			render("deng.jsp");
		}
	}
	
	//进入到网站注册首页
	@Before(JoinValidator.class)
	public void join() {
	   //如果是填入登录数据后（/deng/o）的登录,则进行检验
	   if(getPara().startsWith("o")) {
			Account aNew = getModel(Account.class).set("fromwhen", new Date());
			boolean returnV = Account.me.register(aNew);
			//如果注册成功（即用数据已经注入到数据库）,那么保存用户信息于session，跳跃到blog首页
			if(returnV) {
				setSessionAttr("user", aNew);
				redirect("/blog");
			} else {
				//返回重新注册
				render("join.jsp");
			}
	   }
	}
	
	//账号注销
	public void out() {
		getSession().setAttribute("user", null);
		redirect("/");
	}
}
