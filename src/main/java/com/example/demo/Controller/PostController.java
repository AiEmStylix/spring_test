package com.example.demo.Controller;

import com.example.demo.Model.PostModel;
import com.example.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/index/posts")
public class PostController {

    @Autowired
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostModel> getAllPost()
    {
        return postService.getAllPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostModel> getPostById(@PathVariable Long id)
    {
        return postService.getPostById(id) != null
                ? ResponseEntity.ok(postService.getPostById(id))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public PostModel savePost(@RequestBody PostModel post)
    {
        return postService.savePost(post);
    }
}
