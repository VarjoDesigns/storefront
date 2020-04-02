package storefront.storefront.domain.users;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


// Apuluokka, ei ole entiteetti! Tarkastaa käyttäjätietoja

public class RegisterUser {
	
@Size(min=5)
private String firstName;

@Size(min=5)
private String lastName;

@Size(min=5, max=30)
private String username;

@Size(min=5, max=30)
private String password;

@Size(min=5, max=30)
private String pwdcheck;

@NotNull
private String role= "USER";



public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPwdcheck() {
	return pwdcheck;
}

public void setPwdcheck(String pwdcheck) {
	this.pwdcheck = pwdcheck;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}



}
