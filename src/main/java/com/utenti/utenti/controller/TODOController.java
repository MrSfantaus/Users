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

import com.utenti.utenti.model.TODO;
import com.utenti.utenti.services.TODOServices;

@RestController
@RequestMapping("/todos")
public class TODOController {

	@Autowired
	TODOServices todoServices;

	// GET		http://localhost:8080/todos
	@GetMapping
	public List<TODO> getTODO() {
		return todoServices.getTODOS();
	}

	// GET		http://localhost:8080/...
	@GetMapping("/{userid}")
	public List<TODO> userTodos(@PathVariable("userid") int id){				
		return todoServices.userTodos(id);		
	}

	// POST		http://localhost:8080/todos/...
	/*	BODY
	 *  {
			        "titolo": " .... ",
        			"descrizione": " .... "
			    }
	 */
	@PostMapping("/{userid}")
	public void createTODOUser(@PathVariable("userid") int idUser, @RequestBody TODO todo) {
		todoServices.createTODOUser(idUser, todo);
	}

	// DELETE	http://localhost:8080/todos/.../...
	@DeleteMapping("/{userid}/{id}")
	public void deleteTODOUser(@PathVariable("userid") int idUser, @PathVariable("id") int id ) {
		todoServices.deleteTODOUser(id);
	}

	// PUT		http://localhost:8080/todos/ ... 
	//												+
													/*	BODY
													 *  {
													        "nome": "....",
													        "cognome": "...."
													    }
													 */
	@PutMapping("/{userid}/{id}")
	public void updateTODOUser(@PathVariable("userid") int idUser, @PathVariable("id") int id, @RequestBody TODO todo) {
		todoServices.updateTODOUser(idUser, id, todo);
	}

}
