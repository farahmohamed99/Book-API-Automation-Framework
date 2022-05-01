package Books;

import APIs.GetBooksLogic;
import base.BaseTests;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBooksTests extends BaseTests {

    GetBooksLogic getBooksLogic = new GetBooksLogic();

    @Test
    public void getBooks() throws JsonProcessingException {
        Response response = (Response)getBooksLogic.getResponse()[0];
        Book books[] = (Book[])getBooksLogic.getResponse()[1];

        response.then().statusCode(200);
        response.then().contentType(ContentType.JSON);
        Assert.assertTrue(books.length>0);
    }
}
