package com.jaimayal.usersmicroservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "courses-microservice", url = "localhost:8082/api/v1/courses")
public interface CoursesMicroserviceClient {

    @DeleteMapping("/users/{userId}")
    ResponseEntity<?> unrollUserFromAllCourses(@PathVariable Long userId);
}
