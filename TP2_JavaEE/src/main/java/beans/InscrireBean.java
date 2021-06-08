package beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.MembreDAO;
import entities.Membre;


@SessionScoped
@ManagedBean(name = "inscrireBean")
public class InscrireBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Membre membre;


    // Initialisation de l'entité utilisateur
    public InscrireBean() {
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

	public Membre getMembre() {
		return membre;
	}

	public void setMembre(Membre membre) {
		this.membre = membre;
	}
	
	
}