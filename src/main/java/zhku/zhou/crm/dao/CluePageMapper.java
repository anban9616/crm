package zhku.zhou.crm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zhku.zhou.crm.entity.CluePage;
import zhku.zhou.crm.entity.CluePageExample;

public interface CluePageMapper {
    int countByExample(CluePageExample example);

    int deleteByExample(CluePageExample example);

    int insert(CluePage record);

    int insertSelective(CluePage record);

    List<CluePage> selectByExample(CluePageExample example);

    int updateByExampleSelective(@Param("record") CluePage record, @Param("example") CluePageExample example);

    int updateByExample(@Param("record") CluePage record, @Param("example") CluePageExample example);
}