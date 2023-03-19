package com.jaimayal.usersmicroservice.repositories;

import com.jaimayal.usersmicroservice.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByIdIn(List<Long> userIds);
}
