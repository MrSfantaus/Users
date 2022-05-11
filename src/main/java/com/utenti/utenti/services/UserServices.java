package com.utenti.utenti.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utenti.utenti.model.Persona;
import com.utenti.utenti.repository.DAOUsers;

@Service
public class UserServices {

	@Autowired
	DAOUsers daoUsers;

	// Lista di tutti gli utenti
	public List<Persona> getUsers(){

		ArrayList<Persona> users = new ArrayList<Persona>();

		// Creo una lista di mappe che recupero con il read() all'interno di DAOUsers
		List<Map<String,String>> usersMap = daoUsers.read();

		Persona p;

		// Ciclo la lista per la propria dimensione
		for(int i = 0 ; i < usersMap.size() ; i++) {
			// Creo una nuova Persona prendendo l'elemento in posizione di i
			p = new Persona( usersMap.get(i) );
			// Aggiungo la persona all'ArrayList di oggetti Persona
			users.add(p);
		}
		return users;
	}
	// Lista di tutti gli utenti con un determinato nome
	public List<Persona> getUserByName(String nome) {
		ArrayList<Persona> users = new ArrayList<Persona>();

		// Creo una lista di mappe che recupero con il read() all'interno di DAOUsers
		List<Map<String,String>> usersMap = daoUsers.read();

		Persona p;

		// Ciclo la lista per la propria dimensione
		for(int i = 0 ; i < usersMap.size() ; i++) {
			// Verifico se esiste una Persona con il nome indicato
			if(usersMap.get(i).containsValue(nome)) {
				// Se esiste
				// Creo una nuova Persona prendendo l'elemento in posizione di i
				p = new Persona( usersMap.get(i) );
				// Aggiungo la persona all'ArrayList di oggetti Persona
				users.add(p);
			}			
		}
		return users;
	}
	// Utente recuperato da ID
	public Persona getUserById(int id) {

		// Creo una lista di mappe che recupero con il read() all'interno di DAOUsers
		List<Map<String,String>> usersMap = daoUsers.read();

		Persona p = null;

		// Ciclo la lista per la propria dimensione
		for(int i = 0 ; i < usersMap.size() ; i++) {
			// Verifico se esiste una Persona con l'id indicato
			if(usersMap.get(i).containsValue(id+"")) {
				// Se esiste
				// Creo una nuova Persona prendendo l'elemento in posizione di i
				p = new Persona( usersMap.get(i) );
			}			
		}
		return p;
	}
	// Creazione utente
	public void createUser(Persona persona) {
		// Creo la Persona dai parametri ricevuti
		Persona p = new Persona(persona.getNome(),persona.getCognome());
		// Inserico la Persona nel DB
		boolean esito = daoUsers.create(p) ? true : false;
		// Stampa di verifica in console
		if(esito==true) {
			System.out.println("CREATE OK");
		}
		else {
			System.out.println("CREATE NOPE");
		}
	}
	// Elimina utente per id
	public void deleteUser(int id) {
		// Elimino la Persona
		boolean esito = daoUsers.delete(id) ? true : false;
		// Stampa di verifica in console
		if(esito==true) {
			System.out.println("DEL OK");
		}
		else {
			System.out.println("DEL NOPE");
		}
	}
	// Update utente per id
	public void updateUser(int id, Persona persona) {
		Persona p = getUserById(id);
		
		p.setNome(persona.getNome());
		p.setCognome(persona.getCognome());
		
		boolean esito = daoUsers.update(p) ? true : false;
		// Stampa di verifica in console
		if(esito==true) {
			System.out.println("PUT OK");
		}
		else {
			System.out.println("PUT NOPE");
		}	

	}

}