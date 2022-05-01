package Books;

import APIs.AddBookLogic;
import base.BaseTests;
import com.fasterxml.jackson.core.JsonProcessingException;
import dataProviders.BooksDataProvider;
import io.restassured.response.Response;
import models.Book;
import org.testng.annotations.Test;
import java.util.Map;
import static assertions.BooksAssertion.addBookAssertion;
import static dataGeneration.BooksGenerator.*;

public class AddBookTests extends BaseTests {

    AddBookLogic addBookLogic = new AddBookLogic();
    Boolean isNull;

    @Test(dataProvider = "AddValidBooksDataProvider", dataProviderClass = BooksDataProvider.class, priority = 1)
    public void addValidBook(Map<String, Object> books) throws JsonProcessingException {
        Book requestBook = (Book) books.get("ValidBook");
        Book responseBook = addBookLogic.getResponseModel(requestBook);
        addBookAssertion(requestBook, responseBook);
    }

    @Test(priority = 2)
    public void addValidBook_NullTitleDescriptionAndExcerpt() throws JsonProcessingException {
        Book requestBook = generateValidBook_NullTitleDescriptionAndExcerpt();
        Book responseBook = addBookLogic.getResponseModel(requestBook);
        addBookAssertion(requestBook, responseBook);
    }

    @Test(priority = 3)
    public void addInvalidBook_NoId(){
        isNull = false;
        Book requestBook = generateBook_InvalidId(isNull);
        Response response = addBookLogic.getResponse(requestBook);
        response.then().statusCode(400);
    }

    @Test(priority = 4)
    public void addInvalidBook_NullId(){
        isNull = true;
        Book requestBook = generateBook_InvalidId(isNull);
        Response response = addBookLogic.getResponse(requestBook);
        response.then().statusCode(400);
    }

    @Test(priority = 5)
    public void addInvalidBook_NoPageCount(){
        isNull = false;
        Book requestBook = generateBook_InvalidPageCount(isNull);
        Response response = addBookLogic.getResponse(requestBook);
        response.then().statusCode(400);
    }

    @Test(priority = 6)
    public void addInvalidBook_NullPageCount(){
        isNull = true;
        Book requestBook = generateBook_InvalidPageCount(isNull);
        Response response = addBookLogic.getResponse(requestBook);
        response.then().statusCode(400);
    }

    @Test(priority = 7)
    public void addInvalidBook_NoPublishDate(){
        isNull = false;
        Book requestBook = generateBook_InvalidPublishDate(isNull);
        Response response = addBookLogic.getResponse(requestBook);
        response.then().statusCode(400);
    }

    @Test(priority = 8)
    public void addInvalidBook_NullPublishDate(){
        isNull = true;
        Book requestBook = generateBook_InvalidPublishDate(isNull);
        Response response = addBookLogic.getResponse(requestBook);
        response.then().statusCode(400);
    }

    @Test(priority = 9)
    public void addInvalidBook_EmptyBody(){
        Response response = addBookLogic.getResponse();
        response.then().statusCode(400);
    }
}
