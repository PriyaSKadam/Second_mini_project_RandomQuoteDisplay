package in.priya.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer countryId;
    private String CountryName;
    
    
   public Country() {
		super();
	}

	public Country(Integer countryId, String countryName) {
		super();
		this.countryId = countryId;
		CountryName = countryName;
	}
	
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public String getCountryName() {
		return CountryName;
	}
	public void setCountryName(String countryName) {
		CountryName = countryName;
	}
    
    
	
    
    


}
