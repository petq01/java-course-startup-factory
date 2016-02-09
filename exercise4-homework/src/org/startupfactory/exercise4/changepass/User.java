/**
 * 
 */
package org.startupfactory.exercise4.changepass;

/**
 * @author Petq
 *
 */
public class User {
	private String username, secrQuest, password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSecrQuest() {
		return secrQuest;
	}

	public void setSecrQuest(String secrQuest) {
		this.secrQuest = secrQuest;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username,String secrQuest,String password) {
		this.username=username;
		this.secrQuest=secrQuest;
		this.password=password;
	}


}
