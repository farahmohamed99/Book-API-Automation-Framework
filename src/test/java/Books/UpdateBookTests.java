package Books;

import APIs.UpdateBookLogic;
import base.BaseTests;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import models.Book;
import org.testng.annotations.Test;
import static assertions.BooksAssertion.addBookAssertion;
import static dataGeneration.BooksGenerator.generateValidBook;

public class UpdateBookTests extends BaseTests {

    UpdateBookLogic updateBookLogic = new UpdateBookLogic();

    @Test(priority = 1)
    public void updateValidBook() throws JsonProcessingException {
        Book requestBook = generateValidBook();
        Book responseBook = updateBookLogic.getResponseModel(1, requestBook);
        addBookAssertion(requestBook, responseBook);
    }

    @Test(priority = 2)
    public void updateInvalidBook_NoId(){
        Book requestBook = generateValidBook();
        Response response = updateBookLogic.getResponse(requestBook);
        response.then().statusCode(405);
    }

    @Test(priority = 3)
    public void updateInvalidBook_EmptyBook(){
        Book requestBook = new Book();
        Response response = updateBookLogic.getResponse(1, requestBook);
        response.then().statusCode(400);
    }

    @Test(priority = 4)
    public void updateInvalidBook_NoBook(){
        Response response = updateBookLogic.getResponse(1);
        response.then().statusCode(400);
    }

    @Test(priority = 5)
    public void updateInvalidBook_EmptyBody(){
        Response response = updateBookLogic.getResponse();
        response.then().statusCode(400);
    }
}
