package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Docente {
	
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
	private float partitaIva;
	
	/*CARDINALITA*/
	@OneToMany(mappedBy="docente",fetch = FetchType.LAZY)
	private List <Corso> corsi;
	
	/*COMMENTO*/
//	In docente ho utilizzato come strategia di fetch "lazy" poichè non ho bisogno di sapere tutti i corsi che un
//	professore sostiene alla creazione di un istanza docente
	
	public Docente() {
		 
	}
	
	public Docente(Long id, String nome, String cognome, LocalDate dataNascita, String luogoNascita, float partitaIva) {
		 this.id = id;
		 this.nome = nome;
		 this.cognome = cognome;
		 this.dataNascita = dataNascita;
		 this.luogoNascita = luogoNascita;
		 this.partitaIva = partitaIva;
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

	public float getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(float partitaIva) {
		this.partitaIva = partitaIva;
	}
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Docente:");
        sb.append("{id=").append(id);
        sb.append(", Nome='").append(nome);
        sb.append(", Cognome='").append(cognome);
        sb.append(",  DataDiNascita='").append(dataNascita);
        sb.append(",  LuogoDiNascita='").append(luogoNascita);
        sb.append(",  PartitaIva='").append(partitaIva);
        sb.append("}\n");
        return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
