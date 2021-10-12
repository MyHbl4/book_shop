package task4.service.impl;

import static task4.util.Constant.FILE_REQUESTS;
import static task4.util.Constant.FILE_REQUESTS1;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import task4.DI.injector.BeanFactory;
import task4.model.Request;
import task4.repository.RequestRepository;
import task4.repository.impl.RequestRepositoryImpl;
import task4.service.RequestService;

public class RequestServiceImpl implements RequestService {
  private final RequestRepository requestRepository =
      BeanFactory.getInstance().getBean(RequestRepositoryImpl.class);

  @Override
  public List<Request> getAll() {
    return requestRepository.getAll();
  }

  @Override
  public void addRequest(long bookId) {
    requestRepository.addRequest(bookId);
  }

  @Override
  public List<Request> sortRequestByCount() {
    List<Request> sortRequests = requestRepository.getAll();
    requestRepository.getAll().sort(Comparator.comparingInt(Request::getCount));
    return sortRequests;
  }

  @Override
  public List<Request> sortRequestByTitle() {
    List<Request> sortRequests = requestRepository.getAll();
    requestRepository.getAll().sort(Comparator.comparing(Request::getTitle));
    return sortRequests;
  }

  @Override
  public void writerRequestBd() {
    ObjectMapper mapper = new ObjectMapper();
    try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_REQUESTS)))) {
      List<Request> requests = getAll();
      String requestJson = mapper.writeValueAsString(requests);
      writer.write(requestJson);
      writer.flush();
    } catch (IOException e) {
      System.out.println("Writing requests error");
    }
  }

  @Override
  public void readRequestBd() {
    ObjectMapper mapper = new ObjectMapper();
    List<Request> requests;
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_REQUESTS))) {
      String requestJson;
      requestRepository.getAll().clear();
      while ((requestJson = reader.readLine()) != null) {
        requests = Arrays.asList(mapper.readValue(requestJson, Request[].class));
        for (Request request : requests) {
          getAll().add(request);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

//  @Override
//  public void updateRequestCsv() {
//    try {
//      PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(FILE_REQUESTS1)));
//      for (Request request : requestRepository.getAll()) {
//        writer.println(request.getId() + "|" + request.getCount() + "|" + request.getTitle());
//      }
//      writer.flush();
//      writer.close();
//    } catch (IOException e) {
//      e.printStackTrace();
//    }
//  }
//
//  @Override
//  public void downloadRequestCsv() {
//    try {
//      try (BufferedReader reader = new BufferedReader(new FileReader(FILE_REQUESTS1))) {
//        String someRequest;
//        requestRepository.getAll().clear();
//        while ((someRequest = reader.readLine()) != null) {
//          String[] values = someRequest.split("\\|");
//          requestRepository
//              .getAll()
//              .add(
//                  new Request(
//                      Long.parseLong(values[0]),
//                      Integer.parseInt(values[1]),
//                      Long.parseLong(values[2])));
//        }
//      }
//    } catch (IOException e) {
//      System.out.println("Loading error");
//    }
//  }
}
