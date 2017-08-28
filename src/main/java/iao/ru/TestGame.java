package iao.ru;

import org.apache.log4j.Logger;

import java.util.Random;

/**
 * Created by Zoxy1 on 25.08.17.
 */
public class TestGame {
    private static final Logger LOG = Logger.getLogger(TestGame.class);

    public void run() {
        Russ firstTeam;
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            Elves elves = new Elves();
            elves.initTeam(1, 3, 4);
            firstTeam = elves;
            LOG.info("First team is elves");
        } else {
            People people = new People();
            people.initTeam(1, 3, 4);
            firstTeam = people;
            LOG.info("First team is people");
        }
        Russ secondTeam;
        if (random.nextInt(2) == 0) {
            Orc orc = new Orc();
            orc.initTeam(1, 3, 4);
            secondTeam = orc;
            LOG.info("Second team is orc");
        } else {
            UnDead unDead = new UnDead();
            unDead.initTeam(1, 3, 4);
            secondTeam = unDead;
            LOG.info("Second team is undead");
        }

        while (firstTeam.getTeam().size() != 0 && secondTeam.getTeam().size() != 0) {
            if (random.nextInt(2) == 0) {
                int firstTeamSize = firstTeam.getTeam().size();
                int secondTeamSize = secondTeam.getTeam().size();
                for (Warrior w : firstTeam.getTeam()) {
                    if (w.getGroup() == Group.privileged) {
                        w.selectGunRandom();
                        int indexSecondTeamWarrior = random.nextInt(secondTeamSize);
                        w.attack(secondTeam.getTeam().get(indexSecondTeamWarrior), firstTeam.getTeam());
                        if (secondTeam.getTeam().get(indexSecondTeamWarrior).isDead) {
                            secondTeam.removeDeadWarrior();
                        }
                    }
                    if (w.getGroup() == Group.notPrivileged) {

                    }
                }

            } else {

            }
        }

    }
}


