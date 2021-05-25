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
	

}
