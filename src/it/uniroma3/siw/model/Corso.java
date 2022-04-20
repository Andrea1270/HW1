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
public class Corso {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private LocalDate dataInizio;
	
	@Column(nullable = false)
	private int durataMesi;
	
	/*CARDINALITA*/
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
	private Docente docente;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List <Allievo> allievi;
	
	/*COMMENTO*/
//	In corso ho utilizzato la strategia "eager" poichè alla creazione di un instanza corso è necessario sapere
//	il docente che sostiene il relativo corso e se rendo quindi persistente un corso voglio automaticamente anche il docente persistente.
//	In corso ho utilizzato la strategia "lazy" per l'associazione con gli allievi poichè non è necessario caricare tutti gli studenti del corso
	
	
	public Corso() {
		 
	}
	
	public Corso(Long id, String nome, LocalDate dataInizio, int durataMesi) {
		 this.id = id;
		 this.nome = nome;
		 this.dataInizio = dataInizio;
		 this.durataMesi = durataMesi;
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

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getdurataMesi() {
		return durataMesi;
	}

	public void setdurataMesi(int durataMesi) {
		this.durataMesi = durataMesi;
	}
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Corso:");
        sb.append("{id=").append(id);
        sb.append(", Nome='").append(nome);
        sb.append(",  DataInizio='").append(dataInizio);
        sb.append(",  DurataMesi='").append(durataMesi);
        sb.append("}\n");
        return sb.toString();
	}
	


}
