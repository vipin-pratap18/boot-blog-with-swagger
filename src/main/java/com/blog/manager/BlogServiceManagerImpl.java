package com.blog.manager;

import com.blog.dal.BlogServiceDAL;
import com.blog.model.BlogMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author VipinK
 *
 */
@Service
public class BlogServiceManagerImpl implements BlogServiceManager {

	private final Logger LOG = LoggerFactory.getLogger(BlogServiceManagerImpl.class);
	@Autowired
	private BlogServiceDAL messageDAL;

    @Override
    public BlogMessage updateMessage(BlogMessage message) {
        return messageDAL.updateMessage(message);
    }

    @Override
    public BlogMessage saveMessage(BlogMessage message) {
        return messageDAL.saveMessage(message);
    }

    @Override
    public BlogMessage deleteMessage(String messageId) {
        return messageDAL.deleteMessage(messageId);
    }

    @Override
    public List<BlogMessage> getAllMessages() {
        return messageDAL.getAllMessages();
    }

    @Override
    public BlogMessage getMessageById(String messageId) {
        return messageDAL.getMessageById(messageId);
    }
}
