package org.cjf.test.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.cjf.action.AbstractWebAction;
import org.cjf.entity.User;
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
@ContextConfiguration(locations = { "classpath:resources/test/action/context-User.xml" })
public class TestUserAction extends StrutsSpringJUnit4TestCase<AbstractWebAction> {
	
	public static String createActionUrl = "/createUser.do";
	public static String removeActionUrl = "/removeUser.do";
	public static String getOneActionUrl = "/getOneUser.do";
	public static String getListActionUrl = "/getListUser.do";
	public static String modifyListActionUrl = "/modifyUser.do";
	
	public static String disableUsersActionUrl = "/disableUsers.do";
	
	@Test
	public void test006DisableUsers() throws Exception {
		String jsonString = "[201, 202]";
		
		HttpSession session = request.getSession();
		session.setAttribute(AppConst.SESSION_USER, new User());
		
		request.addParameter("jsonString", jsonString);
		
		ActionProxy proxy = this.getActionProxy(disableUsersActionUrl);
		String result = proxy.execute();

		Assert.assertEquals("success", result);
	}
	
//	private static String getDemoUserJsonString() {
//	User u = new User();
//	
//	u.setId(0);
//	u.setUserCode("yangxm");
//	u.setUserName("杨晓明");
//	u.setEmpCode(null);
//	u.setEmpName(null);
//	u.setLastModifyDate(CJFDateUtil.dateWith(2014, 1, 1, 0, 0, 0));
//	u.setCreateDate(CJFDateUtil.dateWith(2015, 10, 1, 0, 0, 0));
//	u.setPassword(MD5.encode("123456"));
//	u.setCurrentStatus(2);
//	u.setUserImage(null);
//	u.setValidDate(CJFDateUtil.dateWith(2015, 10, 1, 10, 20, 30));
//	
//	String jsonString = JSONUtil.objToJsonStr(u, "");
//	
//	return jsonString;
//}
	
//	@Test
//	public void test001Delete() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		request.addParameter("id", "211");
//		
//		ActionProxy proxy = this.getActionProxy(removeActionUrl);
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//	}
	
//	@Test
//	public void test002Create() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		request.addParameter("jsonString", getDemoUserJsonString());
//		
//		ActionProxy proxy = this.getActionProxy(createActionUrl);
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//	}
//	
//	@Test
//	public void test003Modify() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		User item = new User();
//		item.setId(212);
//		item.setUserName("管理员");
//		item.setUserImage("/images/user001.png");
//		
//		String jsonString = JSONUtil.objToJsonStr(item, "");
//		request.addParameter("jsonString", jsonString);
//		
//		ActionProxy proxy = this.getActionProxy(modifyListActionUrl);
//		UserModifyAction action = (UserModifyAction) proxy.getAction();
//		String result = proxy.execute();
//
//		System.out.println(action.getJsonValue());
//		Assert.assertEquals("success", result);
//	}
//	
//	@Test
//	public void test004GetOne() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		User item = new User();
//		item.setId(212);
//		
//		String jsonString = JSONUtil.objToJsonStr(item, "");
//		
//		request.addParameter("jsonString", jsonString);
//		
//		ActionProxy proxy = this.getActionProxy(getOneActionUrl);
//		UserGetOneAction action = (UserGetOneAction) proxy.getAction();
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//		System.out.println(action.getJsonValue());
//	}
//	
//	@Test
//	public void test005GetList() throws Exception {
//		HttpSession session = request.getSession();
//		session.setAttribute(AppConst.SESSION_USER, new User());
//		
//		User item = new User();
//		String jsonString = JSONUtil.objToJsonStr(item, "");
//		
//		request.addParameter("jsonString", jsonString);
//		
//		ActionProxy proxy = this.getActionProxy(getListActionUrl);
//		UserGetListAction action = (UserGetListAction) proxy.getAction();
//		String result = proxy.execute();
//
//		Assert.assertEquals("success", result);
//		System.out.println(action.getJsonValue());
//	}
}
