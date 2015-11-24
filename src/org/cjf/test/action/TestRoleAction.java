package org.cjf.test.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.cjf.action.AbstractWebAction;
import org.cjf.action.role.ExRoleAndUsersSaveAsAction;
import org.cjf.entity.Role;
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
public class TestRoleAction extends StrutsSpringJUnit4TestCase<AbstractWebAction> {
	public static String saveAsUrl = "/roleSaveAs.do";
	
	@Test
	public void test005CreateError() throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute(AppConst.SESSION_USER, new User());
		
		Role newRole = new Role();
		newRole.setRoleCode("roleHaloNew");
		newRole.setRoleName("roleHaloNew");
		newRole.setMaxUserNumber(10);
		newRole.setRoleDesc("");
		newRole.setCurrentStatus(1);
		
		String jsonString = JSONUtil.objToJsonStr(newRole, "");
		request.addParameter("jsonString", jsonString);
		request.addParameter("oldRoleCode", "roleHalo");
		
		System.out.println(jsonString);
		
		ActionProxy proxy = this.getActionProxy(saveAsUrl);
		ExRoleAndUsersSaveAsAction action = (ExRoleAndUsersSaveAsAction) proxy.getAction();
		String result = proxy.execute();

		Assert.assertEquals("success", result);
		String jsonValue = action.getJsonValue();
		System.out.println(jsonValue);
	}
}
