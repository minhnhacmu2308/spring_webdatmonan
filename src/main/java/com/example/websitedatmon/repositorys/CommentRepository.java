package com.example.websitedatmon.repositorys;

import com.example.websitedatmon.domain.Comment;
import com.example.websitedatmon.domain.Company;
import com.example.websitedatmon.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    Comment save(Comment comment);
    List<Comment> findCommentByFood(Food food);
}
