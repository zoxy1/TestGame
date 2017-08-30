package iao.ru;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Zoxy1 on 25.08.17.
 */
public class TestGame {

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

    protected Russ selectRandomSecondTeam() {
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

    protected void attackWarriors(List<Integer> warriors, Russ attackRuss, Russ opponentRuss) {
        Random random = new Random();
        while (warriors.size() != 0) {
            int indexRandomAttackWarrior = random.nextInt(warriors.size());
            Warrior warriorAttack = attackRuss.getTeam().get(warriors.get(indexRandomAttackWarrior));
            warriorAttack.selectGunRandom();
            int indexRandomOpponentWarrior = random.nextInt(opponentRuss.getTeam().size());
            Warrior warriorOpponent = opponentRuss.getTeam().get(indexRandomOpponentWarrior);
            warriorAttack.attack(warriorOpponent, attackRuss.getTeam());
            opponentRuss.removeDeadWarrior();
            warriors.remove(indexRandomAttackWarrior);
        }
    }

    protected void oneAttackTeamToTeam(Russ attackRuss, Russ opponentRuss) {
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
        attackWarriors(notPrivilegedWarriors, opponentRuss, attackRuss);
    }

    public void run() {
        Russ firstTeam = selectRandomFirstTeam();
        System.out.println("First team is " + firstTeam.getSelectedRuss());
        Russ secondTeam = selectRandomSecondTeam();
        System.out.println("Second team is " + secondTeam.getSelectedRuss());

        Random random = new Random();
        while (firstTeam.getTeam().size() != 0 && secondTeam.getTeam().size() != 0) {
            if (random.nextInt(2) == 0) {
                System.out.println("\nTeam " + firstTeam.getSelectedRuss().toString()+ " attack to team " + secondTeam.getSelectedRuss().toString());
                oneAttackTeamToTeam(firstTeam, secondTeam);
            } else {
                System.out.println("\nTeam " + secondTeam.getSelectedRuss().toString()+ " attack to team " + firstTeam.getSelectedRuss().toString());
                oneAttackTeamToTeam(secondTeam, firstTeam);
            }
        }

        if(firstTeam.getTeam().size() !=0){
            System.out.println(firstTeam.getSelectedRuss().toString() + " won!!!");
        }

        if(secondTeam.getTeam().size() !=0){
            System.out.println(firstTeam.getSelectedRuss().toString() + " won!!!");
        }
    }
}


