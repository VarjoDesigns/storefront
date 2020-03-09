package storefront.storefront.domain;

import javax.persistence.*;

@Entity
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    
    @Column(name="firstname")
	private String firstName;
    
    @Column(name="lastname")
	private String lastName;
	
    // Username with unique constraint
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String passwordHash;
        
	private String role;
	
	// Konstruktori
	
	public User() {
	}
	
	public User(String firstName, String lastName, String username, String passwordHash, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}
	
	public User(String username, String passwordHash, String role) {
		this.username = username;
		this.passwordHash = passwordHash;
		this.role = role;
	}
	
	
	// Getterit
	public Long getId() {return id;}
	public String getFirstName() {return firstName;}
	public String getLastName() {return lastName;}
	public String getUsername() {return username;}
	public String getPasswordHash() {return passwordHash;}
	public String getRole() {return role;}

	// Setterit
	public void setId(Long id) {this.id = id;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public void setUsername(String username) {this.username = username;}
	public void setPasswordHash(String passwordHash) {this.passwordHash = passwordHash;}
	public void setRole(String role) {this.role = role;}
}