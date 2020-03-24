package ohtu;

public class Player implements Comparable<Player> {

    private String name;
    private String team;
    private String nationality;
    private int goals;
    private int assists;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public int getPoints() {
        return goals + assists;
    }

    @Override
    public String toString() {
        return String.format("%-20s%-6s%-2d + %2d = %2d", name, team, goals, assists, getPoints());
    }

    @Override
    public int compareTo(Player o) {
        return o.getPoints() - this.getPoints();
    }

}
