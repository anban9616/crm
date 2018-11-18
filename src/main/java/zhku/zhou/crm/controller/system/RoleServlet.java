package zhku.zhou.crm.controller.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhku.zhou.crm.entity.Role;
import zhku.zhou.crm.service.system.RoleService;


@Controller
@RequestMapping("/role")
public class RoleServlet {
	@Autowired
	private RoleService roleService;

	@RequestMapping("/list")
	public ModelAndView getAll() {
		ModelAndView modelAndView = new ModelAndView();
		List<Role> list = roleService.getAll();
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/system/system-role.jsp");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Role role = roleService.selectOne(id);
		modelAndView.addObject("role", role);
		modelAndView.setViewName("forward:/WEB-INF/page/system/system-role-edit.jsp");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/editAfter")
	public int editAfter(Role role) {
		role.setMdtm(new Date());
		return roleService.updateOne(role);
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/WEB-INF/page/system/system-role-add.jsp");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/addAfter")
	public int addAfter(Role role) {
		role.setCrtm(new Date());
		role.setMdtm(new Date());
		return roleService.addOne(role);
	}

	@ResponseBody
	@RequestMapping("/deleteOne")
	public int deleteOne(int id) {
		// 查找是否有用户使用该角色
		int count = roleService.countForRole(id);
		// 没有就可以删除,有则不能删除
		if (count == 0) {
			return roleService.deleteOne(id);
		} else {
			return 0;
		}
	}
}
