package se.zust.orm.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.zust.orm.dao.RelationMapper;
import se.zust.orm.dao.UserMapper;
import se.zust.orm.entity.Relation;
import se.zust.orm.entity.RelationExample;
import se.zust.orm.service.RelationService;
import se.zust.orm.service.UserService;

import javax.xml.ws.Action;
@Service
public class RelationServiceImpl implements RelationService {
    private Logger logger = Logger.getLogger(this.getClass());


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RelationMapper relationMapper;

    @Transactional
    public int insertRelationship(int userId,int friendId) {
        Relation relation1=new Relation();
        relation1.setConcernId(userId);
        relation1.setConcernedId(friendId);
        relationMapper.insert(relation1);
        Relation relation2=new Relation();
        relation2.setConcernId(friendId);
        relation2.setConcernedId(userId);
        relationMapper.insert(relation2);
        return 0;
    }

    @Transactional
    public int delectRelationship(int userId,int friendId) {
        RelationExample relationExample=new RelationExample();
        relationExample.or().andConcernedIdEqualTo(friendId).andConcernIdEqualTo(userId);
        relationMapper.deleteByExample(relationExample);
        RelationExample relationExample2=new RelationExample();
        relationExample2.or().andConcernedIdEqualTo(userId).andConcernIdEqualTo(friendId);
        relationMapper.deleteByExample(relationExample2);

        return 0;
    }
}
