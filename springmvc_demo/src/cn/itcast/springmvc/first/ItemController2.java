package cn.itcast.springmvc.first;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.itcast.springmvc.po.Items;

/**
 * 
 * <p>
 * Title: ItemController1
 * </p>
 * <p>
 * Description:入门程序，商品列表查询
 * </p>
 */
public class ItemController2 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 使用静态数据将商品信息列表显示在jsp页面
		// 商品列表
		List<Items> itemsList = new ArrayList<Items>();

		Items items_1 = new Items();
		items_1.setName("联想笔记本");
		items_1.setPrice(6000f);
		items_1.setCreatetime(new Date());
		items_1.setDetail("ThinkPad T430 联想笔记本电脑！");

		Items items_2 = new Items();
		items_2.setName("苹果手机");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6苹果手机！");

		itemsList.add(items_1);
		itemsList.add(items_2);
		
		request.setAttribute("itemsList", itemsList);
		//转发到jsp页面
		request.getRequestDispatcher("/WEB-INF/jsp/itemsList.jsp").forward(request, response);
		
		
	}

	
}
