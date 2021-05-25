package bean;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CommentaireBean {
	@Id
	private Long idCommentaire;
	
	private String contenu;
	
	private Long nbLikes;
	
	@ManyToOne
	private Long idMembre;

	public CommentaireBean(Long idCommentaire, String contenu, Long nbLikes, Long idMembre) {
		super();
		this.idCommentaire = idCommentaire;
		this.contenu = contenu;
		this.nbLikes = nbLikes;
		this.idMembre = idMembre;
	}

	public Long getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(Long idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Long getNbLikes() {
		return nbLikes;
	}

	public void setNbLikes(Long nbLikes) {
		this.nbLikes = nbLikes;
	}

	public Long getIdMembre() {
		return idMembre;
	}

	public void setIdMembre(Long idMembre) {
		this.idMembre = idMembre;
	}
	
	
}