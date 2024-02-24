package in.priya.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import in.priya.entity.Country;


public interface CountryRepository extends JpaRepository<Country, Integer> {
	


}
