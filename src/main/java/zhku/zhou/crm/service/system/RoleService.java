package zhku.zhou.crm.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhku.zhou.crm.dao.RoleMapper;
import zhku.zhou.crm.dao.UserMapper;
import zhku.zhou.crm.entity.Role;
import zhku.zhou.crm.entity.RoleExample;
import zhku.zhou.crm.entity.User;
import zhku.zhou.crm.entity.UserExample;
import zhku.zhou.crm.entity.UserExample.Criteria;

@Service
public class RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserMapper userMapper;

	public int updateOne(Role role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	public int addOne(Role role) {
		return roleMapper.insertSelective(role);
	}

	public int deleteOne(int id) {
		return roleMapper.deleteByPrimaryKey(id);
	}

	public Role selectOne(int id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	public List<Role> getAll() {
		RoleExample example = new RoleExample();
		return roleMapper.selectByExample(example);
	}

	// 查找是否有用户使用该角色
	public int countForRole(int id) {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(id);
		List<User> list = userMapper.selectByExample(example);
		return list.size();
	}

}
