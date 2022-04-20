package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Allievo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private LocalDate dataNascita;
	
	@Column(nullable = false)
	private String luogoNascita;
	
	@Column(nullable = false)
	private int matricola;
	
	@Column(nullable = false)
	private String email;
	
	/*CARDINALITA*/
	@ManyToMany(fetch = FetchType.LAZY)
	private List <Corso> corsi;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	private Società società;
	
	/*COMMENTO*/
//	In allievo ho utilizzato la strategia "lazy" con corso poichè non è necessario caricare tutti i corsi seguiti da una studente, sarebbe troppo
//	dispendioso a differenza dell'associazione con la società che avrà strategia "eager" perchè il caricamento della singola società non è dispendioso
// 	e per lo stesso motivo ho utilizzato come strategia di cascade "persist"
	
	public Allievo() {
		
	}
	
	public Allievo(Long id, String nome, String cognome, LocalDate dataNascita, String luogoNascita, int matricola, String email) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.luogoNascita = luogoNascita;
		this.matricola = matricola;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(LocalDate dataNascita) {
		this.dataNascita = dataNascita;
	}

	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setLuogoNascita(String luogoNascita) {
		this.luogoNascita = luogoNascita;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Allievo:");
        sb.append("{id=").append(id);
        sb.append(", Nome='").append(nome);
        sb.append(", Cognome='").append(cognome);
        sb.append(", DataDiNascita='").append(dataNascita);
        sb.append(", LuogoNascita='").append(luogoNascita);
        sb.append(", Matricola='").append(matricola);
        sb.append(", Email='").append(email);
        sb.append("}\n");
        return sb.toString();
	}
}
