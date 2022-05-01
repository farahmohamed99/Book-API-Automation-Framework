package APIs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.response.Response;
import models.Book;

import static io.restassured.RestAssured.given;

public class GetBooksLogic {
    public static ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    String URL = "/api/v1/Books";

    public Object[] getResponse() throws JsonProcessingException {

        Response response = given()
                .header("Content-type", "application/json")
                .when()
                .get(URL);

        Book book[] = mapper.readValue(response.body().asString(), Book[].class);
        return new Object[] { response,book };
    }
}
