package cn.leelei.bms.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import cn.leelei.bms.entity.User;

public class TestBeanUtils {
	/**
	 * 使用BeanUtils 将数据复制封装到对象中区
	 * 复制成功的原则，map中的key必须和  实体User中的属性名称一致的，不一致就不成功
	 * 必须保正属性一致  原理是通过反射来实现的
	 */
	@Test
	public void  CopyProperties() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userName", "admin");
			map.put("upassWord", "admin");
			map.put("id", "1");
			
			User dest= new User();
			//将map放到user对象中
			BeanUtils.copyProperties(dest, map);
			System.err.println(dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
