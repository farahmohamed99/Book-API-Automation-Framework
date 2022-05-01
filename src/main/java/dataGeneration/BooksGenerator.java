package dataGeneration;

import models.Book;
import org.joda.time.LocalDateTime;

import static utils.HelperFunctions.generateRandomNumber;

public class BooksGenerator {

    public static Book book;

    public static Book generateValidBook() {
        Integer id = generateRandomNumber(1, 50);
        String title = "title " + generateRandomNumber(1, 20);
        String description = "description " + generateRandomNumber(1, 20);
        Integer pageCount = generateRandomNumber(1, 20);
        String excerpt = "excerpt " + generateRandomNumber(1, 20);
        String publishDate = LocalDateTime.now().toString();
        return new Book(id, title, description, pageCount, excerpt, publishDate);
    }

    public static Book generateValidBook_NullTitleDescriptionAndExcerpt() {
        Integer id = generateRandomNumber(1, 50);
        Integer pageCount = generateRandomNumber(1, 20);
        String publishDate = LocalDateTime.now().toString();
        book = new Book(id, pageCount, publishDate);
        return book;
    }

    public static Book generateBook_InvalidId(Boolean isNull) {
        String title = "title " + generateRandomNumber(1, 20);
        String description = "description " + generateRandomNumber(1, 20);
        Integer pageCount = generateRandomNumber(1, 20);
        String excerpt = "excerpt " + generateRandomNumber(1, 20);
        String publishDate = LocalDateTime.now().toString();
        if (isNull)
            return new Book(null, title, description, pageCount, excerpt, publishDate);
        return new Book(title, description, pageCount, excerpt, publishDate);
    }

    public static Book generateBook_InvalidPageCount(Boolean isNull) {
        Integer id = generateRandomNumber(1, 50);
        String title = "title " + generateRandomNumber(1, 20);
        String description = "description " + generateRandomNumber(1, 20);
        String excerpt = "excerpt " + generateRandomNumber(1, 20);
        String publishDate = LocalDateTime.now().toString();
        if (isNull)
            return new Book(id, title, description, null, excerpt, publishDate);
        return new Book(id, title, description, excerpt, publishDate);
    }

    public static Book generateBook_InvalidPublishDate(Boolean isNull) {
        Integer id = generateRandomNumber(1, 50);
        String title = "title " + generateRandomNumber(1, 20);
        String description = "description " + generateRandomNumber(1, 20);
        Integer pageCount = generateRandomNumber(1, 20);
        String excerpt = "excerpt " + generateRandomNumber(1, 20);
        if (isNull)
            return new Book(id, title, description, pageCount, excerpt, null);
        return new Book(id, title, description, pageCount, excerpt);
    }

}
