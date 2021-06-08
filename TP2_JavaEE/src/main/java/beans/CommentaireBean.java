package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.CommentaireDAO;
import entities.Commentaire;



@SessionScoped
@ManagedBean(name = "commentaireBean")
public class CommentaireBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Commentaire commentaire;


    public CommentaireBean() {
    	commentaire = new Commentaire();
    }

    public void creerCommentaire() {
    	CommentaireDAO commentaireDAO = new CommentaireDAO();
    	commentaireDAO.create( commentaire );
        FacesMessage message = new FacesMessage( "Le commentaire a bien été envoyé" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

    
	
	
}
