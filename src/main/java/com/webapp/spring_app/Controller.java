package com.webapp.spring_app;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping("/")
	public String publishMsg() {
		return "Hello";
	}
	@RequestMapping("/hi")
	public String Hi() {
		return "Hi";
	}
	/*
	 <Difference between @RestController and @Serice>
	 */
	//here to get all courses, response is created for each request
	@RequestMapping("/courses_controller")
	public List<Course> getcourses_controller(){
		return Arrays.asList(new Course(1,"A"),new Course(2,"B"),new Course(3,"C"));
	}
	
	/*here to get all courses, response is created only once as ServiceEx class is defined as @service.
	The instance for that is created prior and stored in memory by spring*/
	@Autowired
	private ServiceEx serviceex;
	@RequestMapping("/courses_service")
	public List<Course> getcourses_service(){
		return serviceex.getcourses();
	}
	/*
	 </ Difference between @RestController and @Serice>
	 */
	@RequestMapping("/courses_service/{c_id}")
	public Course getcourse_service(@PathVariable String c_id)
	{
		return serviceex.getcourse(c_id);
	}
	//GET is default
	//POST request
	@RequestMapping(method = RequestMethod.POST, value = "/addcourse")
	public void addCourse(@RequestBody Course crs) {
				serviceex.addCourse(crs);
	}
}
