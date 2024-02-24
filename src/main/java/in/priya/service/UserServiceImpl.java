package in.priya.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.priya.binding.LoginForm;
import in.priya.binding.RegisterForm;
import in.priya.binding.ResetPwdForm;
import in.priya.constant.AppConstants;
import in.priya.entity.City;
import in.priya.entity.Country;
import in.priya.entity.State;
import in.priya.entity.User;
import in.priya.props.AppProperties;
import in.priya.repository.CityRepository;
import in.priya.repository.CountryRepository;
import in.priya.repository.StateRepository;
import in.priya.repository.UserRepository;
import in.priya.utils.EmailUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private CountryRepository countryRepo;
	
	@Autowired
	private StateRepository stateRepo;
	
	@Autowired
	private CityRepository cityRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmailUtils emailUtil;
	
	@Autowired
	private AppProperties props;
	
	Random random=new Random();
	
	@Override
	public Map<Integer, String> getCountries() {
		
		    Map<Integer, String> countryList=new HashMap<>();
		    
		       List<Country> country= countryRepo.findAll();
		       
		       country.forEach(c->countryList.put(c.getCountryId(),c.getCountryName()));
		       
		return countryList;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {

		Map<Integer, String> statesMap = new HashMap<>();

		List<State> statesList = stateRepo.findByCountryId(countryId);

		statesList.forEach(s ->statesMap.put(s.getStateId(), s.getStateName()));

		return statesMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {

		Map<Integer, String> citiesMap = new HashMap<>();

		List<City> citiesList = cityRepo.findByStateId(stateId);

		citiesList.forEach(c ->citiesMap.put(c.getCityId(), c.getCityName()));

		return citiesMap;
	}
	@Override
	public User getUser(String email) {
		     return userRepo.findByEmail(email);
	}

	@Override
	public boolean saveUser(RegisterForm reg) {
		   User user=new User();
	       user.setPwdUpdated("NO");
           String pwd=generateRandomPwd();
            user.setPassword(pwd);
            BeanUtils.copyProperties(reg, user);
            userRepo.save(user);
	        String subject=props.getMessages().get("subject");
	        String body="Your password is:" + pwd;
	        return emailUtil.sendEmail(subject, body,user.getEmail());
	         
	}

	private String generateRandomPwd() {
		 StringBuilder bf=new StringBuilder();
	      final String str=AppConstants.STR;
	  	  
	  	
	      for(int i=0;i<=6;i++)
	      {
	    	  int charIndex=random.nextInt(str.length()-1);
	    	  char character=str.charAt(charIndex);
	    	   bf=bf.append(character);
	      }
	      return bf.toString();
	}

	@Override
	public User login(LoginForm login) {
            return userRepo.findByEmailAndPassword(login.getEmail(), login.getPassword());
		
	}

	@Override
	public boolean resetPwd(ResetPwdForm reset) {
		     Optional<User> user= userRepo.findById(reset.getUserId());
		     if(user.isPresent())
		     {
		    	 User user1=user.get();	
		         user1.setPassword(reset.getConfirmPwd());
		         user1.setPwdUpdated("YES");
		         userRepo.save(user1);
		         return true;
		     }
		return false;
	}
	
	

}
