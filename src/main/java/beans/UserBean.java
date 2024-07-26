package beans;

import java.io.Serializable;
import java.util.Objects;

public class UserBean implements Serializable {
	
	private static final long serialVersionUID = 5022669426687458041L;
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private boolean loggedIn = false;
	
	public UserBean(Integer id, String firstName, String lastName, String username, String password) {
        super();
        this.setId(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
	

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public UserBean() {
		// TODO Auto-generated constructor stub
	}


	public boolean isLoggedIn() {
		return loggedIn;
	}


	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}


	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, password, username);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return this.username + this.password + "," + this.firstName + "," + this.lastName;
	}

}
