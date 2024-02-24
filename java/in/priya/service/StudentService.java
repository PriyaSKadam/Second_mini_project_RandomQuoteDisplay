package in.priya.service;

import java.util.Map;
import java.util.Optional;

import in.priya.binding.Login;
import in.priya.entity.Course;


public interface StudentService {
	
	public boolean loginCheck(Login login);
	
	public Map<Integer,String> getCourseNames();
	
	public Course getCourseFee(Integer id);


}
