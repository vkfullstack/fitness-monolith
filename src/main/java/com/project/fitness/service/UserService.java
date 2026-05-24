package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.model.UserRole;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final  PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequest request) {
        UserRole role = request.getRole() !=null ? request.getRole()
                :UserRole.USER;

        User user = User.builder()
                .email(request.getEmail())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
              //  .role(UserRole.valueOf(request.getRole()))
                .role(role)
                .build();

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

//        return UserResponse.builder()
//                .id(savedUser.getId())
//                .email(savedUser.getEmail())
//                .firstName(savedUser.getFirstName())
//                .lastName(savedUser.getLastName())
//                .password(savedUser.getPassword())
//                .createdAt(savedUser.getCreatedAt())
//                .updatedAt(savedUser.getUpdatedAt())
//                .build();
//    }

    public UserResponse mapToResponse(User savedUser) {
               UserResponse response = new UserResponse();
                response.setId(savedUser.getId());
                response .setEmail(savedUser.getEmail());
                 response .setFirstName(savedUser.getFirstName());
                 response .setLastName(savedUser.getLastName());
                 response .setPassword(savedUser.getPassword());
                  response  .setCreatedAt(savedUser.getCreatedAt());
                   response   .setUpdatedAt(savedUser.getUpdatedAt());
        return response;



    }

}
