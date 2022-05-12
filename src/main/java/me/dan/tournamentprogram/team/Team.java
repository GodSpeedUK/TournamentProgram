package me.dan.tournamentprogram.team;

import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.gson.GsonUtil;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private final String name;
    private int points;
    private List<String> members;
    private final int id;

    public Team(int id, String name) {
        this.id = id;
        this.name = name;
        this.members = new ArrayList<>();
        save();
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

    public int getId() {
        return id;
    }

    public void save() {
        GsonUtil.save(TournamentProgram.getInstance().getTeamManager().getTeamsDirectory(), id + "", this);
    }

}