package com.blog.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.manager.BlogServiceManager;
import com.blog.model.BlogMessage;

/**
 * This class is responsible for handling all the vessel information requests
 * based on vessel selection criteria.
 *
 * @author VipinK
 */

@RestController
@RequestMapping("/blog-service/blogs")
public class BlogServiceController {

	private final Logger LOG = LoggerFactory.getLogger(BlogServiceController.class);

	@Autowired
	private BlogServiceManager messageManager;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public BlogMessage saveMessage(@RequestBody BlogMessage message){
		return messageManager.saveMessage(message);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public BlogMessage updateMessage(@RequestBody BlogMessage message){
		return messageManager.updateMessage(message);
	}

    @RequestMapping(value = "/{blogId}", method = RequestMethod.DELETE)
    public BlogMessage deleteMessage(@PathVariable String messageId){
        return messageManager.deleteMessage(messageId);
    }
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<BlogMessage> getAllMessages(){
		return messageManager.getAllMessages();
	}

	@RequestMapping(value = "/{blogId}", method = RequestMethod.GET)
	public BlogMessage getMessageById(@PathVariable String messageId){
		return messageManager.getMessageById(messageId);
	}

}
