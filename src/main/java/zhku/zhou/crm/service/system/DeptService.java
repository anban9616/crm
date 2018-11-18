package zhku.zhou.crm.service.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhku.zhou.crm.dao.DeptMapper;
import zhku.zhou.crm.entity.Dept;
import zhku.zhou.crm.entity.DeptExample;

@Service
public class DeptService {
	@Autowired
	private DeptMapper deptMapper;
	
	public List<Dept> getAll() {
		DeptExample example = new DeptExample();
		return deptMapper.selectByExample(example);
	}

	public Dept selectOne(Integer id) {
		return deptMapper.selectByPrimaryKey(id);
	}

	public int updateOne(Dept dept) {
		return deptMapper.updateByPrimaryKeySelective(dept);
	}

	public int addOne(Dept dept) {
		return deptMapper.insertSelective(dept);
	}

	public int deleteOne(int id) {
		return deptMapper.deleteByPrimaryKey(id);
	}

}
