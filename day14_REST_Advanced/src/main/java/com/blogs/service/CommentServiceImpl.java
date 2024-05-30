package com.blogs.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.custom_exceptions.ApiException;
import com.blogs.custom_exceptions.ResourceNotFoundException;
import com.blogs.dto.ApiResponse;
import com.blogs.dto.CommentDTO;
import com.blogs.entities.BlogPost;
import com.blogs.entities.Comment;
import com.blogs.entities.User;
import com.blogs.repository.BlogPostRepository;
import com.blogs.repository.CommentRepository;
import com.blogs.repository.UserRepository;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
//depcy
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	@Autowired 
	private ModelMapper mapper;
	@Override
	public ApiResponse createNewComment(CommentDTO commentDTO) {
		User user=userRepository.findById(commentDTO.getUserId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid category id !!!!"));
		BlogPost blogPost=blogPostRepository.findById(commentDTO.getBlogPostId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid category id !!!!"));
		if(user.getId()==blogPost.getAuthor().getId())
			throw new ApiException("Bloggers cant comment on their own post");
		Comment comment=mapper.map(commentDTO, Comment.class);
		comment.setCommenter(user);
		
		comment.setPost(blogPost);
		Comment savedComment =commentRepository.save(comment);
		
		return new ApiResponse("New Comment added Successfilly");
	}

}
