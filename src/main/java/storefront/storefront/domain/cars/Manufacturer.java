package storefront.storefront.domain.cars;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Manufacturer {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	
	@ManyToOne	
	@JsonIgnore
	@JoinColumn(name = "countryid")
	private Country country;
	
	// Konstruktorit
	
		public Manufacturer() {
			super();
		}
		
		public Manufacturer(String name) {
			super();
			this.name = name;
		}
		
		public Manufacturer(String name, Country country) {
			super();
			this.name = name;
			this.country = country;
		}
		
	// Getterit
		public Long getId() {return id;}
		public String getName() {return name;}
		public Country getCountry() {return country;}
		
	// Setterit
		
		public void setId(Long id) {this.id = id;}
		public void setName(String name) {this.name = name;}
		public void setCountry(Country country) {this.country = country;}

		@Override
		public String toString() {
			return "Manufacturer [id=" + id + ", name=" + name + "]";
		}
}
