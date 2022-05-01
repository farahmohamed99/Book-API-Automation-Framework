package APIs;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteBookLogic {
    String URL = "/api/v1/Books";

    public Response getResponse(Object id) {

        Response response = given()
                .header("Content-type", "application/json")
                .pathParam("id", id)
                .when()
                .delete(URL + "/{id}");
        return response;
    }

    public Response getResponse() {

        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .delete(URL);

        return response;
    }
}
