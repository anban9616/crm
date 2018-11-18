package zhku.zhou.crm.controller.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhku.zhou.crm.entity.Dept;
import zhku.zhou.crm.service.system.DeptService;

@Controller
@RequestMapping("/dept")
public class DeptServlet {
	@Autowired
	private DeptService deptService;

	@RequestMapping("/list")
	public ModelAndView getAll() {
		ModelAndView modelAndView = new ModelAndView();
		List<Dept> list = deptService.getAll();
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/system/system-dept.jsp");
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		Dept dept = deptService.selectOne(id);
		modelAndView.addObject("dept", dept);
		modelAndView.setViewName("forward:/WEB-INF/page/system/system-dept-edit.jsp");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/editAfter")
	public int editAfter(Dept dept) {
		dept.setMdtm(new Date());
		return deptService.updateOne(dept);
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/WEB-INF/page/system/system-dept-add.jsp");
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/addAfter")
	public int addAfter(Dept dept) {
		dept.setCrtm(new Date());
		dept.setMdtm(new Date());
		return deptService.addOne(dept);
	}

	@ResponseBody
	@RequestMapping("/deleteOne")
	public int deleteOne(int id) {
		return deptService.deleteOne(id);
	}
}
