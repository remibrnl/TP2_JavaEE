package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Membre {
	
	@Id
	private Long idMembre;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String hashMdp;

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
