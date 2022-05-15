package me.dan.tournamentprogram.event;

import me.dan.tournamentprogram.gson.GsonUtil;
import me.dan.tournamentprogram.member.Member;

import java.util.List;
import java.util.Map;

public class Event {

    private final int id;
    private final String name;
    private final String type;
    private final Map<Integer, Integer> scoreMap;

    public Event(int id, String name, String type, Map<Integer, Integer> map) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.scoreMap = map;
        save();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Map<Integer, Integer> getScoreMap() {
        return scoreMap;
    }

    public void save() {
        GsonUtil.save(EventManager.getDirectory(), id + "", this);
    }

}
