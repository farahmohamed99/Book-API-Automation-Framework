package Books;

import APIs.GetBookLogic;
import base.BaseTests;
import com.fasterxml.jackson.core.JsonProcessingException;
import dataProviders.BooksDataProvider;
import io.restassured.response.Response;
import models.Book;
import org.testng.annotations.Test;
import java.util.Map;
import static assertions.BooksAssertion.getBookAssertion;

public class GetBookTests extends BaseTests {

    GetBookLogic getBookLogic = new GetBookLogic();

    @Test(dataProvider = "GetValidBookDataProvider", dataProviderClass = BooksDataProvider.class, priority = 1)
    public void getValidBook(Map<String, Object> books) throws JsonProcessingException {
        Book requestBook = (Book) books.get("ValidBook");
        Book responseBook = getBookLogic.getResponseModel(requestBook.getId());
        getBookAssertion(requestBook, responseBook);
    }

    @Test(priority = 2)
    public void deleteInvalidBook_StringId() throws JsonProcessingException {
        String id = "Invalid ID";
        Response response = getBookLogic.getResponse(id);
        response.then().statusCode(400);
    }
}
