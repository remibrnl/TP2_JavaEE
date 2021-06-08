package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.CommentaireDAO;
import entities.Commentaire;


/*
 * Cette classe est la bean de la table "Commentaire" de la base de données
 */
@SessionScoped
@ManagedBean(name = "commentaireBean")
public class CommentaireBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Commentaire commentaire; //entity

    /*
     * Constructeur par défaut de la classe
     */
    public CommentaireBean() {
    	
    	//On créé un objet commentaire
    	commentaire = new Commentaire();
    }

    /*
     * Cette méthode est appelé pour ajouter un commentaire à la base de données
     */
    public void creerCommentaire() {
    	CommentaireDAO commentaireDAO = new CommentaireDAO();
    	commentaireDAO.create( commentaire );
        FacesMessage message = new FacesMessage( "Le commentaire a bien été envoyé" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }

    /*
     * Getter de l'entité Commentaire
     */
	public Commentaire getCommentaire() {
		return commentaire;
	}

	/*
     * Setter de l'entité Commentaire
     */
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

    
	
	
}
