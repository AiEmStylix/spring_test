package com.example.demo.Repo;

import com.example.demo.Model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<PostModel, Long> {
    List<PostModel> findByAuthor(String author);
}
