package com.utenti.utenti.model;

import java.util.Map;

public class TODO {
	
	private int id, idUser;
	private String titolo, descrizione;
	
	public TODO() {
		
	}	
	public TODO(int idUser, String titolo, String descrizione) {
		super();
		//this.id = id;
		this.idUser = idUser;
		this.titolo = titolo;
		this.descrizione = descrizione;
	}
	public TODO(Map<String, String> mappa) {
		if(mappa.containsKey("id"))
			setId(Integer.parseInt(mappa.get("id")));
		if(mappa.containsKey("titolo"))
			setTitolo(mappa.get("titolo"));
		if(mappa.containsKey("descrizione"))
			setDescrizione(mappa.get("descrizione"));
		if(mappa.containsKey("id_user"))
			setIdUser(Integer.parseInt(mappa.get("id_user")));
	}
	@Override
	public String toString() {
		return "TODO [id=" + id + ", idUser=" + idUser + ", titolo=" + titolo + ", descrizione=" + descrizione + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}