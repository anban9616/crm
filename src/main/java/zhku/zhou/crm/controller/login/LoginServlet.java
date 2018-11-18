package zhku.zhou.crm.controller.login;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zhku.zhou.crm.entity.Role;
import zhku.zhou.crm.entity.User;
import zhku.zhou.crm.service.login.LoginService;
import zhku.zhou.crm.service.system.RoleService;
import zhku.zhou.crm.utils.IpUtil;


@Controller
@RequestMapping("/")
public class LoginServlet {
	@Autowired
	private LoginService loginService;
	@Autowired
	private RoleService roleService;
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,User user) {
		ModelAndView mav = new ModelAndView();
		List<User> userList;
		HttpSession session = request.getSession();
		User tempUser = (User) session.getAttribute("user2");
		if (tempUser!=null) {
			mav.setViewName("forward:/WEB-INF/page/index.jsp");
			return mav;
		}
		try {
			userList = loginService.login(user);
			//userList.get(0)在获取不到的时候抛出异常
			User user2 = userList.get(0);
			if(user2.getStatus()==1)
			{
				session.setAttribute("loginMessage", "账号已停用");
				mav.setViewName("redirect:/admin-login.jsp");
				return mav;
			}
			Role role2 = roleService.selectOne(user2.getRoleId());
			session.setAttribute("role2", role2);
			user2.setLoginTime(new Date());
			String ip=IpUtil.getIpAddress(request);
			user2.setLoginIp(ip);
			loginService.updateLoginTime(user2);
			session.setAttribute("user2", user2);
			mav.setViewName("forward:/WEB-INF/page/index.jsp");
			return mav;
		} catch (Exception e) {
			session.setAttribute("loginMessage", "账号或密码错误");
			mav.setViewName("redirect:/admin-login.jsp");
			return mav;
		}
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.removeAttribute("user2");
		session.removeAttribute("role2");
		session.removeAttribute("loginMessage");
		return new ModelAndView("redirect:/admin-login.jsp");
	}
}
