package dataProviders;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.Book;
import org.testng.annotations.DataProvider;
import utils.PropsFile;
import java.io.File;
import java.io.IOException;
import java.util.*;
import static dataGeneration.BooksGenerator.generateValidBook;

public class BooksDataProvider {

    @DataProvider(name = "GetValidBookDataProvider")
    public Iterator<Object[]> GetValidBookDataProvider() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Object b1 = mapper.readValue(new File((PropsFile.getPropValue(PropsFile.Paths.book1))), Book.class);

        mapper = new ObjectMapper();
        Object b2 = mapper.readValue(new File((PropsFile.getPropValue(PropsFile.Paths.book2))), Book.class);

        mapper = new ObjectMapper();
        Object b3 = mapper.readValue(new File((PropsFile.getPropValue(PropsFile.Paths.book3))), Book.class);

        Map<String, Object> book1 = new HashMap<>();
        book1.put("ValidBook", b1);

        Map<String, Object> book2 = new HashMap<>();
        book2.put("ValidBook", b2);

        Map<String, Object> book3 = new HashMap<>();
        book3.put("ValidBook", b3);

        Collection<Object[]> booksDataProvided = new ArrayList<>();
        booksDataProvided.add(new Object[]{book1});
        booksDataProvided.add(new Object[]{book2});
        booksDataProvided.add(new Object[]{book3});

        return booksDataProvided.iterator();
    }

    @DataProvider(name = "AddValidBooksDataProvider")
    public Iterator<Object[]> AddValidBooksDataProvider() {
        Map<String, Object> book1 = new HashMap<>();
        book1.put("ValidBook", generateValidBook());

        Map<String, Object> book2 = new HashMap<>();
        book2.put("ValidBook", generateValidBook());

        Map<String, Object> book3 = new HashMap<>();
        book3.put("ValidBook", generateValidBook());

        Collection<Object[]> booksDataProvided = new ArrayList<>();
        booksDataProvided.add(new Object[]{book1});
        booksDataProvided.add(new Object[]{book2});
        booksDataProvided.add(new Object[]{book3});

        return booksDataProvided.iterator();
    }
}
