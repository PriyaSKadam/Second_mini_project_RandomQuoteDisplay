package in.priya.service;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.priya.binding.Quote;


@Service
public class DashboardServiceImpl implements DashboardService {

	private String url="https://type.fit/api/quotes";
	private Quote[] quote=null;
	String str="";
	Random r=new Random();
	
	@Override
	public String getQuote() {
		if(quote==null)
		{
		RestTemplate rt=new RestTemplate();
		 ResponseEntity<String> forEntity= rt.getForEntity(url, String.class);
		 String body=forEntity.getBody();
		 
		 ObjectMapper mapper=new ObjectMapper();
		 try {
		  quote=mapper.readValue(body, Quote[].class);
			
		} catch (JsonProcessingException e ) {
	
			e.printStackTrace();
		} 
		 
		}
		else
		{
			int nextInt=r.nextInt(quote.length-1);
		     str= quote[nextInt].getText();
		}
		
		return str;
	}

	
	
}
