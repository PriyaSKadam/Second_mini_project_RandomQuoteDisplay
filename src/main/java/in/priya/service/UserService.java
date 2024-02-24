package in.priya.service;

import java.util.Map;

import in.priya.binding.LoginForm;
import in.priya.binding.RegisterForm;
import in.priya.binding.ResetPwdForm;
import in.priya.entity.User;

public interface UserService {
	
	 public Map<Integer, String> getCountries();
	 public Map<Integer,String> getStates(Integer countryId);
	 public Map<Integer,String> getCities(Integer stateId);
	 public User getUser(String email);
	 public boolean saveUser(RegisterForm reg);
	 public User login(LoginForm login);
	 public boolean resetPwd(ResetPwdForm reset);

}
