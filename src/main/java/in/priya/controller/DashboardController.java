package in.priya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import in.priya.service.DashboardService;

@Controller
public class DashboardController {
	
    @Autowired
	private DashboardService dashboardService;
    
    
	@GetMapping("/dashboard")
	public String getDashboard(Model model)
	{
		String str=dashboardService.getQuote();
		
		model.addAttribute("quote", str);
		
		return "dashboard";
	}
	
	

}
