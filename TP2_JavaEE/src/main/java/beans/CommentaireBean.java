package beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.primefaces.PrimeFaces;

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
    	commentaire.setNbLikes(0);
    	try {
			commentaireDAO.create( commentaire );
		} 
    	
    	catch (Exception e) 
    	{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), null));
			e.printStackTrace();
		}
    	
    	//On affiche un message de confirmation et on refresh la page
    	PrimeFaces.current().executeScript("window.alert('Le commentaire a bien été envoyé'); window.location.replace('livretdor.xhtml?i=2');");
        
    }
    
    /*
     * Cette méthode ajoute un like a un commentaire
     */
    public void upvote(Commentaire com) {
    	CommentaireDAO commentaireDAO = new CommentaireDAO();
    	com.setNbLikes(com.getNbLikes()+1);   
    	PrimeFaces.current().executeScript("window.alert('"+com.getNbLikes()+"');");
    	try {
			commentaireDAO.update(com);
			
		} catch (Exception e1) {
			PrimeFaces.current().executeScript("window.alert('"+e1.getMessage()+"');");
			e1.printStackTrace();
		}
    	
//    	ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
//        try {
//			ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    }
    
    /*
     * Cette méthode renvoie une liste de commentaires triés selon le nombre de likes
     */
    public List<Commentaire> getCommentairesDesc() {
    	
    	List<Commentaire> listComs = new ArrayList<Commentaire>();
    	CommentaireDAO commentaireDAO = new CommentaireDAO();
    	
    	try {
			listComs = commentaireDAO.findAllOrderByLikes();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), null));
			e.printStackTrace();
		}
        
        return listComs;
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
