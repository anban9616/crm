package zhku.zhou.crm.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhku.zhou.crm.dao.CustomerMapper;
import zhku.zhou.crm.dao.CustomerPageMapper;
import zhku.zhou.crm.entity.Customer;
import zhku.zhou.crm.entity.CustomerPage;
import zhku.zhou.crm.entity.CustomerPageExample;
import zhku.zhou.crm.entity.CustomerPageExample.Criteria;
@Service
public class CustomerService implements Parent<Customer>{
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private CustomerPageMapper customerPageMapper;
	@Override
	public int addOne(Customer record) {
		int flag = customerMapper.insertSelective(record);
		if(flag==0)
			return 0;
		return record.getId();
	}

	@Override
	public int deleteOne(int id) {
		return customerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateOne(Customer record) {
		return customerMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Customer selectOne(int id) {
		return customerMapper.selectByPrimaryKey(id);
	}
	public List<CustomerPage> selectAll()
	{
		CustomerPageExample example = new CustomerPageExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDeletedEqualTo(0);
		return customerPageMapper.selectByExample(example);
	}
	public List<CustomerPage> selectAllByOwnerId(int id)
	{
		CustomerPageExample example = new CustomerPageExample();
		Criteria criteria = example.createCriteria();
		criteria.andOwnerIdEqualTo(id);
		criteria.andStatusEqualTo(0);
		criteria.andIsDeletedEqualTo(0);
		return customerPageMapper.selectByExample(example);
	}
	public List<CustomerPage> selectAllFromPool()
	{
		CustomerPageExample example = new CustomerPageExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		criteria.andIsDeletedEqualTo(0);
		return customerPageMapper.selectByExample(example);
	}
}
