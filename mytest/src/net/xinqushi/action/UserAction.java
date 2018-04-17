package net.xinqushi.action;

import net.xinqushi.dao.UserDAO;
import net.xinqushi.model.User;

public class UserAction {
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	UserDAO dao=new UserDAO();
	public String add() {
		System.out.println("UserAction.add()");
		dao.save(user);
		return "main";
	}
}
