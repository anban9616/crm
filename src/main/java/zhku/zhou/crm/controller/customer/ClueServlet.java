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
import zhku.zhou.crm.entity.Clue;
import zhku.zhou.crm.entity.CluePage;
import zhku.zhou.crm.entity.Contact;
import zhku.zhou.crm.entity.Customer;
import zhku.zhou.crm.entity.User;
import zhku.zhou.crm.service.customer.ChatService;
import zhku.zhou.crm.service.customer.ClueService;
import zhku.zhou.crm.service.customer.ContactService;
import zhku.zhou.crm.service.customer.CustomerService;
import zhku.zhou.crm.utils.DateUtil;
@Controller
@RequestMapping("/clue")
public class ClueServlet {
	@Autowired
	private ClueService clueService;
	@Autowired
	private ChatService chatService;
	@Autowired 
	private CustomerService customerService;
	@Autowired
	private ContactService contactService;
	@RequestMapping("/list")
	public ModelAndView getAll(HttpServletRequest request)
	{
		User user2 = (User) request.getSession().getAttribute("user2");
		List<CluePage> list = clueService.selectAllByUserID(user2.getId());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/cus/clue-list.jsp");
		return modelAndView;
	}
	@RequestMapping("/pool")
	public ModelAndView getAllFromPool()
	{
		List<CluePage> list = clueService.selectAllFromPool();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("list", list);
		modelAndView.addObject("count", list.size());
		modelAndView.setViewName("forward:/WEB-INF/page/cus/clue-pool.jsp");
		return modelAndView;
	}
	@RequestMapping("/edit")
	public ModelAndView edit(int id)
	{
		Clue clue = clueService.selectOne(id);
		List<Chat> chatList = chatService.selectByClueID(clue.getId());
		Chat chat = null;
		if(chatList!=null)
		{
			chat = chatList.get(0);
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("clue", clue);
		modelAndView.addObject("chat", chat);
		modelAndView.setViewName("forward:/WEB-INF/page/cus/clue-edit.jsp");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/editAfter")
	public int editAfter(Clue clue,Chat chat,String nxtmStr,int clueId,int chatId) throws ParseException
	{
		Date nxtm = DateUtil.Str2DateTime(nxtmStr);
		chat.setNxtm(nxtm);
		clue.setId(clueId);
		chat.setId(chatId);
		int f1 = clueService.updateOne(clue);
		int f2 = chatService.updateOne(chat);
		return ((f1>0)&&(f2>0))?1:0;
	}
	@RequestMapping("/add")
	public ModelAndView add()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:/WEB-INF/page/cus/clue-add.jsp");
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/addAfter")
	public int addAfter(Clue clue,String nxtmStr,Chat chat,HttpServletRequest request) throws ParseException
	{
		User user2 = (User) request.getSession().getAttribute("user2");
		clue.setUserId(user2.getId());
		clue.setOwnerId(user2.getId());
		Date nxtm = DateUtil.Str2DateTime(nxtmStr);
		chat.setNxtm(nxtm);
		clue.setStatus(0);
		clue.setIsDeleted(0);
		clue.setIsTransformed(0);
		clue.setCrtm(new Date());
		clue.setMdtm(new Date());
		int clueId = clueService.addOne(clue);
		chat.setClueId(clueId);
		chat.setCrtm(new Date());
		chat.setType(0);
		int chatId = chatService.addOne(chat);
		return ((clueId>0)&&(chatId>0))?1:0;
	}
	@ResponseBody
	@RequestMapping("/deleteOne")
	public int deleteOne(int id,HttpServletRequest request)
	{
		User user2 = (User) request.getSession().getAttribute("user2");
		Clue clue = new Clue();
		clue.setId(id);
		clue.setIsDeleted(1);
		clue.setDeleteTime(new Date());
		clue.setDeleteUserId(user2.getId());
		return clueService.updateOne(clue);
	}
	@ResponseBody
	@RequestMapping("/receiveOne")
	public int receiveOne(int id,HttpServletRequest request)
	{
		User user2 = (User) request.getSession().getAttribute("user2");
		Clue clue = new Clue();
		clue.setOwnerId(user2.getId());
		clue.setId(id);
		clue.setStatus(0);
		return clueService.updateOne(clue);
	}
	@ResponseBody
	@RequestMapping("/releaseOne")
	public int releaseOne(int id)
	{
		Clue clue = new Clue();
		clue.setOwnerId(0);
		clue.setId(id);
		clue.setStatus(1);
		return clueService.updateOne(clue);
	}
	@ResponseBody
	@RequestMapping("/transformOne")
	public int transformOne(int id,HttpServletRequest request)
	{
		//1.获取线索
		Clue clue = clueService.selectOne(id);
		//2.新建客户（公司），联系人，聊天
		Customer customer = new Customer();
		Contact contact = new Contact();
		//3.填写信息
		customer.setAddress(clue.getAddress());
		customer.setCompanyName(clue.getCompanyName());
		//customer.setContactId();//指定联系人
		customer.setCusStatus(0);
		customer.setEmployees(0);
		//customer.setNumber(number);//客户编号
		customer.setRank(1);
		customer.setRemark(clue.getRemark());
		customer.setSource(clue.getSource());
		customer.setStatus(0);
		customer.setTrade(null);
		customer.setNumber(null);
		customer.setCrtm(clue.getCrtm());
		customer.setMdtm(clue.getMdtm());
		customer.setUserId(clue.getUserId());
		customer.setOwnerId(clue.getOwnerId());
		
		contact.setAddress(clue.getAddress());
		contact.setContactName(clue.getContactName());
		//contact.setCustomerId();
		contact.setEmail(clue.getEmail());
		contact.setPhone(clue.getPhone());
		contact.setPosition(clue.getPosition());
		contact.setRemark(null);
		contact.setRole(null);
		contact.setSex(clue.getSex());
		
		
		//4.插入客户，联系人，并获取客户和公司id
		int customerId = customerService.addOne(customer);
		contact.setCustomerId(customerId);
		int contactId = contactService.addOne(contact);
		customer.setContactId(contactId);
		customerService.updateOne(customer);
		
		List<Chat> chatList = chatService.selectByClueID(id);
		for(Chat chat:chatList)
		{
			chat.setContactId(contactId);
			chatService.updateOne(chat);
		}
		//5.修改并填写线索信息
		clue.setIsTransformed(1);
		User user2 = (User) request.getSession().getAttribute("user2");
		clue.setTransformUserId(user2.getId());
		clue.setContactId(contactId);
		clue.setCustomerId(customerId);
		//6.更新线索
		return clueService.updateOne(clue);
		//没有事务，后期要改
	}
}
