package zhku.zhou.crm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhku.zhou.crm.entity.CustomerPage;
import zhku.zhou.crm.entity.CustomerPageExample;

public interface CustomerPageMapper {
    int countByExample(CustomerPageExample example);

    int deleteByExample(CustomerPageExample example);

    int insert(CustomerPage record);

    int insertSelective(CustomerPage record);

    List<CustomerPage> selectByExample(CustomerPageExample example);

    int updateByExampleSelective(@Param("record") CustomerPage record, @Param("example") CustomerPageExample example);

    int updateByExample(@Param("record") CustomerPage record, @Param("example") CustomerPageExample example);
}