package iao.ru;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Zoxy1 on 25.08.17.
 */
public class TestGame {
    public void run() {
        Russ firstTeam;
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            Elves elves = new Elves();
            elves.initTeam(1, 3, 4);
            firstTeam = elves;
        } else {
            People people = new People();
            people.initTeam(1, 3, 4);
            firstTeam = people;
        }
        Russ secondTeam;
        if (random.nextInt(2) == 0) {
            Orc orc = new Orc();
            orc.initTeam(1, 3, 4);
            secondTeam = orc;
        } else {
            UnDead unDead = new UnDead();
            unDead.initTeam(1, 3, 4);
            secondTeam = unDead;
        }
        while (firstTeam.getTeam().size() != 0 && firstTeam.getTeam().size() != 0)
            if (random.nextInt(2) == 0) {
                int firstTeamSize = firstTeam.getTeam().size();
                int secondTeamSize = firstTeam.getTeam().size();
                for (Warrior w : firstTeam.getTeam()) {
                    if (w.group == Group.privileged) {
                        if (random.nextInt(2) == 0) {
                            //secondTeam.getTeam().get(random.nextInt(secondTeamSize-1)).changeHp(w.getLossSimpleAttack());
                        } else {
                            //secondTeam.getTeam().get(random.nextInt(secondTeamSize-1)).
                        }

                    }


                }
            } else {

            }
    }

}


