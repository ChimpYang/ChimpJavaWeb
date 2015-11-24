package org.cjf.test.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.cjf.action.AbstractWebAction;
import org.cjf.action.rolemenuauth.RoleMenuAuthCreateAction;
import org.cjf.entity.RoleMenuAuth;
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
public class TestRoleMenuAuthAction extends StrutsSpringJUnit4TestCase<AbstractWebAction> {
	public static String createUrl = "/createRoleMenuAuth.do";
	public static String listUrl = "/getListRoleMenuAuth.do";
	
//	@Test
//	public void test001List() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		RoleMenuAuth item = new RoleMenuAuth();
//		item.setRoleCode("roleAdmin");
//		
//		String jsonString = JSONUtil.objToJsonStr(item, "");
//		request.addParameter("jsonString", jsonString);
//		
//		ActionProxy proxy = this.getActionProxy(listUrl);
//		RoleMenuAuthGetListAction action = (RoleMenuAuthGetListAction) proxy.getAction();
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//		String jsonValue = action.getJsonValue();
//		System.out.println(jsonValue);
//	}
	
	@Test
	public void test002Create() throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute(AppConst.SESSION_USER, new User());
		
		RoleMenuAuth item;
		List<RoleMenuAuth> list = new ArrayList<RoleMenuAuth>();
		
		item = new RoleMenuAuth();
		item.setRoleCode("roleHalo");
		item.setMenuCode("FW");
		item.setCanCreate(1);
		list.add(item);
		
		item = new RoleMenuAuth();
		item.setRoleCode("roleHalo");
		item.setMenuCode("FW01");
		item.setCanCreate(1);
		list.add(item);
		
		item = new RoleMenuAuth();
		item.setRoleCode("roleHalo");
		item.setMenuCode("FW0101");
		item.setCanCreate(1);
		list.add(item);
		
		item = new RoleMenuAuth();
		item.setRoleCode("roleHalo");
		item.setMenuCode("FW0102");
		item.setCanCreate(0);
		list.add(item);
		
		String jsonString = JSONUtil.listToJsonStr(list, "");
		request.addParameter("jsonString", jsonString);
		
		ActionProxy proxy = this.getActionProxy(createUrl);
		RoleMenuAuthCreateAction action = (RoleMenuAuthCreateAction) proxy.getAction();
		String result = proxy.execute();

		Assert.assertEquals("success", result);
		String jsonValue = action.getJsonValue();
		System.out.println(jsonValue);
	}
}
