package zhku.zhou.crm.service.login;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhku.zhou.crm.dao.UserMapper;
import zhku.zhou.crm.entity.User;
import zhku.zhou.crm.entity.UserExample;
import zhku.zhou.crm.entity.UserExample.Criteria;

@Service
public class LoginService {
	@Autowired
	private UserMapper userMapper;
	public List<User> login(User user)
	{
		UserExample example = new UserExample();
		Criteria  criteria = example.createCriteria();
		criteria.andNameIsNotNull();
		criteria.andPasswordIsNotNull();
		criteria.andNameEqualTo(user.getName());
		criteria.andPasswordEqualTo(user.getPassword());
		return userMapper.selectByExample(example);
	}
	public int updateLoginTime(User user)
	{
		return userMapper.updateByPrimaryKeySelective(user);
	}
}
