/**
 *
 */
package com.blog.dal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.blog.model.BlogMessage;

/**
 * @author VipinK
 *
 * Exception thrown in this class are very generic and with no proper response code. So please ignore that part.
 * You have to create your own exception and throw that
 */
@Repository
public class BlogServiceDALImpl implements BlogServiceDAL {

    private final Logger LOG = LoggerFactory.getLogger(BlogServiceDALImpl.class);
    
    @Autowired
    private MongoTemplate mongoTemplate;

    private Map<String, BlogMessage> messageIdToMessageMap = new HashMap<>();

    @Override
    public BlogMessage updateMessage(BlogMessage message) {
      	mongoTemplate.save(message);
        return message;
    }

    @Override
    public BlogMessage saveMessage(BlogMessage message) {
     	mongoTemplate.save(message);
        return message;
    }

    @Override
    public BlogMessage deleteMessage(String messageId) {
    	    Query query = new Query();
		query.addCriteria(Criteria.where("messageId").is(messageId));
		BlogMessage existingMessage = mongoTemplate.findOne(query, BlogMessage.class);
        mongoTemplate.remove(query, BlogMessage.class);
        return existingMessage;
    }

    @Override
    public List<BlogMessage> getAllMessages() {
        List<BlogMessage> messageList = mongoTemplate.findAll(BlogMessage.class);
        return messageList;
    }

    @Override
    public BlogMessage getMessageById(String messageId) {
     	Query query = new Query();
		query.addCriteria(Criteria.where("messageId").is(messageId));
		BlogMessage message = mongoTemplate.findOne(query, BlogMessage.class);
		return message;
    }
}
