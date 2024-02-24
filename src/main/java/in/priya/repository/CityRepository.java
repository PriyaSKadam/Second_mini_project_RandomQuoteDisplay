package in.priya.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.priya.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {
	public List<City> findByStateId(Integer id);
}
