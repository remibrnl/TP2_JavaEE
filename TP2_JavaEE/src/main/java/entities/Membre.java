package entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Cette classe est le modèle/entité de la table "Membre"
 */
@Entity
@Table(name = "membre")
public class Membre implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Mêmes attributs que dans la base de données

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMembre;
	
	@Column
	private String nom;
	
	@Column
	private String prenom;
	
	@Column
	private String email;
	
	@Column
	private String hashMdp;

	/*
	 * Constructeur par défaut de la classe
	 */
	public Membre() {
	}

	/*
	 * Constructeur de confort
	 */
	public Membre(int idMembre, String nom, String prenom, String email, String hashMdp) {
		this.idMembre = idMembre;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.hashMdp = hashMdp;
	}

	/*
	 * Getter de l'attribut idMembre
	 */
	public int getIdMembre() {
		return idMembre;
	}

	/*
	 * Setter de l'attribut idMembre
	 */
	public void setIdMembre(int idMembre) {
		this.idMembre = idMembre;
	}

	/*
	 * Getter de l'attribut nom
	 */
	public String getNom() {
		return nom;
	}

	/*
	 * Setter de l'attribut nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/*
	 * Getter de l'attribut prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/*
	 * Setter de l'attribut prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/*
	 * Getter de l'attribut email
	 */
	public String getEmail() {
		return email;
	}

	/*
	 * Setter de l'attribut email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * Getter de l'attribut hashMdp
	 */
	public String getHashMdp() {
		return hashMdp;
	}

	/*
	 * Setter de l'attribut hashMdp
	 */
	public void setHashMdp(String hashMdp) {
		this.hashMdp = hashMdp;
	}
	
	
}
