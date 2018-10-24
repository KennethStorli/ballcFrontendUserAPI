package no.experis.ballcusers;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    private String username;

    private String email;

    private String password;

    @Column(name="`admin`")
    private Boolean admin;

    public User() {

    }

    public User(String username, String email, String password, Boolean admin) {
    	this.username = username;
    	this.email = email;
    	this.password = password;
    	this.admin = admin;
    }

	public Integer getId() {
		return user_id;
	}

	public void setId(Integer id) {
		this.user_id = id;
	}

	public String getName(){
		return username;
	}

	public void setName(String name){
		this.username = name;
	}

	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}

	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}

	public Boolean getAdmin(){
		return admin;
	}

	public void setAdmin(Boolean admin){
		this.admin = admin;
	}
	//Getter/Setters for rest of fields, etc...
    
}
