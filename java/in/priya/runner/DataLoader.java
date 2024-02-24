package in.priya.runner;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.priya.entity.Course;
import in.priya.repository.CourseRepository;


@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private CourseRepository courseRepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Course c1=new Course(1,"Java",8000);
		Course c2=new Course(2,"Paython",10000);
		Course c3=new Course(3,"Spring Boot",9000);
		
        courseRepo.saveAll(Arrays.asList(c1,c2,c3));
		
	}
	
	

}
