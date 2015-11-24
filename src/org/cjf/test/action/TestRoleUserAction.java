package org.cjf.test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.cjf.action.AbstractWebAction;
import org.cjf.action.roleuser.RoleUserCreateAction;
import org.cjf.entity.RoleUser;
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
public class TestRoleUserAction extends StrutsSpringJUnit4TestCase<AbstractWebAction> {
	public static String inActionUrl = "/listUsersInRole.do";
	public static String notInActionUrl = "/listUsersNotInRole.do";
	
	public static String createUrl = "/createRoleUser.do";
	public static String removeUrl = "/removeRoleUser.do";
	
//	@Test
//	public void test001In() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		RoleUser item = new RoleUser();
//		item.setRoleCode("roleHalo");
//		
//		String jsonString = JSONUtil.objToJsonStr(item, "");
//		request.addParameter("jsonString", jsonString);
//		
//		ActionProxy proxy = this.getActionProxy(inActionUrl);
//		RoleUserGetListInRoleAction action = (RoleUserGetListInRoleAction) proxy.getAction();
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//		String jsonValue = action.getJsonValue();
//		System.out.println(jsonValue);
//	}
//	
//	@Test
//	public void test002In() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		RoleUser item = new RoleUser();
//		item.setRoleCode("roleHalo");
//		
//		String jsonString = JSONUtil.objToJsonStr(item, "");
//		request.addParameter("jsonString", jsonString);
//		
//		ActionProxy proxy = this.getActionProxy(notInActionUrl);
//		RoleUserGetListNotInRoleAction action = (RoleUserGetListNotInRoleAction) proxy.getAction();
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//		String jsonValue = action.getJsonValue();
//		System.out.println(jsonValue);
//	}
	
	@Test
	public void test003Create() throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute(AppConst.SESSION_USER, new User());
		
		RoleUser item1 = new RoleUser();
		item1.setRoleCode("roleHaloA");
		item1.setUserCode("zhangsf");
		
		RoleUser item2 = new RoleUser();
		item2.setRoleCode("roleHaloA");
		item2.setUserCode("zhangcs");
		
		List<RoleUser> list = new ArrayList<RoleUser>();
		list.add(item1);
		list.add(item2);
		
		String jsonString = JSONUtil.listToJsonStr(list, "");
		request.addParameter("jsonString", jsonString);
		
		ActionProxy proxy = this.getActionProxy(createUrl);
		RoleUserCreateAction action = (RoleUserCreateAction) proxy.getAction();
		String result = proxy.execute();

		Assert.assertEquals("success", result);
		String jsonValue = action.getJsonValue();
		System.out.println(jsonValue);
	}
	
//	@Test
//	public void test004Remove() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		RoleUser item1 = new RoleUser();
//		item1.setRoleCode("roleHalo");
//		item1.setUserCode("zhangsf");
//		
//		RoleUser item2 = new RoleUser();
//		item2.setRoleCode("roleHalo");
//		item2.setUserCode("zhangcs");
//		
//		List<RoleUser> list = new ArrayList<RoleUser>();
//		list.add(item1);
//		list.add(item2);
//		
//		String jsonString = JSONUtil.listToJsonStr(list, "");
//		request.addParameter("jsonString", jsonString);
//		
//		ActionProxy proxy = this.getActionProxy(removeUrl);
//		RoleUserRemoveAction action = (RoleUserRemoveAction) proxy.getAction();
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//		String jsonValue = action.getJsonValue();
//		System.out.println(jsonValue);
//	}
	
//	@Test
//	public void test005CreateError() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		RoleUser item1 = new RoleUser();
//		item1.setRoleCode("roleHalo");
//		item1.setUserCode("zhangsf");
//		
//		RoleUser item2 = new RoleUser();
//		item2.setRoleCode("roleHalo");
//		item2.setUserCode("zhangcs");
//		
//		RoleUser item3 = new RoleUser();
//		item3.setRoleCode("roleHalo");
//		item3.setUserCode("john");
//		
//		List<RoleUser> list = new ArrayList<RoleUser>();
//		list.add(item1);
//		list.add(item2);
//		list.add(item3);
//		
//		String jsonString = JSONUtil.listToJsonStr(list, "");
//		request.addParameter("jsonString", jsonString);
//		
//		ActionProxy proxy = this.getActionProxy(createUrl);
//		RoleUserCreateAction action = (RoleUserCreateAction) proxy.getAction();
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//		String jsonValue = action.getJsonValue();
//		System.out.println(jsonValue);
//	}
	
}
