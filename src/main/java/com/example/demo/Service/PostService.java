package com.example.demo.Service;

import com.example.demo.Model.PostModel;
import com.example.demo.Repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }
    public List<PostModel> getAllPost()
    {
        return postRepo.findAll();
    }
    public List<PostModel> getAllPostByAuthor(String author)
    {
        return postRepo.findByAuthor(author);
    }

    public PostModel getPostById(Long id)
    {
        return postRepo.findById(id).orElse(null);
    }
    public PostModel savePost(PostModel post)
    {
        return postRepo.save(post);
    }
    public void deletePost(Long id) {
        postRepo.deleteById(id);
    }
}
