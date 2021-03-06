package no.experis.ballcusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import no.experis.ballcusers.User;
import no.experis.ballcusers.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController    // This means that this class is a Controller
@RequestMapping(path="/") 
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private UserRepository userRepository;

	@CrossOrigin(origins = "*")
	@PostMapping("/addusers")
	public User create(@RequestBody Map<String, String> body) {
		String username = body.get("username");
		String email = body.get("email");
		String password = body.get("password");
		Boolean admin = Boolean.parseBoolean( body.get("admin"));
		String trackedPlayers = body.get("tracked_players");
		String trackedTeams = body.get("tracked_teams");
		
		return userRepository.save(new User(username, email, password, admin, trackedPlayers, trackedTeams));
	}


	@CrossOrigin(origins = "*")
	@PutMapping("/updateusers/{id}")
	public User update(@PathVariable int id,
			@RequestBody Map<String, String> body) {
		User user = userRepository.findById(id).get();
		user.setUsername(body.get("username"));
		user.setEmail(body.get("email"));
		user.setPassword(body.get("password"));
		user.setAdmin(Boolean.parseBoolean(body.get("admin")));
		user.setTrackedPlayers(body.get("tracked_players"));
		user.setTrackedTeams(body.get("tracked_teams"));

		return userRepository.save(user);
	}

//endpoint to check existence of user
	//get user by username?
	//create (Done), delete (done), update, get all (done), get by username (done)

	@CrossOrigin(origins = "*")
	@GetMapping(path="/users")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path="/users/{username}")
	public @ResponseBody User getUserByName(@PathVariable("username") String username) {
		// This returns a JSON or XML with the users
		return userRepository.findByUsername(username);
	}

	@CrossOrigin(origins = "*")
	@GetMapping(path="/deleteusers/{username}")
	public void deleteUserByName(@PathVariable("username") String username){
		userRepository.deleteByUsername(username);

	}

	//{true} or {false}
	@CrossOrigin(origins = "*")
	@GetMapping(path="/emails/{email}")
	public boolean emailExists(@PathVariable("email") String email){
		Integer result = userRepository.checkEmailExistence(email);
		if(result==1){
			return true;
		}
		return false;
	}

}