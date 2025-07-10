
public class IPLTeam {
  private String teamName;
  private int points;

  public IPLTeam(String name) {
    this.teamName = name;
    this.points = 0;
  }

  public String getTeamName() {
    return teamName;
  }

  public int getPoints() {
    return points;
  }

  public void addPoints(int p) {
    if (p >= 0) this.points += p;
  }

  public static void main(String[] args) {
    IPLTeam team1 = new IPLTeam("CSK");
    IPLTeam team2 = new IPLTeam("MI");

    team1.addPoints(2);
    team2.addPoints(3);

    System.out.printf("%s has %d points%n", team1.getTeamName(), team1.getPoints());
    System.out.printf("%s has %d points%n", team2.getTeamName(), team2.getPoints());
  }
}
