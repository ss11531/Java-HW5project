package service.impl;

import java.util.List;

import dao.impl.ConsumerDaoImpl;
import model.Consumer;
import service.ConsumerService;

public class ConsumerServiceImpl implements ConsumerService {
	private ConsumerDaoImpl consumerDaoImpl;

	public ConsumerServiceImpl() {
		this.consumerDaoImpl = new ConsumerDaoImpl();
	}

	@Override
	public void addConsumer(Consumer consumer) {
		if (consumer != null) {
			consumerDaoImpl.add(consumer);
		} else {
			System.out.println("無效的消費者資料");
		}
	}

	@Override
	public Consumer Login(String username, String password) {
		if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
			System.out.println("帳號或密碼不能為空");
			return null;
		}
		List<Consumer> consumers = consumerDaoImpl.selectUsernameAndPassword(username, password);
		if (consumers != null && !consumers.isEmpty()) {
			return consumers.get(0);
		}
		System.out.println("登入失敗，帳號或密碼錯誤");
		return null;
	}

	@Override
	public boolean isUsernameBeenUse(String username) {
		if (username == null || username.isEmpty()) {
			return false;
		}
		List<Consumer> consumers = consumerDaoImpl.selectByUsername(username);
		return consumers != null && !consumers.isEmpty();
	}

	public static void main(String[] args) {
		ConsumerServiceImpl service = new ConsumerServiceImpl();
		Consumer testConsumer = service.Login("testUser", "1234");
		System.out.println(testConsumer != null ? "登入成功" : "登入失敗");
	}
}
