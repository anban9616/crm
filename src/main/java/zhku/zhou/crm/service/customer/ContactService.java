package zhku.zhou.crm.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhku.zhou.crm.dao.ContactMapper;
import zhku.zhou.crm.dao.ContactPageMapper;
import zhku.zhou.crm.entity.Contact;
import zhku.zhou.crm.entity.ContactPage;
import zhku.zhou.crm.entity.ContactPageExample;
import zhku.zhou.crm.entity.ContactPageExample.Criteria;
@Service
public class ContactService implements Parent<Contact> {
	@Autowired
	private ContactMapper contactMapper;
	@Autowired
	private ContactPageMapper contactPageMapper;

	@Override
	public int addOne(Contact record) {
		int flag = contactMapper.insertSelective(record);
		if(flag==0)
			return 0;
		return record.getId();
	}

	@Override
	public int deleteOne(int id) {
		return contactMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateOne(Contact record) {
		return contactMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Contact selectOne(int id) {
		return contactMapper.selectByPrimaryKey(id);
	}
	
	public ContactPage selectOneContactPage(int id)
	{
		ContactPageExample example = new ContactPageExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		List<ContactPage> list = contactPageMapper.selectByExample(example);
		ContactPage contactPage = null;
		try {
			contactPage = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return contactPage;
	}
	public List<ContactPage> selectAll() {
		ContactPageExample example = new ContactPageExample();
		return contactPageMapper.selectByExample(example);
	}
}
