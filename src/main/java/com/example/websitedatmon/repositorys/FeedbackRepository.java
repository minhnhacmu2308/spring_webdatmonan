package com.example.websitedatmon.repositorys;

import com.example.websitedatmon.domain.FeedBack;
import com.example.websitedatmon.domain.Post;
import com.example.websitedatmon.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<FeedBack,Integer> {
    FeedBack findFeedBackById(int id);
    List<FeedBack> findAll();

    FeedBack save(FeedBack FeedBack);
    void deleteById(int id);
}
