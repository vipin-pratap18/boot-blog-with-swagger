package com.blog.manager;

import java.util.List;

import com.blog.model.BlogMessage;

/**
 * Service abstraction for possible Vessel operations.
 * @author VipinK
 */
public interface BlogServiceManager {

	BlogMessage updateMessage(BlogMessage message);

	BlogMessage saveMessage(BlogMessage message);

	BlogMessage deleteMessage(String messageId);

	List<BlogMessage> getAllMessages();

	BlogMessage getMessageById(String messageId);
}
