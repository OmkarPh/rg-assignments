import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPLPointsTableManager {
  private static IPLPointsTableManager instance;

  private Map<String, Integer> pointsTable;

  private IPLPointsTableManager() {
    pointsTable = new HashMap<>();
    System.out.println("Points Table Initialized");
  }

  public static IPLPointsTableManager getInstance() {
    if (instance == null) {
      instance = new IPLPointsTableManager();
    }
    return instance;
  }

  public void addGame(String teamA, String teamB, String winner) {
    // Ensure teams are in points table
    pointsTable.putIfAbsent(teamA, 0);
    pointsTable.putIfAbsent(teamB, 0);

    if (winner.equals(teamA)) {
      System.out.printf("%s won against %s%n", teamA, teamB);
      pointsTable.put(teamA, pointsTable.get(teamA) + 2);
    } else if (winner.equals(teamB)) {
      System.out.printf("%s won against %s%n", teamB, teamA);
      pointsTable.put(teamB, pointsTable.get(teamB) + 2);
    } else {
      System.out.printf("%s v %s Match drawn.%n", teamA, teamB);
      pointsTable.put(teamA, pointsTable.get(teamA) + 1);
      pointsTable.put(teamB, pointsTable.get(teamB) + 1);
    }
  }

  public void displayPoints() {
    System.out.println("\nIPL Points Table:");

    List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(pointsTable.entrySet());
    sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue())); // descending sort

    for (Map.Entry<String, Integer> entry : sortedList) {
      System.out.printf("%s: %d points%n", entry.getKey(), entry.getValue());
    }
  }

  public static void main(String[] args) {
    IPLPointsTableManager table1 = IPLPointsTableManager.getInstance();
    String csk = "CSK";
    String mi = "MI";
    String rcb = "RCB";
    String dc = "DC";

    table1.addGame(csk, mi, mi);
    table1.addGame(rcb, dc, rcb);
    table1.addGame(csk, rcb, csk);

    IPLPointsTableManager table2 = IPLPointsTableManager.getInstance();
    table2.addGame(mi, dc, mi);
    table2.addGame(dc, rcb, rcb);
    table2.addGame(csk, mi, "");

    table1.displayPoints();
  }
}
