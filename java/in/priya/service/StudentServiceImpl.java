package in.priya.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.priya.binding.Login;
import in.priya.entity.Course;
import in.priya.properties.AppProps;
import in.priya.repository.CourseRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private AppProps props;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Override
	public boolean loginCheck(Login login) {
		if(props.getMessages().get("email").equals(login.getEmail()))
		{
			if(props.getMessages().get("pwd").equals(login.getPassword()))
			{
				return true;
			}
		}
	
		return false;
	}

	@Override
	public Map<Integer, String> getCourseNames() {
		 Map<Integer,String> courses=new HashMap<>();
		 
		 List<Course> courseList=courseRepo.findAll();
		 
		 courseList.forEach(c->courses.put(c.getCourseId(), c.getCourseName()));
		 
		return courses;
	}

	@Override
	public Course getCourseFee(Integer id) {
		  Optional<Course> c=courseRepo.findById(id);

		  if(c.isPresent())
		  {
			  Course course=c.get();
			  return course;
		  }
		return null;
	}
	
	
	

}
