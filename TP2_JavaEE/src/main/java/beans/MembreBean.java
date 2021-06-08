package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.MembreDAO;
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
        membreDAO.create( membre );
        FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
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