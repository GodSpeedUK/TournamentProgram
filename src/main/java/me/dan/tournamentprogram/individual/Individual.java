package me.dan.tournamentprogram.individual;

import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.gson.GsonUtil;

public class Individual {

    private final String name;
    private int score = 0;
    private final int id;

    public Individual(int id, String name) {
        this.id = id;
        this.name = name;
        save();
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

    public int getId() {
        return id;
    }

    public void save(){
        GsonUtil.save(TournamentProgram.getInstance().getIndividualManager().getDirectory(), id + "", this);
    }

}
