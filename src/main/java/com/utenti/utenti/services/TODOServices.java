package com.utenti.utenti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utenti.utenti.model.TODO;
import com.utenti.utenti.repository.DAOTODO;

@Service
public class TODOServices {

	@Autowired
	DAOTODO daoTodo;
	
	public List<TODO> getTODOS(){
		ArrayList<TODO> todos = new ArrayList<TODO>();
		
		List<Map<String,String>> todosMap = daoTodo.read();
		
		TODO t;
		
		for(int i = 0 ; i < todosMap.size() ; i++) {
			t = new TODO (todosMap.get(i));
			todos.add(t);
		}
		return todos;
	}
	
	public TODO getSingleTODO(int id) {
		List<Map<String,String>> todosMap = daoTodo.read();
		
		TODO t = null;
		
		for ( int i = 0 ; i < todosMap.size() ; i++ ) {
			if ( Integer.parseInt(todosMap.get(i).get("id")) == id ) {
				t = new TODO ( todosMap.get(i));
			}
		}
		return t;
	}
	
	public List<TODO> userTodos(int idUser){
		ArrayList<TODO> todos = new ArrayList<TODO>();
		
		List<Map<String,String>> todosMap = daoTodo.read();
		
		TODO t;
		
		for( int i = 0 ; i < todosMap.size() ; i++) {
			if (  Integer.parseInt(todosMap.get(i).get("id_user")) == idUser ) {
				t = new TODO (todosMap.get(i));
				todos.add(t);
			}
		}
		return todos;
	}
	
	public void createTODOUser(int idUser, TODO todo) {
		
		TODO td = new TODO(idUser, todo.getTitolo() , todo.getDescrizione());
	
		boolean esito = daoTodo.create(td) ? true : false;
		
		if(esito==true) {
			System.out.println("CREATE OK");
		}
		else {
			System.out.println("CREATE NOPE");
		}
	}
	
	public void deleteTODOUser(int id) {
		
		boolean esito = daoTodo.delete(id) ? true : false;
		
		if(esito==true) {
			System.out.println("DEL OK");
		}
		else {
			System.out.println("DEL NOPE");
		}
		
	}
	
	public void updateTODOUser(int idUser, int id, TODO todo) {
		
		TODO t = getSingleTODO(id);
		
		t.setTitolo(todo.getTitolo());
		t.setDescrizione(todo.getDescrizione());
		
		boolean esito = daoTodo.update(t) ? true : false;
		
		if(esito==true) {
			System.out.println("PUT OK");
		}
		else {
			System.out.println("PUT NOPE");
		}	
	}
	
}
