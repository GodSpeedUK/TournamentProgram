package me.dan.tournamentprogram.event;

import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.gson.GsonUtil;
import me.dan.tournamentprogram.manager.Manager;
import me.dan.tournamentprogram.member.Member;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager extends Manager<Event> {

    private static final File DIRECTORY = new File(TournamentProgram.getInstance().getDataFolder(), "events");

    public static File getDirectory() {
        return DIRECTORY;
    }

    public EventManager() {
        init();
    }

    public void init() {
        if (!DIRECTORY.exists()) {
            DIRECTORY.mkdirs();
            return;
        }

        if (DIRECTORY.listFiles() == null) {
            return;
        }

        for (File file : DIRECTORY.listFiles()) {
            Event event = GsonUtil.read(DIRECTORY, file.getName(), Event.class);
            if (event == null) {
                continue;
            }

            insert(event.getId(), event);
        }
    }

    public Event getByName(String name) {
        for (Event event : getAll()) {
            if (event.getName().equalsIgnoreCase(name)) {
                return event;
            }
        }
        return null;
    }

    public boolean createEvent(String name, String type, Map<Member, Integer> map) {
        if (getByName(name) != null) {
            return false;
        }

        if (map.isEmpty()) {
            return false;
        }

        Map<Integer, Integer> memberMap = new HashMap<>();
        for (Member member : map.keySet()) {
            memberMap.put(member.getId(), map.get(member));
            member.setScore(member.getScore() + map.get(member));
        }

        Event event = new Event(getNextFreeId(), name, type, memberMap);

        insert(event.getId(), event);
        return true;
    }


}
