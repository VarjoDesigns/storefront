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
public class Carmodel {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	
	@ManyToOne	// Yhdessä pelissä voi olla useita liveryjä
	@JsonIgnore
	@JoinColumn(name = "manufacturerid")
	private Manufacturer manufacturer;
	
	// Konstruktorit
	
	public Carmodel() {
		super();
	}
	
	public Carmodel(String name) {
		super();
		this.name = name;
	}
	
	public Carmodel(String name, Manufacturer manufacturer) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
	}
	
	// Getterit
	public Long getId() {return id;}
	public String getName() {return name;}
	public Manufacturer manufacturer() {return manufacturer;}
	
	// Setterit
	public void setId(Long id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setManufacturer(Manufacturer manufacturer) {this.manufacturer = manufacturer;}

	@Override
	public String toString() {
		return "Carmodel [id=" + id + ", name=" + name + "]";
	}
}
