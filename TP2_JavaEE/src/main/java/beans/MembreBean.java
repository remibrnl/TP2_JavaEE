package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.CommentaireDAO;
import dao.MembreDAO;
import entities.Commentaire;
import entities.Membre;

/*
 * Cette classe est la bean de la table "Membre" de la base de données
 */
@SessionScoped
@ManagedBean(name = "membreBean")
public class MembreBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Membre membre;


    // Initialisation de l'entité membre
    /*
     * Constructeur par défaut de la classe
     */
    public MembreBean() {
    	membre = new Membre();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription
    public void inscrire() {
    	MembreDAO membreDAO = new MembreDAO();
        
    	try {
			membreDAO.create( membre );
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), null));
			e.printStackTrace();
		}
    	

    	FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        
    }
    
    /*
     * Cette méthode retourne la liste des membres
     */
    public List<Membre> getAllMembres() {
    	
    	List<Membre> listMembres = new ArrayList<Membre>();
    	MembreDAO membreDAO = new MembreDAO();
    	
    	try {
			listMembres = membreDAO.findAll();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), null));
			e.printStackTrace();
		}
        
        return listMembres;
    }

    /*
     * Getter de l'entité Membre
     */
	public Membre getMembre() {
		return membre;
	}

	/*
     * Setter de l'entité Membre
     */
	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	
	
}