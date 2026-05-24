package com.project.fitness.service;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.model.Activity;
import com.project.fitness.model.User;
import com.project.fitness.repository.ActivityRepository;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityService {
    private final ActivityRepository activityRepository;
    private  final UserRepository userRepository;

    public ActivityResponse trackactivity(ActivityRequest request) {

        User user= userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found" +request.getUserId()));
        Activity activity = Activity.builder()
                .user(user)
                .type(request.getType())
                .duration(request.getDuration())
                .caloriesBurned(request.getCaloriesBurned())
                .startTime(request.getStartTime())
                .additionalMetrics(request.getAdditionalMetrics())
                .build();
       Activity savedActivty=  activityRepository.save(activity);
       return  mapToResponse(savedActivty);
//       return  ActivityResponse.builder()
//               .id(savedactivty.getId())
//               .userid(savedactivty.getUser().getId())
//               .type(savedactivty.getType())
//               .caloriesBurned(savedactivty.getCaloriesBurned())
//               .duration(savedactivty.getDuration())
//               .createdAt(savedactivty.getCreatedAt())
//               .updatedAt(savedactivty.getUpdatedAt())
//
//               .build();
    }

    private ActivityResponse mapToResponse(Activity activty) {
        ActivityResponse response = new ActivityResponse();
        response.setId(activty.getId());
        response.setUserid(activty.getUser().getId());
        response.setType(activty.getType());
        response.setDuration(activty.getDuration());
        response.setCaloriesBurned(activty.getCaloriesBurned());
        response.setStartTime(activty.getStartTime());
        response.setAdditionalMetrics(activty.getAdditionalMetrics());
        response.setCreatedAt(activty.getCreatedAt());
        response.setUpdatedAt(activty.getUpdatedAt());
        return  response;
    }

    public List<ActivityResponse> getUserActivity(String userId) {
List<Activity> activityList=activityRepository.findByUserId(userId);
return activityList.stream()
        .map(this::mapToResponse)
        .collect(Collectors.toList());
    }
}
