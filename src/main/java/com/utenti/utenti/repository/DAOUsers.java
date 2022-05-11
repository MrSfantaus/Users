package com.utenti.utenti.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.utenti.utenti.model.Persona;

@Repository
public class DAOUsers {

	private Database db;

	public DAOUsers()
	{
		db = new Database("Users");
		db.apriConnessione();
	}
	
	public List<Map<String, String>> read() {
		return db.read("select * from users");
	}
	
	public boolean create(Persona p) {
		String query = "insert into Users (nome,cognome) values (?,?)";
		return db.update( query, p.getNome(), p.getCognome() );
	}
	
	public boolean delete(int id) {
		String query = "delete from users where id = ?";
		return db.update( query, id + "");
	}
		
	public boolean update(Persona p) {
		String query = "update users set nome = ?, cognome = ? where id = ?";
		return db.update( query, p.getNome(), p.getCognome(), p.getId() + "" );
	}
	
	public List<Map<String, String>> readUserByName(String nome) {
		
		return db.read("select * from users where nome = ?", nome);
	}
	
}
