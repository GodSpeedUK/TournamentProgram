package tech.candy_dev.tournamentprogram.team;

import tech.candy_dev.tournamentprogram.manager.Manager;

import java.util.List;

public class TeamManager extends Manager<Team> {

    public Team getByName(String name) {
        for (Team team : getMap().values()) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }

    public boolean createTeam(String name, List<String> members) {
        if (getByName(name) != null) {
            return false;
        }

        Team team = new Team(name);
        team.setMembers(members);
        insert(getNextFreeId(), team);
        return true;
    }


}
