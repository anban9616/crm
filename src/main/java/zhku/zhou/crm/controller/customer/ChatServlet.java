package zhku.zhou.crm.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhku.zhou.crm.entity.Chat;
import zhku.zhou.crm.service.customer.ChatService;
@Controller
@RequestMapping("/chat")
public class ChatServlet {
	@Autowired
	private ChatService chatService;
	@RequestMapping("/list")
	public ModelAndView getAll()
	{
		List<Chat> list = chatService.selectAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/.jsp");
		return modelAndView;
	}
	@RequestMapping("/edit")
	public ModelAndView edit()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/WEB-INF/page/.jsp");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/editAfter")
	public int editAfter()
	{
		return 0;
	}
	@RequestMapping("/add")
	public ModelAndView add()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/WEB-INF/page/.jsp");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/addAfter")
	public int addAfter()
	{
		return 0;
	}
	@ResponseBody
	@RequestMapping("/deleteOne")
	public int deleteOne()
	{
		return 0;
	}
}
