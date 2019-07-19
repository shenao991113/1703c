package com.shenao.cms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenao.cms.dao.CommentMapper;
import com.shenao.cms.domain.Comment;
import com.shenao.cms.service.CommentService;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public void save(Comment comment) {
		commentMapper.save(comment);
	}
}
