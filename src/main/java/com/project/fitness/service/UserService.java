package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private  final UserRepository userRepository;
    public User register(RegisterRequest request) {

        LocalDateTime now = Instant.now()
                .atZone(ZoneOffset.UTC)
                .toLocalDateTime();
        User users= new User(
                null,
                request.getEmail(),
                request.getPassword(),
                request.getFirstName(),
                request.getLastName(),
              now,
                now,
                List.of(),
                List.of()

        );
        return  userRepository.save(users);

    }
}
