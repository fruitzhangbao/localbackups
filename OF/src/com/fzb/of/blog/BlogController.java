package com.fzb.of.blog;

import java.util.Date;
import java.util.List;

import org.apache.taglibs.standard.extra.spath.Step;

import com.fzb.of.account.Account;
import com.fzb.of.blog.type.BType;
import com.fzb.of.common.SessionCheckInterceptor;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before({SessionCheckInterceptor.class, BlogInterceptor.class})
public class BlogController extends Controller {
	//进入到博客首页面
	public void index() {
		//所有的博客列表
		//1.用户所有的博客分类，包含每个分类下的博客数目
		setAttr("btypes", BType.me.findAllBTypesByUserId(getUserIdFromSession()));
		//2.用户的博客列表
		setAttr("blogPage", Blog.me.paginate(getParaToInt(0, 1), 10, getUserIdFromSession()));
		render("in.jsp");
	}
	
	
	//进入到博客管理页面
	public void mgr() {
		setAttr("blogPage", Blog.me.paginate(getParaToInt(0, 1), 10, getUserIdFromSession()));
		render("blog.jsp");
	}
	
	//进入到单个博客页面
	public void du() {
		Integer para = getParaToInt();
		/**
		 * 1.现将该博客的readnum字段+1
		 * 2.然后在读取该博客信息
		 */
		setAttr("blog", Blog.me.afterUpdateReadnum(para));
		//博客所属的分类
		setAttr("type", BType.me.findByBlogId(para));
		render("a.jsp");
	}
	
	//add--->save
	public void add() {
		//找到某个账户下的所有博客分类列表
		setAttr("btypes", BType.me.findBTypesByUserId(getUserIdFromSession()));
		render("add.jsp");
	}
	
	@Before(BlogValidator.class)
	public void save() {
		//System.out.println("进入blog.save中");
		boolean returnV = getModel(Blog.class).set("birth", new Date()).set("userId", getUserIdFromSession()).save();
		if(returnV) {
			System.out.println("博客保存成功");
			redirect("/blog");
		} else {
			System.out.println("博客保存失败");
			render("add.jsp");
		}
		
	}
	//edit--->update
	public void edit() {
		//1.用户所有的博客分类
		setAttr("btypes", BType.me.findAllBTypesByUserId(getUserIdFromSession()));
		//2.用户要修改的博客
		setAttr("blog", Blog.me.findById(getParaToInt()));
	}
	
	@Before(BlogValidator.class)
	public void update() {
		getModel(Blog.class).update();
		redirect("/blog");
	}
	
	public void delete() {
		Blog.me.deleteById(getParaToInt());
		redirect("/blog");
	}
	
	//博客搜索
	public void search() {
		//1.获得关键字
		String keywords = getPara("keywords");
		if(keywords != null) {
			//根据用户输入的关键字查询博客信息
			setAttr("keywords", keywords);
			setAttr("blogPage", Blog.me.paginateByKeyWords(getParaToInt(0, 1), 10, getUserIdFromSession(), keywords));
			//用户所有的博客分类，包含每个分类下的博客数目
			setAttr("btypes", BType.me.findAllBTypesByUserId(getUserIdFromSession()));
			render("in.jsp");
			return;
		}
		redirect("/blog");
	} 
	
	
	//获得session中的用户id
	private Integer getUserIdFromSession() {
		return ((Account)getSession().getAttribute("user")).getInt("id");
	}
}


