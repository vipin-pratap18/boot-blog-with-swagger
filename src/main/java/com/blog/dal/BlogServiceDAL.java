/**
 * 
 */
package com.blog.dal;

import java.util.List;

import com.blog.model.BlogMessage;

/**
 * @author VipinK
 *
 */
public interface BlogServiceDAL {

    BlogMessage updateMessage(BlogMessage message);

    BlogMessage saveMessage(BlogMessage message);

    BlogMessage deleteMessage(String messageId);

    List<BlogMessage> getAllMessages();

    BlogMessage getMessageById(String messageId);
}
