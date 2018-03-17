package se.zust.orm.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import se.zust.orm.entity.Relation;
import se.zust.orm.entity.RelationExample;

public interface RelationMapper {
    long countByExample(RelationExample example);

    int deleteByExample(RelationExample example);

    int insert(Relation record);

    int insertSelective(Relation record);

    List<Relation> selectByExample(RelationExample example);

    int updateByExampleSelective(@Param("record") Relation record, @Param("example") RelationExample example);

    int updateByExample(@Param("record") Relation record, @Param("example") RelationExample example);
}