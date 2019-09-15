package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService {
	
	//注入mapper
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;

	//商品查询列表
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(int id) throws Exception {
		
		Items items = itemsMapper.selectByPrimaryKey(id);
		//如果查询的商品信息为空，抛出系统 自定义的异常
		if(items==null){
				throw new CustomException("修改商品信息不存在");
		}
		//在这里随着需求的变量，需要查询商品的其它的相关信息，返回到controller
		
		ItemsCustom itemsCustom = new ItemsCustom();
		//将items的属性拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception {
		//写业务代码
		
		//对于关键业务数据的非空校验
		if(id == null){
			//抛出异常，提示调用接口的用户，id不能为空
			//...
		}
		//itemsMapper.updateByPrimaryKey(itemsCustom);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		
	}

}
