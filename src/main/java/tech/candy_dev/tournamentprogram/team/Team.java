package tech.candy_dev.tournamentprogram.team;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private final String name;
    private int points;
    private List<String> members;

    public Team(String name){
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

}
