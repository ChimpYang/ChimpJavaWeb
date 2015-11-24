package org.cjf.test.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.cjf.action.AbstractWebAction;
import org.cjf.action.menu.MenuGetTreeNodeAction;
import org.cjf.entity.Menu;
import org.cjf.entity.User;
import org.cjf.util.json.JSONUtil;
import org.cjf.utils.properties.AppConst;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionProxy;

@SuppressWarnings("rawtypes")
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(locations = { "classpath:resources/test/action/context.xml" })
public class TestMenuAction extends StrutsSpringJUnit4TestCase<AbstractWebAction> {
	public static String listUrl = "/getMenuTree.do";
	
	@Test
	public void test001Tree() throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute(AppConst.SESSION_USER, new User());
		
		Menu item = new Menu();
		item.setSystemTypeCode("sysFramework");
		
		String jsonString = JSONUtil.objToJsonStr(item, "");
		request.addParameter("jsonString", jsonString);
		
		ActionProxy proxy = this.getActionProxy(listUrl);
		MenuGetTreeNodeAction action = (MenuGetTreeNodeAction) proxy.getAction();
		String result = proxy.execute();
		System.out.println(result);

		Assert.assertEquals("success", result);
		String jsonValue = action.getJsonValue();
		System.out.println(jsonValue);
	}
}
