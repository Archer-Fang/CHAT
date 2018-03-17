package se.zust.orm.service;

public interface RelationService {
    int insertRelationship(int userId,int friendId);
    int delectRelationship(int userId,int friendId);
}
