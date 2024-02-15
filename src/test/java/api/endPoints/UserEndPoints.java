package api.endPoints;

import static api.test.UserTest.log;
import static io.restassured.RestAssured.given;

import api.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;


public class UserEndPoints {


    public static Response createUser(User payload) {
		log.info("Creating user");
        return given()
                .baseUri(EndPointsURL.BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(payload)
                .log()
                .all()
                .when()
                .post(EndPointsURL.CREATE_USER);
    }

    public static Response createUser1(User payload, Headers headers) {
		log.info("Creating user");
        return given()
        		.baseUri(EndPointsURL.BASE_URL)
                .headers(headers)
                .body(payload)
                .log()
                .all()
                .when()
                .post(EndPointsURL.CREATE_USER);
    }


    public static Response getUser(String userName) {
		log.info("Getting user");
        return given()
                .baseUri(EndPointsURL.BASE_URL)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .log()
                .all()
                .when()
                .get(EndPointsURL.GET_USER);


    }


    public static Response updateUser(String userName, User payload) {
		log.info("Updating user");
        return given()
                .baseUri(EndPointsURL.BASE_URL)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .log()
                .all()
                .when()
                .put(EndPointsURL.UPDATE_USER);
    }


    public static Response deleteUser(String userName) {
		log.info("Deleting user");
        return given()
                .baseUri(EndPointsURL.BASE_URL)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .log()
                .all()
                .when()
                .delete(EndPointsURL.DELETE_USER);

    }

}