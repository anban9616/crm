package zhku.zhou.crm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhku.zhou.crm.entity.ContactPage;
import zhku.zhou.crm.entity.ContactPageExample;

public interface ContactPageMapper {
    int countByExample(ContactPageExample example);

    int deleteByExample(ContactPageExample example);

    int insert(ContactPage record);

    int insertSelective(ContactPage record);

    List<ContactPage> selectByExample(ContactPageExample example);

    int updateByExampleSelective(@Param("record") ContactPage record, @Param("example") ContactPageExample example);

    int updateByExample(@Param("record") ContactPage record, @Param("example") ContactPageExample example);
}