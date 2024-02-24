package in.priya.runner;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.priya.entity.City;
import in.priya.entity.Country;
import in.priya.entity.State;
import in.priya.repository.CityRepository;
import in.priya.repository.CountryRepository;
import in.priya.repository.StateRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
	   
		 Country c1=new Country(1,"India");
		 Country c2=new Country(2,"USA");
		 
		 countryRepo.saveAll(Arrays.asList(c1,c2));
		 
		State s1=new State(1,"Maharashtra",1);
		State s2=new State(2,"Gujarat",1);
		State s3=new State(3,"USA-State1",2);
		State s4=new State(4,"USA-State2",2);
		
		stateRepo.saveAll(Arrays.asList(s1,s2,s3,s4));
		
		City city1=new City(1,"Sangli",1);
		City city2=new City(2,"Mumbai",1);
		City city3=new City(3,"Porbandar",2);
		City city4=new City(4,"Baroda",2);
		City city5=new City(5,"USA-S1-city1",3);
		City city6=new City(6,"USA-S1-city2",3);
		City city7=new City(7,"USA-S2-City1",4);
		City city8=new City(8,"USA-S3-City2",5);
		
		cityRepo.saveAll(Arrays.asList(city1,city2,city3,city4,city5,city6,city7,city8));
		
	}
	
	

}
