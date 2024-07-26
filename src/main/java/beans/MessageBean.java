package beans;

import java.io.Serializable;

public class MessageBean implements Serializable {

	private static final long serialVersionUID = 967331115079287588L;
	private	Integer id;
    private String content;
    private Boolean seen;
    private String recipientMail;

	
	public MessageBean() {
		// TODO Auto-generated constructor stub
	}


	public MessageBean(Integer id, String content, Boolean seen, String recipientMail) {
		super();
		this.id = id;
		this.content = content;
		this.seen = seen;
		this.recipientMail = recipientMail;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Boolean getSeen() {
		return seen;
	}


	public void setSeen(Boolean seen) {
		this.seen = seen;
	}


	public String getRecipientMail() {
		return recipientMail;
	}


	public void setRecipientMail(String recipientMail) {
		this.recipientMail = recipientMail;
	}
	

}
