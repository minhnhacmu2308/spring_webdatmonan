package com.example.websitedatmon.services;

import com.example.websitedatmon.domain.FeedBack;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface FeedbackService {
    FeedBack findFeedBackById(int id);
    List<FeedBack> findAll();

    FeedBack save(FeedBack FeedBack);
    void deleteById(int id);
}
