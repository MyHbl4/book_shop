package com.moon.senla;

import com.moon.senla.entity.Book;
import java.util.List;

public interface BookService {

    Book findBookById(int id);

    void addBook(Book book);

    void removeBook(int id);

    boolean checkBookInRequests(Book book);

    boolean checkBookInOrders(Book book);

    void removeBookRequest(Book book);

    List<Book> sortBookByAvailability();

    List<Book> sortBookByPrice();

    List<Book> sortBookByPublication();

    List<Book> sortBookByTitle();

    void checkOrder();

    void create(Book entity);

    Book read(int id);

    List<Book> readAll();

    void update(Book entity);

    void delete(Book entity);
}
