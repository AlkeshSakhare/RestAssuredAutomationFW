package api.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endPoints.UserEndPoints;
import api.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class UserTest {

	public static org.apache.logging.log4j.Logger log;
	User userpayload;
	Faker faker;

	@BeforeClass
	void getFakeUser() {
		log = LogManager.getLogger();
		userpayload = new User();
		faker = new Faker(new Locale("US"));
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 8));
		userpayload.setUserStatus(1);
		userpayload.setPhone(String.valueOf(faker.phoneNumber().cellPhone()));
		log.info(userpayload.toString());
	}

	@Test(priority = 0, enabled = false)
	private void createUserTest1() {
		Header accept = new Header("Accept", ContentType.JSON.toString());
		Header contenType = new Header("Content-Type", ContentType.JSON.toString());
		List<Header> list = new ArrayList<Header>();
		list.add(accept);
		list.add(contenType);
		Headers headers = new Headers(list);
		UserEndPoints.createUser1(userpayload, headers);
	}

	@Test(priority = 1)
	void createUserTest() {
		UserEndPoints.createUser(userpayload);
	}

	@Test(priority = 2)
	void getUserTest() {
		UserEndPoints.getUser(userpayload.getUsername());
	}

	@Test(priority = 3)
	void updateUserTest() {
		log.info("Before updating Username: " + userpayload.getUsername());
		userpayload.setUsername(faker.name().username());
		log.info("After updating Username: " + userpayload.getUsername());
		UserEndPoints.updateUser(userpayload.getUsername(), userpayload);
	}

	@Test(priority = 4)
	void deleteUserTest() {
		UserEndPoints.deleteUser(userpayload.getUsername());
	}
}
