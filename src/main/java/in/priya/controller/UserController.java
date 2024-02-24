package in.priya.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.priya.binding.LoginForm;
import in.priya.binding.RegisterForm;
import in.priya.binding.ResetPwdForm;
import in.priya.constant.AppConstants;
import in.priya.entity.Country;
import in.priya.entity.User;
import in.priya.props.AppProperties;
import in.priya.service.UserService;

@Controller
public class UserController {

	@Autowired
	private  UserService userService;
	
	@Autowired
	private AppProperties props;
	
	
	@GetMapping("/index")
	public String login(Model model)
	{
		model.addAttribute(AppConstants.LOGIN, new LoginForm());
		return AppConstants.LOGIN;
	}

	@PostMapping("/checkLogin")
    public String checkLogin(@ModelAttribute(AppConstants.LOGIN) LoginForm login, Model model)
    {
		  User user=userService.login(login);
		  if(user==null)
		  {
			 model.addAttribute("fmsg", props.getMessages().get("invalidLogin"));
			  return AppConstants.LOGIN;
		  }
	
			  if(user.getPwdUpdated().equalsIgnoreCase("NO"))
			  { 
				  ResetPwdForm obj=new ResetPwdForm();
				  obj.setUserId(user.getUserId());
				  model.addAttribute(AppConstants.RESET_PWD, obj);
				  
				  return AppConstants.RESET_PWD;
			  }
			 
				  return "redirect:dashboard";
			  
		  
    }
	
	
	
	@GetMapping("/register")
	public String registration(Country country,Model model)
	{
	       Map<Integer,String> map=userService.getCountries();
	      
		model.addAttribute("reg", new RegisterForm());
		
		model.addAttribute("country",map);
		return "register";
	}
	
	@PostMapping("/saveReg")
	public String userRegister(@ModelAttribute("reg") RegisterForm reg,Model model)
	{
		boolean status=userService.saveUser(reg);
		if(status)
		{
			model.addAttribute("smsg", props.getMessages().get("successMsg"));
		}
		
		else {

			model.addAttribute("fmsg", props.getMessages().get("failureMsg"));
		}
		
		Map<Integer,String> countries = userService.getCountries();
		model.addAttribute("country", countries);
		
		return "register";
	}
	

	@PostMapping("/updatePwd")
	public String updatePassword(@ModelAttribute(AppConstants.RESET_PWD) ResetPwdForm resetPwd,Model model)
	{
		if(resetPwd.getNewPwd().equals(resetPwd.getConfirmPwd()))
		{
	              boolean status= userService.resetPwd(resetPwd); 
	  if(status)
	  {
		  
		  return "redirect:dashboard";
	  }
		}
	model.addAttribute(AppConstants.ERROR_MSG, props.getMessages().get("pwdUpdateFail"));
	
    return "resetPwd";
	  
	}
	
	@GetMapping("/getStates")
	@ResponseBody
	public Map<Integer, String> getStates(@RequestParam("countryId") Integer countryId) {
		return userService.getStates(countryId);
	}
	
	@GetMapping("/getCity")
	@ResponseBody
	public Map<Integer, String> getCities(@RequestParam("stateId") Integer stateId){
		return userService.getCities(stateId);
	}
}
