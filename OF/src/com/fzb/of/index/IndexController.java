package com.fzb.of.index;

import com.jfinal.core.Controller;

/**
 * IndexController
 * @author Administrator
 *
 */
public class IndexController extends Controller {
	public void index() {
		render("index.jsp");
	}
}
