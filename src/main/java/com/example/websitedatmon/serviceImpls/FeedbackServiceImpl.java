package com.example.websitedatmon.serviceImpls;

import com.example.websitedatmon.domain.FeedBack;
import com.example.websitedatmon.domain.Post;
import com.example.websitedatmon.repositorys.FeedbackRepository;
import com.example.websitedatmon.repositorys.PostRepository;
import com.example.websitedatmon.services.FeedbackService;
import com.example.websitedatmon.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public FeedBack findFeedBackById(int id) {
        return feedbackRepository.findFeedBackById(id);
    }

    @Override
    public List<FeedBack> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    public FeedBack save(FeedBack feedBack) {
        return feedbackRepository.save(feedBack);
    }

    @Override
    public void deleteById(int id) {
        feedbackRepository.deleteById(id);
    }
}
