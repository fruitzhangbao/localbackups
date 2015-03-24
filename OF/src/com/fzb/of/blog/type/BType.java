package com.fzb.of.blog.type;

import java.util.List;

import com.fzb.of.blog.Blog;
import com.jfinal.plugin.activerecord.Model;

@SuppressWarnings("serial")
public class BType extends Model<BType> {
	
	public static final BType me = new BType();
	
	/**
	 * 找到某个账户下的所有博客分类,以及每个博客分类下的博客数
	 */
	public List<BType> findAllBTypesByUserId(int userId) {
		return find("SELECT bt.id id, bt.name name, b.typenum num FROM" +
				"(SELECT id, name FROM of_btype  WHERE userId = ? AND isdelete=0) bt LEFT JOIN" +
				"(SELECT typeId, COUNT(*) typenum FROM of_blog WHERE userId=? GROUP BY typeId) b on bt.id=b.typeId", userId, userId);
	}
	/**
	 * 找到某个账户下的所有博客分类列表
	 * @param userId
	 * @return
	 */
	public List<BType> findBTypesByUserId(int userId) {
		return find("select id, name from of_btype where userId=?", userId);
	}
	
	/**
	 * 通过博客的Id找到博客所属于的分类
	 * @param blogId
	 * @return
	 */
	public BType findByBlogId(int blogId) {
		//1.先通过博客的id找到博客分类的ID
		Blog b = Blog.me.findFirst("SELECT typeId FROM of_blog WHERE id=?", blogId);
		//2.再通过博客分类的id，找到博客分类的名称
		return findFirst("SELECT id, name FROM of_btype WHERE id= ?", b.getInt("typeId"));
	}
	
	
	
	
	
	
	
	
}
