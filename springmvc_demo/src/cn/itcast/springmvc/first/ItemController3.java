package cn.itcast.springmvc.first;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
@Controller
public class ItemController3 {
	//商品列表，@RequestMapping中url建议和方法名一致，方便开发维护
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(){
		
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
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		//指定逻辑视图名
		modelAndView.setViewName("itemsList");

		return modelAndView;
	}
	
	//商品添加
	
	//商品删除 

	
}
