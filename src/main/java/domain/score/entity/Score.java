package domain.score.entity;


public class Score implements Comparable<Score> {

    private int id;
    
    private String username;
    private long score;
    private long timestamp;
    private String difficulty;
    private String mode;


    public Score(int id, String username, long score, long timestamp, String difficulty, String mode) {
        this.id = id;
        this.username = username;
        this.score = score;
        this.timestamp = timestamp;
        this.difficulty = difficulty;
        this.mode = mode;
    }

    public Score() {}


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp() {
        this.timestamp = System.currentTimeMillis();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public int compareTo(Score o) {
        if (score > o.score)
            return 1;
        else if (score < o.score)
            return -1;
        else {
            if (timestamp < o.timestamp)
                return 1;
            else if (timestamp > o.timestamp)
                return -1;
        }
        return 0;
    }
}
