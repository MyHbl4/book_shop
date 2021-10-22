package task4.repository.impl;

import java.util.List;
import task4.DI.annotations.InjectByType;
import task4.datasource.OrderDataSource;
import task4.enums.Availability;
import task4.model.Book;
import task4.model.Order;
import task4.repository.OrderRepository;

public class OrderRepositoryImpl implements OrderRepository {
  @InjectByType private OrderDataSource orderDataSource;

  @Override
  public List<Order> getAll() {
    return orderDataSource.getOrders();
  }

  @Override
  public Order findOrderById(int id) {
    return orderDataSource.findOrderById(id);
  }

  @Override
  public boolean checkBooksInOrder(Order order) {
    boolean availability = true;
    for (Book book : order.getBooks()) {
      if (book.getAvailability().equals(Availability.OUT_OF_STOCK)) {
        availability = false;
      }
    }
    return availability;
  }
}
