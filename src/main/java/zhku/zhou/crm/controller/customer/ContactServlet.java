package zhku.zhou.crm.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhku.zhou.crm.entity.Contact;
import zhku.zhou.crm.entity.ContactPage;
import zhku.zhou.crm.service.customer.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactServlet {
	@Autowired
	private ContactService contactService;
	@RequestMapping("/list")
	public ModelAndView getAll()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<ContactPage> list = contactService.selectAll();
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/cus/contact-list.jsp");
		return modelAndView;
	}
	@RequestMapping("/edit")
	public ModelAndView edit(int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		ContactPage contactPage = contactService.selectOneContactPage(id);
		modelAndView.addObject(contactPage);
		modelAndView.setViewName("forward:/WEB-INF/page/cus/contact-edit.jsp");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/editAfter")
	public int editAfter(Contact contact)
	{
		return contactService.updateOne(contact);
	}
	@RequestMapping("/add")
	public ModelAndView add()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/WEB-INF/page/cus/contact-add.jsp");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/addAfter")
	public int addAfter(Contact contact)
	{	
		int id = contactService.addOne(contact);
		return id;
	}
	@ResponseBody
	@RequestMapping("/deleteOne")
	public int deleteOne(int id)
	{
		return contactService.deleteOne(id);
	}
}
