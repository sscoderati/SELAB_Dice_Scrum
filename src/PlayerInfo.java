public class PlayerInfo implements Comparable<PlayerInfo>{
    String ID;
    int gameScore;

    public PlayerInfo(String id, int score) {
        this.ID = id;
        this.gameScore = score;
    }

    @Override
    public int compareTo(PlayerInfo p) {
        int oneScore = this.gameScore;
        int otherScore = p.gameScore;

        return otherScore - oneScore;
    }
}
