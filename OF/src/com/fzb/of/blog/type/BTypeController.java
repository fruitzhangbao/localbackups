package com.fzb.of.blog.type;

import com.fzb.of.account.Account;
import com.fzb.of.blog.Blog;
import com.fzb.of.common.SessionCheckInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

/**
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before({SessionCheckInterceptor.class, BTypeInterceptor.class})
public class BTypeController extends Controller {
	
	//进入到博客分类首页面
	public void index() {
		Integer btypeId = getParaToInt(0);
		
		if(btypeId == null) {
			//用户所有的博客分类，包含每个分类下的博客数目
			setAttr("btypes", BType.me.findAllBTypesByUserId(getUserIdFromSession()));
			render("mgr.jsp");
			
			//render("in.jsp");
		} else {
		    //跳到用户某个分类下的所有博客
			//1.根据博客分类id找到该博客分类名
			setAttr("bType", BType.me.findById(btypeId));
			//2.找到该用户的该博客分类下所有的博客
			setAttr("blogPage", Blog.me.paginateByBType(getParaToInt(1, 1), 10, btypeId, getUserIdFromSession()));
			//setAttr("blogPage", Blog.me.paginateByBType(1, 10, btypeId, getUserIdFromSession()));
			//3.用户所有的博客分类，包含每个分类下的博客数目
			setAttr("btypes", BType.me.findAllBTypesByUserId(getUserIdFromSession()));
			render("blog.jsp");
		}
		
		
	}
	
	//进入博客分类管理页面
	public void mgr() {
		//用户所有的博客分类，包含每个分类下的博客数目
		setAttr("btypes", BType.me.findAllBTypesByUserId(getUserIdFromSession()));
		render("mgr.jsp");
	}
	
	//add--->save
	public void add() {
		//找到某个账户下的所有博客分类列表
		render("add.jsp");
	}
	
	@Before(BTypeValidator.class)
	public void save() {
		boolean returnV = getModel(BType.class).set("isdelete", 0).save();
		if(returnV) {
			System.out.println("博客分类保存成功");
			redirect("/blog/bt/mgr");
		} else {
			System.out.println("博客分类保存失败");
			render("add.jsp");
		}
		
	}
	//edit--->update
	public void edit() {
		Integer btypeId = getParaToInt();
		if(btypeId != null) {
			//用户要修改的博客分类
			setAttr("btype", BType.me.findById(btypeId));
		} else {
		    //跳到用户分类概览界面
			redirect("/blog/bt");
		}
		
	}
	
	@Before(BTypeValidator.class)
	public void update() {
		getModel(BType.class).update();
		redirect("/blog/bt");
	}
	
	public void delete() {
		Integer btypeId = getParaToInt();
		if(btypeId != null) {
			//删除博客分类不是真的删除而是将该分类的isdelete字段值设置为1即可
			//BType.me.deleteById();
			if(BType.me.findById(btypeId).set("isdelete", 1).update()) {
				redirect("/blog/bt");
				return;
			}
		}
		redirect("/blog/bt/mgr");
	}
	
	//获得session中的用户id
	private Integer getUserIdFromSession() {
		return ((Account)getSession().getAttribute("user")).getInt("id");
	}
	
}


