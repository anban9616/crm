package zhku.zhou.crm.controller.customer;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhku.zhou.crm.entity.Chat;
import zhku.zhou.crm.entity.Contact;
import zhku.zhou.crm.entity.Customer;
import zhku.zhou.crm.entity.CustomerPage;
import zhku.zhou.crm.entity.User;
import zhku.zhou.crm.service.customer.ChatService;
import zhku.zhou.crm.service.customer.ContactService;
import zhku.zhou.crm.service.customer.CustomerService;
import zhku.zhou.crm.utils.DateUtil;
@Controller
@RequestMapping("/customer")
public class CustomerServlet {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ContactService contactService;
	@Autowired
	private ChatService chatService;
	@RequestMapping("/list")
	public ModelAndView getAll(HttpServletRequest request)
	{
		User user2 = (User) request.getSession().getAttribute("user2");
		ModelAndView modelAndView = new ModelAndView();
		List<CustomerPage> list = customerService.selectAllByOwnerId(user2.getId());
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/cus/customer-list.jsp");
		return modelAndView;
	}
	@RequestMapping("/select")
	public ModelAndView getAllForSelect()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<CustomerPage> list = customerService.selectAll();
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/cus/contact-selectCustomer.jsp");
		return modelAndView;
	}
	@RequestMapping("/pool")
	public ModelAndView getAllFromPool()
	{
		ModelAndView modelAndView = new ModelAndView();
		List<CustomerPage> list = customerService.selectAllFromPool();
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/cus/customer-pool.jsp");
		return modelAndView;
	}
	@RequestMapping("/edit")
	public ModelAndView edit(int id)
	{
		ModelAndView modelAndView = new ModelAndView();
		Customer customer = customerService.selectOne(id);
		modelAndView.addObject("customer", customer);
		Contact contact = contactService.selectOne(customer.getContactId());
		if(contact!=null)
		{
			modelAndView.addObject("contact", contact);
		}
		List<Chat> chatList =null;
		Chat chat = null;
		try {
			if(contact!=null) {
				chatList = chatService.selectByContactID(contact.getId());
				if(chatList.size()>0) {
					chat = chatList.get(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(chat!=null)
		{
			modelAndView.addObject("chat", chat);
		}
		modelAndView.setViewName("forward:/WEB-INF/page/cus/customer-edit.jsp");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/editAfter")
	public int editAfter2(Customer customer,Contact contact,Chat chat,String address1,String remark1,String nxtmStr,Integer customerId1,Integer contactId1,Integer chatId1) throws ParseException
	{
		System.out.println("------------------------>");
		System.out.println("customerId1:"+customerId1);
		System.out.println("chatId1:"+chatId1);
		System.out.println("contactId1:"+contactId1);
		customer.setMdtm(new Date());
		contact.setAddress(address1);
		contact.setRemark(remark1);
		Date nxtm = DateUtil.Str2DateTime(nxtmStr);
		chat.setNxtm(nxtm);
		customer.setId(customerId1);
		
		//chatId可能为空
		if(chatId1==null||contactId1==null) {
			//插入contact，返回contactId
			contact.setCustomerId(customerId1);
			int contactId2 = contactService.addOne(contact);
			//插入chat,设置contactId
			chat.setContactId(contactId2);
			int chatId2 = chatService.addOne(chat);
			//更新customer,设置contactId
			int flag = customerService.updateOne(customer);
			if((contactId2>0)&&(chatId2>0)&&(flag>0))
			{
				return 1;
			}
		} else {
			contact.setId(contactId1);
			chat.setId(chatId1);
			int f1 = customerService.updateOne(customer);
			int f2 = contactService.updateOne(contact);
			int f3 = chatService.updateOne(chat);
			if((f1>0) && (f2>0) && (f3>0))
				return 1;
		}
		return 0;
	}
	@RequestMapping("/add")
	public ModelAndView add()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/WEB-INF/page/cus/customer-add.jsp");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/addAfter")
	public int addAfter(Customer customer,Contact contact,Chat chat,String address1,String remark1,String nxtmStr,HttpServletRequest request) throws ParseException
	{
		User user2 = (User) request.getSession().getAttribute("user2");
		customer.setUserId(user2.getId());
		customer.setOwnerId(user2.getId());
		customer.setStatus(0);
		customer.setCrtm(new Date());
		customer.setMdtm(new Date());
		customer.setIsDeleted(0);
		//customer.setContactId(contactId);
		
		//contact.setCustomerId(customerId);
		contact.setAddress(address1);
		contact.setRemark(remark1);
		
		chat.setCrtm(new Date());
		chat.setType(0);
		Date nxtm = DateUtil.Str2DateTime(nxtmStr);
		chat.setNxtm(nxtm);
		//chat.setContactId(contactId);
		
		int customerId = customerService.addOne(customer);
		contact.setCustomerId(customerId);
		int contactId = contactService.addOne(contact);
		customer.setContactId(contactId);
		customerService.updateOne(customer);
		chat.setContactId(contactId);
		int chatId = chatService.addOne(chat);
		int flag = 0;
		if((customerId>0) && (contactId>0) && (chatId>0))
			flag = 1;
		return flag;
	}
	@ResponseBody
	@RequestMapping("/deleteOne")
	public int deleteOne(int id)
	{
		Customer customer = new Customer();
		customer.setId(id);
		customer.setIsDeleted(1);
		return customerService.updateOne(customer);
	}
	@ResponseBody
	@RequestMapping("/receiveOne")
	public int receiveOne(int id,HttpServletRequest request)
	{
		User user2 = (User) request.getSession().getAttribute("user2");
		Customer customer = new Customer();
		customer.setId(id);
		customer.setStatus(0);
		customer.setOwnerId(user2.getId());
		return customerService.updateOne(customer);
	}
	@ResponseBody
	@RequestMapping("/releaseOne")
	public int releaseOne(int id)
	{
		Customer customer = new Customer();
		customer.setId(id);
		customer.setStatus(1);
		customer.setOwnerId(0);
		return customerService.updateOne(customer);
	}
}
