package tech.candy_dev.tournamentprogram.individual;

import tech.candy_dev.tournamentprogram.manager.Manager;

public class IndividualManager extends Manager<Individual> {

     public Individual getByName(String name){
         for(Individual individual: getMap().values()){
             if(individual.getName().equalsIgnoreCase(name)){
                 return individual;
             }
         }
         return null;
     }

     public boolean createIndividual(String name){
         if(getByName(name) != null){
             return false;
         }

         Individual individual = new Individual(name);

         insert(getNextFreeId(), individual);
         return true;
     }

}
