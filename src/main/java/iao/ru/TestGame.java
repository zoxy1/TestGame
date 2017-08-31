package iao.ru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Zoxy1 on 25.08.17.
 */
public class TestGame {
    private static Logger log = LogManager.getLogger(TestGame.class);

    protected Russ selectRandomFirstTeam() {
        Russ firstTeam;
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            Elves elves = new Elves();
            elves.initTeam(1, 3, 4);
            firstTeam = elves;
            firstTeam.setSelectedRuss(RussType.elf);
        } else {
            People people = new People();
            people.initTeam(1, 3, 4);
            firstTeam = people;
            firstTeam.setSelectedRuss(RussType.people);
        }
        return firstTeam;
    }

    private Russ selectRandomSecondTeam() {
        Russ secondTeam;
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            Orc orc = new Orc();
            orc.initTeam(1, 3, 4);
            secondTeam = orc;
            secondTeam.setSelectedRuss(RussType.orc);
        } else {
            UnDead unDead = new UnDead();
            unDead.initTeam(1, 3, 4);
            secondTeam = unDead;
            secondTeam.setSelectedRuss(RussType.undead);
        }
        return secondTeam;
    }

    private void attackWarriors(List<Integer> warriors, Russ attackRuss, Russ opponentRuss) {
        Random random = new Random();
        while (warriors.size() != 0) {
            int opponentTeamSize = opponentRuss.getTeam().size();
            if (opponentTeamSize > 0) {
                int indexRandomAttackWarrior = random.nextInt(warriors.size());
                Warrior warriorAttack = attackRuss.getTeam().get(warriors.get(indexRandomAttackWarrior));
                warriorAttack.selectGunRandom();
                int indexRandomOpponentWarrior = random.nextInt(opponentTeamSize);
                Warrior warriorOpponent = opponentRuss.getTeam().get(indexRandomOpponentWarrior);
                warriorAttack.attack(warriorOpponent, attackRuss.getTeam());
                opponentRuss.removeDeadWarrior();
                warriors.remove(indexRandomAttackWarrior);
            } else {
                break;
            }
        }
    }

    private void oneAttackTeamToTeam(Russ attackRuss, Russ opponentRuss) {
        List<Integer> privilegedWarriors = new ArrayList<>();
        List<Integer> notPrivilegedWarriors = new ArrayList<>();

        for (int i = 0; i < attackRuss.getTeam().size(); i++) {
            if (attackRuss.getTeam().get(i).getGroup() == Group.privileged) {
                privilegedWarriors.add(i);
            }
            if (attackRuss.getTeam().get(i).getGroup() == Group.notPrivileged) {
                notPrivilegedWarriors.add(i);
            }
        }
        attackWarriors(privilegedWarriors, attackRuss, opponentRuss);
        attackWarriors(notPrivilegedWarriors, attackRuss, opponentRuss);
    }

    public void run() {
        Russ firstTeam = selectRandomFirstTeam();
        log.info("First team is " + firstTeam.getSelectedRuss());
        Russ secondTeam = selectRandomSecondTeam();
        log.info("Second team is " + secondTeam.getSelectedRuss());
        Random random = new Random();

        while (firstTeam.getTeam().size() != 0 && secondTeam.getTeam().size() != 0) {
            if (random.nextInt(2) == 0) {
                log.info("Team " + firstTeam.getSelectedRuss() + " attack to team " + secondTeam.getSelectedRuss());
                oneAttackTeamToTeam(firstTeam, secondTeam);
            } else {
                log.info("Team " + secondTeam.getSelectedRuss() + " attack to team " + firstTeam.getSelectedRuss());
                oneAttackTeamToTeam(secondTeam, firstTeam);
            }
        }

        if (firstTeam.getTeam().size() != 0) {
            log.info(firstTeam.getSelectedRuss() + " won!!!");
        }

        if (secondTeam.getTeam().size() != 0) {
            log.info(firstTeam.getSelectedRuss() + " won!!!");
        }
    }
}


