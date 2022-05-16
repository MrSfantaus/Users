package com.utenti.utenti.model;

import java.util.Map;

public class Persona {

	private int id;
	private String nome, cognome;
	private TODO[] todo;

	// Costruttore da Mappe
	public Persona(Map<String,String> mappa) {		
		if(mappa.containsKey("id"))
			setId(Integer.parseInt(mappa.get("id")));
		if(mappa.containsKey("nome"))
			setNome(mappa.get("nome"));
		if(mappa.containsKey("cognome"))
			setCognome(mappa.get("cognome"));
	}	
	// Costruttore con Nome/Cognome
	public Persona(String nome, String cognome) {
		setNome(nome);
		setCognome(cognome);
	}	
	@Override
	public String toString() {
		return "Persona [id= " + id + "nome=" + nome + ", cognome=" + cognome + "]";
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public TODO[] getTodo() {
		return todo;
	}
	public void setTodo(TODO[] todo) {
		this.todo = todo;
	}

}
