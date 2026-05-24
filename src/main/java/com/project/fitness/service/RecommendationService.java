package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.RecommendationRequest;
import com.project.fitness.model.Activity;
import com.project.fitness.model.Recommendation;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.RecommendationRepositiory;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private  final RecommendationRepositiory recommendationRepositiory;
    private  final UserRepository userRepository;
    private  final ActivityRepository activityRepository;
    public Recommendation generateRecommendation(RecommendationRequest request) {
        System.out.println("USER ID: " + request.getUserId());
        System.out.println("ACTIVITY ID: " + request.getActivityId());

        User user=userRepository.findById(request.getUserId())
                .orElseThrow(()-> new RuntimeException("user not found"+ request.getUserId()));
        Activity activity=activityRepository.findById(request.getActivityId())
                .orElseThrow(()-> new RuntimeException("user not found"+ request.getActivityId()));
        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvement(request.getImprovement())
                .suggestion(request.getSuggestion())
                .safety(request.getSafety())
                .build();
        return recommendationRepositiory.save(recommendation);


    }

    public List<Recommendation> getUserRecommendation(String userId) {
        return  recommendationRepositiory.findByUserId(userId);
    }

    public List<Recommendation> getActivityRecommendation(String activityId) {
        return  recommendationRepositiory.findByActivityId(activityId);
    }
}
