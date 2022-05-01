package APIs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Book;

import static io.restassured.RestAssured.given;

public class UpdateBookLogic {
    public static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    String URL = "/api/v1/Books";

    public Book getResponseModel(Integer id, Book book) throws JsonProcessingException {

        book.setId(id);
        Response response = given()
                .header("Content-type", "application/json")
                .pathParam("id", id)
                .body(book)
                .when()
                .put(URL + "/{id}");

        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType(ContentType.JSON);
        return mapper.readValue(response.body().asString(), Book.class);
    }

    public Response getResponse(Integer id, Book book){

        Response response = given()
                .header("Content-type", "application/json")
                .pathParam("id", id)
                .body(book)
                .when()
                .put(URL + "/{id}");

        return response;
    }

    public Response getResponse(Integer id){
        Response response = given()
                .header("Content-type", "application/json")
                .pathParam("id", id)
                .when()
                .put(URL + "/{id}");

        return response;
    }

    public Response getResponse(Book book){

        Response response = given()
                .header("Content-type", "application/json")
                .body(book)
                .when()
                .put(URL);

        return response;
    }

    public Response getResponse(){

        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .post(URL);

        return response;
    }
}
