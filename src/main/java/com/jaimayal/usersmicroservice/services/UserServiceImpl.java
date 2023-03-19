package com.jaimayal.usersmicroservice.services;

import com.jaimayal.usersmicroservice.entities.User;
import com.jaimayal.usersmicroservice.exception.UserNotFoundException;
import com.jaimayal.usersmicroservice.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    
    private UserRepository userRepository;
    
    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
    
    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));
    }
    
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public User updateUser(Long userId, User user) {
        User userToUpdate = this.getUserById(userId);
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        User updatedUser = userRepository.save(userToUpdate);
        return updatedUser;
    }
    
    @Override
    public User updateUser(Long userId, Map<String, String> updates) {
        User userToUpdate = this.getUserById(userId);
        updates.forEach((key, value) -> {
            switch (key) {
                case "firstName" -> userToUpdate.setFirstName(value);
                case "lastName" -> userToUpdate.setLastName(value);
                case "email" -> userToUpdate.setEmail(value);
            }
        });
        User updatedUser = userRepository.save(userToUpdate);
        return updatedUser;
    }
    
    @Override
    public void deleteUser(Long userId) {
        User userToDelete = this.getUserById(userId);
        userRepository.delete(userToDelete);
    }

    @Override
    public List<User> getUsersByIdsIn(List<Long> userIds) {
        return userRepository.findAllByIdIn(userIds);
    }
}
