package tech.candy_dev.tournamentprogram.individual;

public class Individual {

    private final String name;
    private int score;

    public Individual(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
