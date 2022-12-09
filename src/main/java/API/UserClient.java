package API;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_ACCEPTED;

public class UserClient {

    private String BASE_URL = "https://stellarburgers.nomoreparties.site";

    @Step("Delete user")
    public void deleteUser(String email, String password) {
        ValidatableResponse response = given()
                .header("Content-type", "application/json")
                .header("authorization", loginUser(email, password))
                .when()
                .delete(BASE_URL + "/api/auth/user")
                .then().statusCode(SC_ACCEPTED);
        System.out.println(response.extract().path("message").toString());
    }

    public String loginUser(String email, String password) {
        User user = new User(email, password);
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(BASE_URL + "/api/auth/login")
                .then().extract().path("accessToken");
    }

    @Step("Register user")
    public void registerUser(String email, String password, String name) {
        UserFullData user = new UserFullData(email, password, name);
        given()
                .header("Content-type", "application/json")
                .body(user)
                .when()
                .post(BASE_URL + "/api/auth/register")
                .then();
    }
}
