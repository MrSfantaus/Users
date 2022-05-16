package com.utenti.utenti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utenti.utenti.model.Persona;
import com.utenti.utenti.model.TODO;
import com.utenti.utenti.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServices userServices;

	@Autowired
	TODOController todoController;
	
	
	// GET		http://localhost:8080/users
	@GetMapping
	public List<Persona> getUsers() {
		return userServices.getUsers();
	}

	// GET		http://localhost:8080/users/byname/...
	@GetMapping("/byname/{nome}")
	public List<Persona> getUserByName(@PathVariable("nome") String nome){
		return userServices.getUserByName(nome);
	}

	// GET		http://localhost:8080/users/byid/...
	@GetMapping("/byid/{id}")
	public Persona getUserById(@PathVariable("id") int id){
		return userServices.getUserById(id);
	}

	// POST		http://localhost:8080/users
	/*	BODY
	 *  {
		        "nome": "....",
		        "cognome": "...."
		    }
	 */
	@PostMapping
	public void createUser(@RequestBody Persona persona) {
		userServices.createUser(persona);
	}

	// DELETE	http://localhost:8080/users/...
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		System.out.println("Sono dentro");
		userServices.deleteUser(id);
		System.out.println("Passato");
	}

	// PUT		http://localhost:8080/users/ ... 
	//												+
													/*	BODY
													 *  {
													        "nome": "....",
													        "cognome": "...."
													    }
													 */
	@PutMapping("/{id}")
	public void updateUser(@PathVariable("id") int id, @RequestBody Persona persona) {
		userServices.updateUser(id, persona);
	}
	
}
