package storefront.storefront.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Livery {
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	private String description;
	private String sharecode;
	// Upload date
	// Model & manufacturer
	// Year
	// Category
	// Game
	
	@ManyToOne	// Yhdessä maassa voi olla useita valmistajia
	@JsonIgnore
	@JoinColumn(name = "gameid")
	private Game game;
	
	// Konstruktorit
	
	public Livery() {
		super();
	}
	
	public Livery(String name, String description, String sharecode) {
		super();
		this.name = name;
		this.description = description;
		this.sharecode = sharecode;
	}
	
	public Livery(String name, String description, String sharecode, Game game) {
		super();
		this.name = name;
		this.description = description;
		this.sharecode = sharecode;
		this.game = game;
	}
	
	
	// Getterit
	public Long getId() {return id;}
	public String getName() {return name;}
	public String getDescription() {return description;}
	public String getSharecode() {return sharecode;}
	public Game getGame() {return game;}

	// Setterit
	public void setId(Long id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setDescription(String description) {this.description = description;}
	public void setSharecode(String sharecode) {this.sharecode = sharecode;}
	public void setGame(Game game) {this.game = game;}
	
	@Override
	public String toString() {
		return "Livery [id=" + id + ", name=" + name + ", description=" + description + ", sharecode=" + sharecode
				+ "]";
	}
}


