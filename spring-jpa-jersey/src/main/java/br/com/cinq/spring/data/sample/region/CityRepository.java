package br.com.cinq.spring.data.sample.region;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CityRepository extends JpaRepository<City, String> {

	@Transactional(readOnly = true)
	@Query("from City c where c.country.name like CONCAT('%',:country,'%')")
	Stream<City> findAllByCountryName(@Param("country") String country);

	@Transactional(readOnly = true)
	@Query("from City c where c.country.id = :#{#country.id}")
	Stream<City> findAllByCountryId(@Param("country") Country country);

}
