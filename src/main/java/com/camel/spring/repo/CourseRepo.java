package com.camel.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.camel.spring.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Integer> {

}
