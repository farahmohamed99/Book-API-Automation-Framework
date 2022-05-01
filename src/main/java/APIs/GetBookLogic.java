package APIs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Book;

import static io.restassured.RestAssured.given;

public class GetBookLogic {
    public static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    String URL = "/api/v1/Books";

    public Book getResponseModel(Object id) throws JsonProcessingException {

        Response response = given()
                .header("Content-type", "application/json")
                .pathParam("id", id)
                .when()
                .get(URL + "/{id}");
        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType(ContentType.JSON);
        return mapper.readValue(response.body().asString(), Book.class);
    }

    public Response getResponse(Object id){

        Response response = given()
                .header("Content-type", "application/json")
                .pathParam("id", id)
                .when()
                .get(URL + "/{id}");

        return response;
    }
}
