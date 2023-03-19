package com.jaimayal.usersmicroservice.services;

import com.jaimayal.usersmicroservice.entities.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> getUsers();
    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User user);
    User updateUser(Long userId, Map<String, String> updates);
    void deleteUser(Long userId);
    List<User> getUsersByIdsIn(List<Long> userIds);
}
