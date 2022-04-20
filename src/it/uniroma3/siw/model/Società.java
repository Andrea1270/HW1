package it.uniroma3.siw.model;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Società {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String ragioneSociale;

	@Column(nullable = false)
	private int numeroTelefono;
	
	/*CARDINALITA*/
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	private Address indirizzo;
	
	/*COMMENTO*/
//	In società ho utilizzato come strategia "eager" poichè il caricamento dell'indirizzo e necessario per la società ed inoltre non sarebbe 
// 	dispensioso farlo essendo un singolo indirizzo. Ho utilizzato come strategia di cascade "persist" e "remove" poichè alla creazione di un
//	istanza di società è necessario avere un indirizzo relativo a quest'ultima ed è altrettanto necessario eliminarlo se viene eliminata l'istanza della società
	
	public Società() {
		
	}
	
	public Società(Long id,String ragioneSociale, int numeroTelefono) {
		this.ragioneSociale = ragioneSociale;
		this.id = id;
		this.numeroTelefono = numeroTelefono;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	
	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Societa:");
        sb.append("{id=").append(id);
        sb.append(", RagioneSociale='").append(ragioneSociale);
        sb.append(", NumTelefono='").append(numeroTelefono);
        return sb.toString();
	}

}
