package com.webapp.spring_app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServiceEx {
	private List<Course> courses = new ArrayList<>(Arrays.asList(new Course(1,"A"),
																new Course(2,"B"),
																new Course(3,"C")));
	public List<Course> getcourses(){
		return courses;
	}
	public Course getcourse(String id){
		System.out.println("HI");
		return courses.stream().filter(t -> t.getC_id()==Integer.parseInt(id)).findFirst().get();
	}
	public void addCourse(Course crs) {
		courses.add(crs);
	}
}
