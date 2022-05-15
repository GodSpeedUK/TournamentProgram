package me.dan.tournamentprogram.team;

import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.gson.GsonUtil;
import me.dan.tournamentprogram.member.Member;

import java.util.ArrayList;
import java.util.List;

public class Team implements Member {

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

    public int getScore() {
        return points;
    }

    public void setScore(int points) {
        this.points = points;
        save();
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
        save();
    }

    public int getId() {
        return id;
    }

    public void save() {
        GsonUtil.save(TournamentProgram.getInstance().getTeamManager().getTeamsDirectory(), id + "", this);
    }

}
