package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false,length = 100)
    private String title;
    
    @Column(nullable = false)
    @Lob
    private String content;
    
    @Column(nullable = false)
    private String author;
    
    @Column(nullable = false)
    private String category;
    
    @Column(nullable = false)
    private LocalDateTime createdDate;
    
    @Column()
    private LocalDateTime modifiedDate;
    
    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        modifiedDate = LocalDateTime.now();
    }
}
