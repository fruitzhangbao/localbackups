package com.fzb.of.blog;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

/**
 * Blog model.

将表结构放在此，消除记忆负担
mysql> desc blog;
+---------+--------------+------+-----+---------+----------------+
| Field   | Type         | Null | Key | Default | Extra          |
+---------+--------------+------+-----+---------+----------------+
| id      | int(11)      | NO   | PRI | NULL    | auto_increment |
| title   | varchar(200) | NO   |     | NULL    |                |
| content | mediumtext   | NO   |     | NULL    |                |
+---------+--------------+------+-----+---------+----------------+

数据库字段名建议使用驼峰命名规则，便于与 java 代码保持一致，如字段名： userId
 */
@SuppressWarnings("serial")
public class Blog extends Model<Blog> {
	public static final Blog me = new Blog();
	
	/**
	 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
	 */
	public Page<Blog> paginate(int pageNumber, int pageSize, int userId) {
		return paginate(pageNumber, pageSize, "select *", "from of_blog where isdelete=0 and userId=? order by id desc", userId);
	}
	
	public Page<Blog> paginateByBType(int pageNumber, int pageSize, int bTypeId, int userId) {
		return paginate(pageNumber, pageSize, "select *", "from of_blog where isdelete=0 and userId=? and typeId=? order by id desc", userId, bTypeId);
	}
	
	/**
	 * 根据关键字和
	 */
	public Page<Blog> paginateByKeyWords(int pageNumber, int pageSize,
			Integer userId, String keywords) {
		return paginate(pageNumber, pageSize, "select *", "from of_blog where isdelete=0 and userId=? and title Like ? order by id desc", userId, "%"+keywords+"%");
	}
	
	/**
	 * 每浏览一次博文，就将博客的readnum+1,然后再取出博文内容
	 * @param para
	 * @return
	 */
	public Blog afterUpdateReadnum(int blogId) {
		//1.先将博客的阅读数目+1,然后获取
		int returnV = Db.update("UPDATE of_blog SET readnum=readnum+1 WHERE id=?", blogId);
		if(returnV == 1) {
			return findFirst("SELECT * FROM of_blog WHERE id=? LIMIT 1", blogId);
		}
		return null;
	}
	
	
	
	
}
