package br.com.cinq.spring.data.sample.region;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Size(max = 40)
	private String name;
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

	public City(String name, Country country) {
		this.name = name;
		this.country = country;
	}

}
