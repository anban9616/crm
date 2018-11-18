package zhku.zhou.crm.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhku.zhou.crm.dao.DeptMapper;
import zhku.zhou.crm.dao.RoleMapper;
import zhku.zhou.crm.dao.UserMapper;
import zhku.zhou.crm.dao.UserPageMapper;
import zhku.zhou.crm.entity.Dept;
import zhku.zhou.crm.entity.DeptExample;
import zhku.zhou.crm.entity.Role;
import zhku.zhou.crm.entity.RoleExample;
import zhku.zhou.crm.entity.User;
import zhku.zhou.crm.entity.UserPage;
import zhku.zhou.crm.entity.UserPageExample;



@Service
public class UserService {
	@Autowired
	private UserPageMapper userPageMapper;
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserMapper userMapper;
	public List<UserPage> getAll()
	{
		UserPageExample example = new UserPageExample();
		List<UserPage> list = userPageMapper.selectByExample(example);
		return list;
	}
	public List<Dept> getDeptList() {
		DeptExample DeptExample = new DeptExample();
		List<Dept> list = deptMapper.selectByExample(DeptExample);
		return list;
	}
	public List<Role> getRoleList() {
		RoleExample roleExample = new RoleExample();
		List<Role> list = roleMapper.selectByExample(roleExample);
		return list;
	}
	public int addOne(User user) {
		return userMapper.insertSelective(user);
	}
	public User SelectOne(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}
	public int updateOne(User user)
	{
		user.setLoginIp(null);
		user.setLoginTime(null);
		user.setCrtm(null);
		return userMapper.updateByPrimaryKeySelective(user);
	}
	public int deleteOne(Integer id) {
		return userMapper.deleteByPrimaryKey(id);
	}
}
