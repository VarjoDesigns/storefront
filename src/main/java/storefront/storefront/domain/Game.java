package storefront.storefront.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class Game {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String abbreviation;
	// publisher
	// year
	// name
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
	private List<Livery> liveries;
	
	// Konstruktorit
	public Game() {
		super();
	}
	
	public Game(String name, String abbreviation) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
	}
	
	// Getterit

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public List<Livery> getLiveries() {
		return liveries;
	}

	// Setterit
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public void setLiveries(List<Livery> liveries) {
		this.liveries = liveries;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + ", liveries=" + liveries + "]";
	}

}