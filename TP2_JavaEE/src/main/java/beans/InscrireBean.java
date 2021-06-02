package beans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import dao.MembreDAO;
import entities.Membre;


@SessionScoped
@ManagedBean(name = "inscrireBean")
public class InscrireBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Membre membre;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private MembreDAO membreDAO;

    // Initialisation de l'entité utilisateur
    public InscrireBean() {
    	membre = new Membre();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription
    public void inscrire() {
        membreDAO.create( membre );
        System.out.println("PTDR T KI");
        FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }

	public Membre getMembre() {
		return membre;
	}
}