package me.dan.tournamentprogram.team;

import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.gson.GsonUtil;
import me.dan.tournamentprogram.manager.Manager;

import java.io.File;
import java.util.List;

public class TeamManager extends Manager<Team> {

    private final File teamsDirectory;

    public TeamManager() {
        this.teamsDirectory = new File(TournamentProgram.getInstance().getDataFolder(), "teams");
        if (!this.teamsDirectory.exists()) {
            this.teamsDirectory.mkdirs();
        }
    }

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

        Team team = new Team(getNextFreeId(), name);
        team.setMembers(members);
        insert(team.getId(), team);
        return true;
    }


    private void init() {
        if (!this.teamsDirectory.exists()) {
            return;
        }

        if (this.teamsDirectory.listFiles() == null) {
            return;
        }

        for (File file : this.teamsDirectory.listFiles()) {
            Team team = GsonUtil.read(teamsDirectory, file.getName(), Team.class);
            if (team != null) {
                insert(team.getId(), team);
            }
        }
    }

    public File getTeamsDirectory() {
        return teamsDirectory;
    }
}
