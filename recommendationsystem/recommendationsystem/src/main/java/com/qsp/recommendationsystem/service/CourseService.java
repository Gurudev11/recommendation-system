package com.qsp.recommendationsystem.service;

import java.util.List;

import com.qsp.recommendationsystem.model.Course;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long id);
}
