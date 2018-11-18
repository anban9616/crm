package zhku.zhou.crm.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zhku.zhou.crm.dao.ChatMapper;
import zhku.zhou.crm.entity.Chat;
import zhku.zhou.crm.entity.ChatExample;
import zhku.zhou.crm.entity.ChatExample.Criteria;
@Service
public class ChatService implements Parent<Chat> {
	@Autowired
	private ChatMapper chatMapper;

	@Override
	public int addOne(Chat record) {
		int flag = chatMapper.insertSelective(record);
		if(flag==0)
			return 0;
		return record.getId();
	}

	@Override
	public int deleteOne(int id) {
		return chatMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int updateOne(Chat record) {
		return chatMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public Chat selectOne(int id) {
		return chatMapper.selectByPrimaryKey(id);
	}

	public List<Chat> selectAll() {
		ChatExample example = new ChatExample();
		return chatMapper.selectByExample(example);
	}
	
	public List<Chat> selectByClueID(int id)
	{
		ChatExample example = new ChatExample();
		Criteria criteria = example.createCriteria();
		criteria.andClueIdEqualTo(id);
		example.setOrderByClause("id DESC");
		return chatMapper.selectByExample(example);
	}
	
	public List<Chat> selectByContactID(int id)
	{
		ChatExample example = new ChatExample();
		Criteria criteria = example.createCriteria();
		criteria.andContactIdEqualTo(id);
		example.setOrderByClause("id DESC");
		return chatMapper.selectByExample(example);
	}
	
	public int deleteByClueID(int id)
	{
		ChatExample example = new ChatExample();
		Criteria criteria = example.createCriteria();
		criteria.andClueIdEqualTo(id);
		return chatMapper.deleteByExample(example);
	}
}
