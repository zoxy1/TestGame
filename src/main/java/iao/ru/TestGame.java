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

        for (Warrior w:firstTeam.getTeam()) {
            if(w.group == Group.privileged){

            }
        }


    }
}
