package in.priya.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.priya.binding.Login;
import in.priya.entity.Course;
import in.priya.entity.Student;
import in.priya.properties.AppProps;
import in.priya.repository.CourseRepository;
import in.priya.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private StudentService studService;
	
	@Autowired
	private AppProps props;
	
	@GetMapping("/")
	public String login(Model model)
	{
	   model.addAttribute("login",new Login());
		return "LoginPage";
	}
	
	@PostMapping("/adminLogin")
	public String getLogin(Login login,Model model)
	{
		   boolean status=studService.loginCheck(login);
		   if(status)
		   {
			   return "DashBoard";
		   }
		
		   model.addAttribute("fmsg",props.getMessages().get("invalidLogin"));
		 return "LoginPage";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model)
	{
		   Map<Integer,String> map= studService.getCourseNames();
		model.addAttribute("student", new Student());
		model.addAttribute("courses", map);
		return "Student";
	}
	
	@GetMapping("/getFee")
	@ResponseBody
	public String getFee(@RequestParam("courseId") Integer courseId, Model model)
	{
	    Course c=studService.getCourseFee(courseId);
		model.addAttribute("fee",c.getCourseFee());
		return "Student";
	}
	

}
