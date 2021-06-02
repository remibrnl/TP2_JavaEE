package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "membre")
public class Membre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembre;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String email;
	
	@Column
	private String hashMdp;

	
	public Membre() {
		super();
	}

	public Membre(Long idMembre, String nom, String prenom, String email, String hashMdp) {
		super();
		this.idMembre = idMembre;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.hashMdp = hashMdp;
	}

	public Long getIdMembre() {
		return idMembre;
	}

	public void setIdMembre(Long idMembre) {
		this.idMembre = idMembre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHashMdp() {
		return hashMdp;
	}

	public void setHashMdp(String hashMdp) {
		this.hashMdp = hashMdp;
	}
	
	
}
