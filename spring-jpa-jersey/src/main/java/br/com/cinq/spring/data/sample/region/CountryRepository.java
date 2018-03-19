package br.com.cinq.spring.data.sample.region;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

	@Transactional(readOnly = true)
	@Query("from Country co where co.name like CONCAT('%',:country,'%')")
	Stream<Country> findLikeName(@Param("country") String country);
}
