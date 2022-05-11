package com.utenti.utenti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtentiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtentiApplication.class, args);
	}

	/*
	 * Fare:
	 * 		un servizio rest che torni lista utenti 														[ OK ]
	 * 		un servizio rest che dato il nome ritorni utente specifico (Query param o path variable)		[ OK ]
	 * 		un servizio rest che permetta l'aggiunta di utenti nuovi										[ OK ]
	 * 		un servizio rest che permetta l'eliminazione di un utente dato l'id								[ OK ]
	 * 		un servizio rest che permetta l'update <PLUS>													[ OK ]
	 * 		
	 * 
	 */
}
