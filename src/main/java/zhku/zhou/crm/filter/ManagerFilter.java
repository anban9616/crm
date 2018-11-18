package zhku.zhou.crm.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import zhku.zhou.crm.entity.Role;
import zhku.zhou.crm.entity.User;

@Component
@WebFilter("/*")
public class ManagerFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		StringBuffer url = httpServletRequest.getRequestURL();
		System.out.println("------------------->>>>>>>>>>>>>>>>>>>>>>>" + url);
		String[] strs = url.toString().split("/");
		for (int i = 0; i < strs.length; i++) {
			System.out.println(i + " " + strs[i]);
		}
		if (strs.length < 6) {
			chain.doFilter(request, response);
			return ;
		}
		String str4 = "";
		String str5 = "";
		if (strs.length >= 5) {
			str4 = strs[4];
		}
		if (strs.length >= 6) {
			str5 = strs[5];
		}
		if(str4.equals("lib")||str4.equals("static"))
		{
			chain.doFilter(request, response);
			return;
		}
		// 获取用户
		User user2 = (User) httpServletRequest.getSession().getAttribute("user2");
		if(user2==null)
		{
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin-login.jsp");
			return ;
		}
		System.out.println("user2"+user2);
		// 获取对应的角色
		Role role = (Role) httpServletRequest.getSession().getAttribute("role2");
		if(role==null)
		{
			httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/admin-login.jsp");
			return ;
		}
		System.out.println("role2"+role);
		int sysPower = role.getSysPower();
		int cusPower = role.getCusPower();
		// 判断路径
		int power = 0;
		switch (str4) {
		case "clue":
			power = (cusPower / 100) % 10;
			break;
		case "customer":
			power = (cusPower / 10) % 10;
			break;
		case "contact":
			power = cusPower % 10;
			break;
		case "role":
			power = (sysPower / 100) % 10;
			break;
		case "user":
			power = (sysPower / 10) % 10;
			break;
		case "dept":
			power = sysPower % 10;
			break;
		default:
			break;
		}
		System.out.println("--------->power:"+power);
		boolean flag = false;// 是否有权力去目标路径
		boolean flag2 = true;// 是否存在该路径
		switch (str5) {
		case "list":
			if (power >= 1)
				flag = true;
			break;
		case "pool":
			if (power >= 1)
				flag = true;
			break;
		case "add":
			if (power >= 2)
				flag = true;
			break;
		case "addAfter":
			if (power >= 2)
				flag = true;
			break;
		case "edit":
			if (power >= 3)
				flag = true;
			break;
		case "editAfter":
			if (power >= 3)
				flag = true;
			break;
		case "releaseOne":
			if (power >= 3)
				flag = true;
			break;
		case "receiveOne":
			if (power >= 3)
				flag = true;
			break;
		case "transformOne":
			if (power >= 3)
				flag = true;
			break;
		case "deleteOne":
			if (power >= 4)
				flag = true;
			break;
		default:
			flag2 = false;
			break;
		}
		// 获取路径对应的权限数值
		// 根据数值判断是否有权限去玩对应的路径
		// add2,addAfter2,edit3,editAfter3,delete4,list1
		if (flag2) {
			if (flag) {
				chain.doFilter(request, response);
				return ;
			} else {
				// forbidden
				System.out.println("------------------------------------------------------------->>>");
				System.out.println("------------->power2:"+power);
				//httpServletRequest.getRequestDispatcher("/forbidden.html").forward(httpServletRequest, httpServletResponse);
				httpServletResponse.sendRedirect("/crm/forbidden.html");
			}
		} else {
			// 404
			httpServletRequest.getRequestDispatcher("/404.html").forward(httpServletRequest, httpServletResponse);
		}
	}

	@Override
	public void destroy() {
	}

}
