package me.dan.tournamentprogram.individual;

import me.dan.tournamentprogram.TournamentProgram;
import me.dan.tournamentprogram.gson.GsonUtil;
import me.dan.tournamentprogram.manager.Manager;

import java.io.File;

public class IndividualManager extends Manager<Individual> {

    private final File directory;

    public IndividualManager() {
        this.directory = new File(TournamentProgram.getInstance().getDataFolder(), "individuals");
        if (!this.directory.exists()) {
            this.directory.mkdirs();
        }
        init();
    }

    private void init() {
        if (!directory.exists()) {
            return;
        }

        if (directory.listFiles() == null) {
            return;
        }

        for (File file : directory.listFiles()) {
            Individual individual = GsonUtil.read(directory, file.getName(), Individual.class);
            insert(individual.getId(), individual);
        }

    }

    public Individual getByName(String name) {
        for (Individual individual : getMap().values()) {
            if (individual.getName().equalsIgnoreCase(name)) {
                return individual;
            }
        }
        return null;
    }

    public boolean createIndividual(String name) {
        if (getByName(name) != null) {
            return false;
        }

        Individual individual = new Individual(getNextFreeId(), name);

        insert(individual.getId(), individual);
        return true;
    }

    public File getDirectory() {
        return directory;
    }
}
