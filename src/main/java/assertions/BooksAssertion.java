package assertions;

import models.Book;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BooksAssertion {

    public static void getBookAssertion(Book requestBook, Book responseBook) {
        Assert.assertEquals(requestBook.getId(), responseBook.getId());
        Assert.assertEquals(requestBook.getTitle(), responseBook.getTitle());
    }

    public static void addBookAssertion(Book requestBook, Book responseBook) {
        Assert.assertEquals(requestBook.getId(), responseBook.getId());
        Assert.assertEquals(requestBook.getTitle(), responseBook.getTitle());
        Assert.assertEquals(requestBook.getDescription(), responseBook.getDescription());
        Assert.assertEquals(requestBook.getPageCount(), responseBook.getPageCount());
        Assert.assertEquals(requestBook.getExcerpt(), responseBook.getExcerpt());
        publishDateAssertion(requestBook.getPublishDate(), responseBook.getPublishDate());
    }

    public static void publishDateAssertion(String PDRequest, String PDResponse) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime publishDateRequest = LocalDateTime.parse(PDRequest, formatter);
        LocalDateTime publishDateResponse = LocalDateTime.parse(PDResponse, formatter);
        Assert.assertEquals(publishDateRequest, publishDateResponse);
    }

}
