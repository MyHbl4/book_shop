package com.moon.senla;

import com.moon.senla.entity.Book;
import com.moon.senla.entity.Request;
import com.moon.senla.impl.BookDao;
import com.moon.senla.impl.OrderDao;
import com.moon.senla.impl.RequestDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Runner {
  private static final Logger logger = LoggerFactory.getLogger(Runner.class);

  public static void main(String[] args) {
    OrderDao order = new OrderDao();
    BookDao book = new BookDao();
    RequestDao request = new RequestDao();

    //    book.create(new Book("Romeo", "Gottfried Whimper", 100, 1918));
    //    book.create(new Book("Juliet", "Gottfried Whimper", 200, 1918));
    //    book.create(new Book("Romeo and Juliet", "Gottfried Whimper", 300, 1918));
        Book book1 = book.read(1);
    //    Book book2 = book.read(2);
    //    Book book3 = book.read(3);
    //    List<Book> books = new ArrayList<>();
    //    List<Book> books2 = new ArrayList<>();
    //    books.add(book1);
    //    books.add(book2);
    //    books2.add(book3);
    //    books2.add(book1);
    //    System.out.println(books);
    //    System.out.println(books2);
    //    order.create(new Order("Mark", books));
    //    order.create(new Order("Lydia", books2));
    request.create(new Request(book1));

    //    BookDao book = new BookDao();
    //    List<Book> books = book.readAll();
    //    for(Book b:books){
    //      System.out.println(b.getTitle());
    //    }

    //    new LoggerProperty();
    //    MenuController menuController =
    // ObjectFactory.getInstance().createObject(MenuController.class);
    //    menuController.run();
    //    logger.info("The program is closed");

    //    CreateDB create = new CreateDB();
    //    create.create();

    //    Transaction transaction = null;
    //    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    //      Book book =
    //          new Book(
    //              "Romeo and Juliet5",
    //              "Gottfried Whimper",
    //              174,
    //              1918);
    //      transaction = session.beginTransaction();
    //      session.save(book);
    //      transaction.commit();
    //    } catch (Exception e) {
    //      if (transaction != null) {
    //        transaction.rollback();
    //      }
    //      e.printStackTrace();
    //    }

    //        BookDao book = new BookDao();
    //    //    book.create(new Book("test", "author", 200, 2000));
    //    book.delete(book.read(9));
    //    List<Book> books = book.readAll();
    //    for(Book b:books){
    //      System.out.println(b);
    //    }
    //    System.out.println(book.read(1));

    //    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
    //      Order order =
    //              new Order("vasya"
    //                      );
    //      transaction = session.beginTransaction();
    //      session.save(order);
    //      transaction.commit();
    //    } catch (Exception e) {
    //      if (transaction != null) {
    //        transaction.rollback();
    //      }
    //      e.printStackTrace();
    //    }
  }
}
