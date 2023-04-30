package com.project1.jobportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.jobportal.model.Post;
import com.project1.jobportal.repository.PostRepository;
import com.project1.jobportal.repository.SearchRepository;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Postcontroller {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	SearchRepository searchRepository; 
	
	@ApiIgnore
    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
	
	@GetMapping(value="/posts")
	@CrossOrigin
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	@GetMapping(value="/posts/{text}")
	@CrossOrigin
	public List<Post> getSearchedPosts(@PathVariable String text){
		return searchRepository.findByText(text);
	}
	
	@PostMapping("/post")
	@CrossOrigin
    public Post addPost(@RequestBody Post post)
    {
        return postRepository.save(post);
    }

}
