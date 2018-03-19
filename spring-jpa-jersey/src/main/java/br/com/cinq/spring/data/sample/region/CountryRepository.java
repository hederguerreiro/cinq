package br.com.cinq.spring.data.sample.region;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	@Query("from Country co where co.name like CONCAT('%',:country,'%')")
	List<Country> findLikeName(@Param("country") String country);
}
