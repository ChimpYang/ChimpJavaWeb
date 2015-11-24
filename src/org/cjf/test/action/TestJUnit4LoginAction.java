package org.cjf.test.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.StrutsSpringJUnit4TestCase;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.cjf.action.user.UserLoginAction;
import org.cjf.entity.User;
import org.cjf.utils.properties.AppConst;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.opensymphony.xwork2.ActionProxy;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:resources/test/action/context-User.xml" })
public class TestJUnit4LoginAction extends StrutsSpringJUnit4TestCase<UserLoginAction> {

	public static String actionUrl = "/login.do";
	
	/**
	 * 1. 暂时还不知道怎么修改struts配置文件的路径，目前必须放在根目录，且名称必须为struts.xml
	 * 2. 如果修改了@ContextConfiguration里面的路径，需要同步修改web.xml里面的路径，保持一致即可
	 */
	
	@Test
	public void testGetActionMapping() throws Exception {
		ActionMapping mapping = getActionMapping(actionUrl);
		Assert.assertNotNull(mapping);
		Assert.assertEquals("/", mapping.getNamespace());
		Assert.assertEquals("login", mapping.getName());
	}

	@Test
	public void testSuccess() throws Exception {
		request.addParameter("userCode", "admin");
		request.addParameter("password", "123456");

		ActionProxy proxy = this.getActionProxy(actionUrl);

		UserLoginAction action = (UserLoginAction) proxy.getAction();
		String result = proxy.execute();

		Assert.assertEquals("success", result);
		Assert.assertTrue(action.getFieldErrors().size() == 0);
		
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute(AppConst.SESSION_USER);
		Assert.assertEquals("管理员", u.getUserName());
	}

	@Test
	public void testFailed() throws Exception {
		request.addParameter("userCode", "aaa");
		request.addParameter("password", "00008888");

		ActionProxy proxy = this.getActionProxy(actionUrl);

		UserLoginAction action = (UserLoginAction) proxy.getAction();
		String result = proxy.execute();

		Assert.assertEquals("input", result);
		Assert.assertTrue(action.getFieldErrors().size() == 1);
		Assert.assertTrue(action.getFieldErrors().containsKey("password"));
	}
}
