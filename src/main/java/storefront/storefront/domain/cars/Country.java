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
public class Country {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	
	// Konstruktorit
	public Country() {
		super();
	}
	
	public Country(String name) {
		super();
		this.name = name;
	}
	
	// Getterit
	
	public Long getId() {return id;}
	public String getName() {return name;}
	
	// Setterit
	
	public void setId(Long id) {this.id = id;}
	public void setName(String name) {this.name = name;}
}
