package com.utenti.utenti.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.utenti.utenti.model.TODO;

@Repository
public class DAOTODO {
	private Database db;
	
	public DAOTODO() {
		db = new Database("Users");
		db.apriConnessione();
	}
	
	public List<Map<String,String>> read(){
		return db.read("select * from todos");
	}
	
	public boolean create(TODO t) {
		String query = "insert into todos (titolo,descrizione,id_user) values (?,?,?)";
		return db.update(query, t.getTitolo(), t.getDescrizione(), t.getIdUser()+"");
	}
	
	public boolean delete (int id) {
		String query = "delete from todos where id = ?";
		return db.update(query, id+"");
	}
	
	public boolean update(TODO t) {
		String query = "update todos set titolo = ?, descrizione = ?, id_user = ? where id = ?";
		return db.update(query, t.getTitolo(), t.getDescrizione(), t.getIdUser()+"", t.getId()+"");
	}
	
	
}