package com.fzb.of.account;

import java.util.List;

import com.fzb.of.blog.type.BType;
import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class Account extends Model<Account>{
	
	public static final Account me = new Account();
	
	public Account loginCheck(Account a) {
		List<Account> guo = find("SELECT * FROM of_user WHERE name=? AND pswd=? and isdelete=0", a.getStr("name"), a.getStr("pswd"));
		if(guo != null && guo.size() == 1) {
			return guo.get(0);
		}
		return null;
	}
	
	/**
	 * 注册新账户
	 * 1.存入账户信息
	 * 2.生成默认博客分类"默认分类"
	 * @param aNew
	 * @return
	 */
	public boolean register(Account aNew) {
		//1.存入账户信息成功
		if(aNew.save()) {
			//System.out.println("用插入用户的id===>"+aNew.getInt("id"));
			//2.返回默认博客分类插入是否成功
			return new BType().set("userId", aNew.getInt("id")).set("name", "默认分类").set("isdelete", 0).save();
		}
		return false;
	}
	
}
