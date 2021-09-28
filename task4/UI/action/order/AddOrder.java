package task4.UI.action.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import task4.UI.action.CreateManager;
import task4.UI.action.IAction;
import task4.exception.CheckOfData;
import task4.exception.CustomException;
import task4.exception.CustomScanner;
import task4.model.Book;
import task4.model.Order;

public class AddOrder extends CreateManager implements IAction {
  private CheckOfData checkOfData;
  private CustomScanner customScanner;

  public AddOrder(CheckOfData checkOfData, CustomScanner customScanner) {
    this.checkOfData = checkOfData;
    this.customScanner = customScanner;
  }

  @Override
  public void execute() {
    String customerName;
    int amount;
    int id;
    List<Book> books = new ArrayList<>();
    System.out.println("Enter the customer's name");
    customerName = customScanner.getString();
    System.out.println("Enter the number of books you want to buy");
    amount = customScanner.getInt();
    for (int i = 0; i < amount; i++) {
      System.out.println("Enter ID of the book you want to buy");
      boolean isValid = true;
      while (isValid) {
        try {
          id = customScanner.getInt();
          checkOfData.checkBook(id);
          books.add(manager.findBookById(id));
          manager.addOrder(new Order(customerName, books));
          manager.updateOrderCsv();
          if (i == amount - 1) {
            System.out.println("Order has been added");
          }
          isValid = false;
        } catch (CustomException e) {
          System.out.println(" Value is incorrect");
        }
      }
    }
  }
}
