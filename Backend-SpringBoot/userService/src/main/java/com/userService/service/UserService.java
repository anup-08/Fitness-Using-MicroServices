package com.userService.service;

import com.example.dtos.UserRequest;
import com.example.dtos.UserResponse;
import com.example.exceptions.UserAlreadyExist;
import com.example.exceptions.UserNotFound;
import com.userService.enums.Gender;
import com.userService.enums.Role;
import com.userService.model.User;
import com.userService.repo.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository repo;

    public UserResponse registerUser(UserRequest request) {
        if(repo.existsByEmail(request.getEmail())){
            throw new UserAlreadyExist("Email Already Exist with : "+request.getEmail());
        }

        Gender genderEnum;
        try {
            genderEnum = Gender.valueOf(request.getGender().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid gender provided: " + request.getGender());
        }
        Role roleEnum;
        try {
            if(request.getRole() != null) {
                roleEnum = Role.valueOf(request.getRole().toUpperCase());
            }
            else{
                roleEnum = Role.valueOf("user".toUpperCase());
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid role provided: " + request.getRole());
        }

        User user = new User(request.getFirstName(),request.getLastName(),request.getEmail(),request.getPassword(),
                request.getAge(),genderEnum , roleEnum );

        return response(repo.save(user));

    }

    public UserResponse getUserDetails(String email){
        User user = repo.findByEmail(email)
                .orElseThrow(() -> new UserNotFound("User doesn't exist..!"));

        return response(user);
    }

    private UserResponse response(User user){
        return new UserResponse(user.getId(), user.getFirstName()+" "+user.getLastName(), user.getEmail(),
                user.getAge(),user.getGender().getDisplayName(),user.getRole().getDisplayName(),user.getCreatedAt(),
                user.getUpdatedAt()
                );
    }
}
