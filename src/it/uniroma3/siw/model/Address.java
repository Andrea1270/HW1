package it.uniroma3.siw.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String via;
	
	@Column(nullable = false)
	private int civico;
	
	@Column(nullable = false)
	private String comune;
	
	@Column(nullable = false)
	private int cap;
	
	@Column(nullable = false)
	private String provincia;
	
	public Address() {
		
	}
	
	public Address(Long id, String via, int civico, String comune, int cap, String provincia) {
		this.id = id;
		this.via = via;
		this.civico = civico;
		this.comune = comune;
		this.cap = cap;
		this.provincia = provincia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getCivico() {
		return civico;
	}

	public void setCivico(int civico) {
		this.civico = civico;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Address:");
        sb.append("{id=").append(id);
        sb.append(", Via='").append(via);
        sb.append(",  Civico='").append(civico);
        sb.append(",  Comune='").append(comune);
        sb.append(",  Cap='").append(cap);
        sb.append(",  Provincia='").append(provincia);
        sb.append("}\n");
        return sb.toString();
	}

}
