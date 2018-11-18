package zhku.zhou.crm.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhku.zhou.crm.dao.ClueMapper;
import zhku.zhou.crm.dao.CluePageMapper;
import zhku.zhou.crm.entity.Clue;
import zhku.zhou.crm.entity.CluePage;
import zhku.zhou.crm.entity.CluePageExample;
import zhku.zhou.crm.entity.CluePageExample.Criteria;
@Service
public class ClueService implements Parent<Clue>{
	@Autowired
	private ClueMapper clueMapper;
	@Autowired
	private CluePageMapper cluePageMapper;
	@Override
	public int addOne(Clue obj) {
		int flag = clueMapper.insertSelective(obj);
		if(flag==0)
			return 0;
		return obj.getId();
	}

	@Override
	public int deleteOne(int id) {
		return clueMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateOne(Clue obj) {
		return clueMapper.updateByPrimaryKeySelective(obj);
	}

	@Override
	public Clue selectOne(int id) {
		return clueMapper.selectByPrimaryKey(id);
	}

	public List<CluePage> selectAll() {
		CluePageExample example = new CluePageExample();
		return cluePageMapper.selectByExample(example);
	}
	public List<CluePage> selectAllFromPool() {
		CluePageExample example = new CluePageExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(1);
		criteria.andIsDeletedEqualTo(0);
		criteria.andIsTransformedEqualTo(0);
		return cluePageMapper.selectByExample(example);
	}
	public List<CluePage> selectAllByUserID(int id) {
		CluePageExample example = new CluePageExample();
		Criteria criteria = example.createCriteria();
		criteria.andOwnerIdEqualTo(id);
		criteria.andStatusEqualTo(0);
		criteria.andIsDeletedEqualTo(0);
		criteria.andIsTransformedEqualTo(0);
		return cluePageMapper.selectByExample(example);
	}
	
	
}
