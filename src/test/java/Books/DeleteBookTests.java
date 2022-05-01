package Books;

import APIs.DeleteBookLogic;
import base.BaseTests;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DeleteBookTests extends BaseTests {

    DeleteBookLogic deleteBookLogic = new DeleteBookLogic();

    @Test(priority = 1)
    public void deleteValidBook() {
        Integer id = 1;
        Response response = deleteBookLogic.getResponse(id);
        response.then().statusCode(200);
    }

    @Test(priority = 2)
    public void deleteInvalidBook_StringId() {
        String id = "Invalid ID";
        Response response = deleteBookLogic.getResponse(id);
        response.then().statusCode(400);
    }

    @Test(priority = 3)
    public void deleteInvalidBook_NoId() {
        Response response = deleteBookLogic.getResponse();
        response.then().statusCode(405);
    }
}
