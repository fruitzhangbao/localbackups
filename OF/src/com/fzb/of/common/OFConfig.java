package com.fzb.of.common;

import com.fzb.of.account.Account;
import com.fzb.of.account.AccountController;
import com.fzb.of.blog.Blog;
import com.fzb.of.blog.BlogController;
import com.fzb.of.blog.type.BType;
import com.fzb.of.blog.type.BTypeController;
import com.fzb.of.index.IndexController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.ViewType;

/**
 * 对整个OF项目进行配置
 */
public class OFConfig extends JFinalConfig {
	
	/**
	 * 配置JFinal常量值。如：
	 * 开发模式常量devMode的配置，
	 * 默认试图类型ViewType的配置
	 */
	public void configConstant(Constants me) {
		loadPropertyFile("a_little_config.txt");				// 加载少量必要配置，随后可用getProperty(...)获取值
		/**
		 * 设置开发模式。
		 * 在开发模式下，JFinal会对每次请求输出报告。如：
		 * 本次请求的Controller、Method以及请求所携带的参数。
		 */
		me.setDevMode(getPropertyToBoolean("devMode", false));
		me.setViewType(ViewType.JSP); 							// 设置视图类型为Jsp，否则默认为FreeMarker
	}
	
	/**
	 * 配置JFinal的访问路由,且参数Routes类型主要就这两个方法
	 */
	public void configRoute(Routes me) {
		/**
		 * 关于第三个参数[视图存放路径/返回视图的相对路径]的说明：
		 * 1."/index"会转到"项目名/index"文件目录下
		 * 2.第三个参数省略时默认与第一个参数值相同
		 */
		//me.add("/", IndexController.class, "/index");	// 第三个参数为该Controller的视图存放路径
		//me.add("/blog", BlogController.class);			// 第三个参数省略时默认与第一个参数值相同，在此即为 "/blog"
		
		/**
		 * me.add( "/",    IndexController.class, "/index");
		 *   controllerKey, controllerClass,      viewPath
		 */
		
		me.add(new FrontRoutes());
		me.add(new AdminRoutes());
	}
	
	/**
	 * 配置插件
	 * 
	 */
	public void configPlugin(Plugins me) {
		// 配置C3p0数据库连接池插件
		C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		me.add(c3p0Plugin);
		
		// 配置ActiveRecord插件
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("of_blog", Blog.class);	// 映射of_blog 表到 Blog模型
		arp.addMapping("of_user", Account.class); //映射of_user表到Account模型
		arp.addMapping("of_btype", BType.class); //映射of_btype表到Account模型
	}
	
	/**
	 * 配置全局拦截器
	 */
	public void configInterceptor(Interceptors me) {
		
	}
	
	/**
	 * 配置处理器
	 */
	public void configHandler(Handlers me) {
		
	}
	
	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目
	 * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 * 
	 * public static void main(String[] args) {
			JFinal.start("WebRoot", 80, "/", 5);
		}
	 * 
	 */
	
	//===========================前后端路由配置---->开始====================================//
	/**
	 * 前段路由配置
	 */
	private class FrontRoutes extends Routes {

		@Override
		public void config() {
			add("/", IndexController.class, "/index");
			add("/blog", BlogController.class, "/blog" );
			add("/blog/bt", BTypeController.class, "/bt");
			add("/account", AccountController.class, "/account");
		}
		
	}

	/**
	 * 后端路由配置
	 */
	private class AdminRoutes extends Routes {

		@Override
		public void config() {
			//add("/admin", AdminController.class, "/admin");
			//add("/admin/user", UserController.class, "/admin/user");
		}
	}
	//===========================前后端路由配置---->结束====================================//
}
