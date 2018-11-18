package zhku.zhou.crm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhku.zhou.crm.entity.UserPage;
import zhku.zhou.crm.entity.UserPageExample;

public interface UserPageMapper {
    int countByExample(UserPageExample example);

    int deleteByExample(UserPageExample example);

    int insert(UserPage record);

    int insertSelective(UserPage record);

    List<UserPage> selectByExample(UserPageExample example);

    int updateByExampleSelective(@Param("record") UserPage record, @Param("example") UserPageExample example);

    int updateByExample(@Param("record") UserPage record, @Param("example") UserPageExample example);
}