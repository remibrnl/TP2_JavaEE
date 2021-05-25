package bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MembreBean {
	
	@Id
	private Long idMembre;
	
	private String nom;
	
	private String prenom;
	
	private String email;
	
	private String hashMdp;
}
