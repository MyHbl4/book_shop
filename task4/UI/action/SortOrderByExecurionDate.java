package task4.UI.action;

public class SortOrderByExecurionDate extends CreateManager implements IAction {

  @Override
  public void execute() {
    manager.sortOrderByExecutionDate();
  }
}