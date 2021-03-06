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

	@Column(name = "tracked_players")
    private String trackedPlayers;

	@Column(name = "tracked_teams")
    private String trackedTeams;

    public User() {

    }

	public User(String username, String email, String password, Boolean admin, String trackedPlayers, String trackedTeams) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.admin = admin;
		this.trackedPlayers = trackedPlayers;
		this.trackedTeams = trackedTeams;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getTrackedPlayers() {
		return trackedPlayers;
	}

	public void setTrackedPlayers(String trackedPlayers) {
		this.trackedPlayers = trackedPlayers;
	}

	public String getTrackedTeams() {
		return trackedTeams;
	}

	public void setTrackedTeams(String trackedTeams) {
		this.trackedTeams = trackedTeams;
	}
}
