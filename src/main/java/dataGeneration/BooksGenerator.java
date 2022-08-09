package dataGeneration;

import models.Book;
import org.joda.time.LocalDateTime;

import static utils.HelperFunctions.generateRandomNumber;

public class BooksGenerator {

    public static Book generateValidBook() {
        return Book.builder()
                .id(generateRandomNumber(1, 50))
                .title("title " + generateRandomNumber(1, 20))
                .description("description " + generateRandomNumber(1, 20))
                .pageCount(generateRandomNumber(1, 20))
                .excerpt("excerpt " + generateRandomNumber(1, 20))
                .publishDate(LocalDateTime.now().toString())
                .build();
    }

    public static Book generateValidBook_NullTitleDescriptionAndExcerpt() {
        return Book.builder()
                .id(generateRandomNumber(1, 50))
                .pageCount(generateRandomNumber(1, 20))
                .publishDate(LocalDateTime.now().toString())
                .build();
    }

    public static Book generateBook_InvalidId(Boolean isNull) {
        if (isNull)
            return Book.builder()
                    .id(generateRandomNumber(1, 50))
                    .title("title " + generateRandomNumber(1, 20))
                    .description("description " + generateRandomNumber(1, 20))
                    .pageCount(null)
                    .excerpt("excerpt " + generateRandomNumber(1, 20))
                    .publishDate(LocalDateTime.now().toString())
                    .build();
        return Book.builder()
                .id(generateRandomNumber(1, 50))
                .title("title " + generateRandomNumber(1, 20))
                .description("description " + generateRandomNumber(1, 20))
                .excerpt("excerpt " + generateRandomNumber(1, 20))
                .publishDate(LocalDateTime.now().toString())
                .build();
    }

    public static Book generateBook_InvalidPageCount(Boolean isNull) {
        if (isNull)
            return Book.builder()
                    .id(null)
                    .title("title " + generateRandomNumber(1, 20))
                    .description("description " + generateRandomNumber(1, 20))
                    .pageCount(generateRandomNumber(1, 20))
                    .excerpt("excerpt " + generateRandomNumber(1, 20))
                    .publishDate(LocalDateTime.now().toString())
                    .build();
        return Book.builder()
                .title("title " + generateRandomNumber(1, 20))
                .description("description " + generateRandomNumber(1, 20))
                .pageCount(generateRandomNumber(1, 20))
                .excerpt("excerpt " + generateRandomNumber(1, 20))
                .publishDate(LocalDateTime.now().toString())
                .build();
    }

    public static Book generateBook_InvalidPublishDate(Boolean isNull) {
        if (isNull)
            return Book.builder()
                    .id(generateRandomNumber(1, 50))
                    .title("title " + generateRandomNumber(1, 20))
                    .description("description " + generateRandomNumber(1, 20))
                    .pageCount(generateRandomNumber(1, 20))
                    .excerpt("excerpt " + generateRandomNumber(1, 20))
                    .publishDate(null)
                    .build();
        return Book.builder()
                .id(generateRandomNumber(1, 50))
                .title("title " + generateRandomNumber(1, 20))
                .description("description " + generateRandomNumber(1, 20))
                .pageCount(generateRandomNumber(1, 20))
                .excerpt("excerpt " + generateRandomNumber(1, 20))
                .build();
    }

}
