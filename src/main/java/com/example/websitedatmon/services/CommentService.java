package com.example.websitedatmon.services;

import com.example.websitedatmon.domain.Comment;
import com.example.websitedatmon.domain.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    Comment save(Comment comment);
    List<Comment> findCommentByFood(Food food);
}
