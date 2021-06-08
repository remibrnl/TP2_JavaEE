package entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*
 * Cette classe est le modèle/entité de la table "Commentaire"
 */
@Entity
@Table(name = "commentaire")
public class Commentaire implements Serializable{

	private static final long serialVersionUID = 1L;

	//Mêmes attributs que dans la base de données
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCommentaire;
	
	@Column
	private String contenu;
	
	@Column
	private int nbLikes;
	
	@Column
	private String nomMembre;
	

	/*
	 * Constructeur par défaut de la classe
	 */
	public Commentaire() {
	}

	/*
	 * Constructeur de confort
	 */
	public Commentaire(int idCommentaire, String contenu, int nbLikes,String nomMembre) {
		this.idCommentaire = idCommentaire;
		this.contenu = contenu;
		this.nbLikes = nbLikes;
		this.nomMembre = nomMembre;
	}

	/*
	 * Getter de l'attribut idCommentaire
	 */
	public int getIdCommentaire() {
		return idCommentaire;
	}

	/*
	 * Setter de l'attribut idCommentaire
	 */
	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	/*
	 * Getter de l'attribut contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/*
	 * Setter de l'attribut contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/*
	 * Getter de l'attribut nbLikes
	 */
	public int getNbLikes() {
		return nbLikes;
	}

	/*
	 * Setter de l'attribut nbLikes
	 */
	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}

	/*
	 * Getter de l'attribut nomMembre
	 */
	public String getNomMembre() {
		return nomMembre;
	}

	/*
	 * Setter de l'attribut nomMembre
	 */
	public void setNomMembre(String nomMembre) {
		this.nomMembre = nomMembre;
	}

	
	
	
}