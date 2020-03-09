package storefront.storefront.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonIgnore;

import storefront.storefront.domain.users.User;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Vinylgroup {
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private String sharecode;
	
	@ManyToOne	// Yhdessä pelissä voi olla useita Vinyl Groupeja
	@JsonIgnore
	@JoinColumn(name = "gameid")
	private Game game;
	
	@ManyToOne	// Yhdessä pelissä voi olla useita Vinyl Groupeja
	@JsonIgnore
	@JoinColumn(name = "userid")
	private User user;
	
	// Konstruktorit
	
	public Vinylgroup() {
		super();
	}
	
	public Vinylgroup(String name, String description, String sharecode) {
		super();
		this.name = name;
		this.description = description;
		this.sharecode = sharecode;
	}
	
	public Vinylgroup(String name, String description, String sharecode, Game game, User user) {
		super();
		this.name = name;
		this.description = description;
		this.sharecode = sharecode;
		this.game = game;
		this.user = user;
	}
	
		// Getterit
		public Long getId() {return id;}
		public String getName() {return name;}
		public String getDescription() {return description;}
		public String getSharecode() {return sharecode;}
		public User getUser() {return user;}
		public Game getGame() {return game;}
		

		// Setterit
		public void setId(Long id) {this.id = id;}
		public void setName(String name) {this.name = name;}
		public void setDescription(String description) {this.description = description;}
		public void setSharecode(String sharecode) {this.sharecode = sharecode;}
		public void setUser(User user) {this.user = user;}
		public void setGame(Game game) {this.game = game;}

		@Override
		public String toString() {
			return "Vinylgroup [id=" + id + ", name=" + name + ", description=" + description + ", sharecode="
					+ sharecode + "]";
		}
}
