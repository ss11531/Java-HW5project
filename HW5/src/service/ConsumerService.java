package service;

import java.util.List;
import model.Consumer;
import model.Member;

public interface ConsumerService {
	// create
	void addConsumer(Consumer consumer);

	// read
	Consumer Login(String username, String password);

	boolean isUsernameBeenUse(String username);

	// update

	// delete

}