package com.utenti.utenti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utenti.utenti.model.Persona;
import com.utenti.utenti.services.UserServices;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserServices userServices;

	// GET		http://localhost:8080/users
	@GetMapping
	public List<Persona> getUsers() {
		return userServices.getUsers();
	}

	// GET		http://localhost:8080/users/byName?nome= ....
	@GetMapping("/byName")
	public List<Persona> getUserByName(@RequestParam String nome){
		return userServices.getUserByName(nome);
	}

	// GET		http://localhost:8080/users/byId?id= ....
	@GetMapping("/byId")
	public Persona getUserById(@RequestParam int id){
		return userServices.getUserById(id);
	}

	// POST		http://localhost:8080/users/create
	/*	BODY
	 *  {
		        "nome": "....",
		        "cognome": "...."
		    }
	 */
	@PostMapping("/create")
	public void createUser(@RequestBody Persona persona) {
		userServices.createUser(persona);
	}

	// DELETE	http://localhost:8080/users/delete?id= ...
	@DeleteMapping("/delete")
	public void deleteUser(@RequestParam int id) {
		userServices.deleteUser(id);
	}

	// PUT		http://localhost:8080/users/update?id= ... &
	/*	BODY
	 *  {
	        "nome": "....",
	        "cognome": "...."
	    }
	 */
	@PutMapping("/update")
	public void updateUser(@RequestParam int id, @RequestBody Persona persona) {
		userServices.updateUser(id, persona);
	}
}
