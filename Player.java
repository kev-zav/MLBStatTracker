public class Player {
    private String name;
    private String team;
    private double battingAverage;
    private int homeRuns;
    
    public Player(String name, String team, double battingAverage, int homeRuns) {
        this.name = name;
        this.team = team;
        this.battingAverage = battingAverage;
        this.homeRuns = homeRuns;
    }
    public String getName() {
        return name;
    }
    public String getTeam() {
        return team;
    }
    public double getBattingAverage() {
        return battingAverage;
    }
    public int getHomeRuns() {
        return homeRuns;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }
    public void setHomeRuns(int homeRuns) {
        this.homeRuns = homeRuns;
    }
}