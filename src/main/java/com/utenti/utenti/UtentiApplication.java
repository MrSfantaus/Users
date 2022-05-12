package com.utenti.utenti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtentiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtentiApplication.class, args);
	}

	/*
	 * Giorno 1
	 * Fare:
	 * 		un servizio rest che torni lista utenti 														[ OK ]
	 * 		un servizio rest che dato il nome ritorni utente specifico (Query param o path variable)		[ OK ]
	 * 		un servizio rest che permetta l'aggiunta di utenti nuovi										[ OK ]
	 * 		un servizio rest che permetta l'eliminazione di un utente dato l'id								[ OK ]
	 * 		un servizio rest che permetta l'update <PLUS>													[ OK ]
	 * 		
	 * Giorno 2
	 * Correzioni da fare:
	 * 
	 * 	- non usare camelcase negli enpoint /users/byId -> /users/byid 
		
		- di base hai due servizi in get per andare a prendere un utente specifico. 
			Diciamo che qui hai una situazione strana dove stai prendendo la stessa risorsa ma in due modi diversi. 
			Puo succedere come cosa ma non è solita. Quindi in questo caso diciamo che l'approccio deve essere un po diverso dal solito. 
			Di base io la raggionerei piu come te la scrivo di seguito. 
			Mi aspetterei il parametro di ricerca (id o username) visto che è uno solo, come pathVariable e non come RequestParam perché mi aspetto 1 risultato. 
			Quindi per convenzione i pathVariable vengono usati quando cerco una risorsa precisa. Quindi per nome o per id. 
			Mentre i query param si usano per cercare secondo dei filtri. ES: dammi tutti gli utenti con eta superiore a 18, il quale mi torna una lista di elementi. 
			
			Quindi 
			- getById   -> /users/{userid}   -> /users/123
			- getByName -> /users/{username} -> /users/pippo
			In teoria poi visto che l'input puo essere di due tipi -> stringa o numero (int, long ecc. in base a come lo definisci nell'endpoint) dovrebbe essere 
			la libreria di spring stessa a capire su quale dei due metodi andare. Perché il dubbio che ti puo venire è, ma come fa lui a capire che "123" è un id e non una stringa? 
			Se non ricordo male dovrebbe funzionare perché lui prima prova a convertire la stringa in un numero e se ci riesce va nel controller (getById) e dopo va sulla stringa che è più generica. 
		
		- creazione utente 
			@PostMapping("/create") -> non serve specificare /create, perché una post su /users per me è una CREATE di quella risorsa (users) 
		
		- eliminazione utente 
			@PostMapping("/delete") -> @PostMapping("/userid") 
			Qui vale un po il discorso di prima. Inanzitutto sto eliminando una risorsa precisa (per id) quindi mi aspetto che il parametro te lo passo come PathVariable. 
			Inoltre non c'è bisogno di scrivere /delete perché già il tipo della chiamate (delete) è parlante 
		
		- update utente 
			@PutMapping("/update") -> @PutMapping("/{userid}")
			Stesso idendico discorso della delete
			
	
			
	 */
}
