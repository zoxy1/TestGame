package iao.ru;

import java.util.List;

/**
 * Created by Zoxy1 on 26.08.17.
 */
public class Archer extends Warrior {
    private double gunForce;
    public Archer(RussType russType) {
        this.russType = russType;
        this.warriorType = WarriorType.archer;
        if (russType == RussType.elf) {
            gunForce = 7;
            ownForce = 3;
        } else if (russType == RussType.people) {
            gunForce = 5;
            ownForce = 3;
        } else if (russType == RussType.orc) {
            gunForce = 3;
            ownForce = 2;
        } else if (russType == RussType.undead) {
            gunForce = 4;
            ownForce = 2;
        }
    }

    public void attack(Warrior warriorOpponent, List<Warrior> ownTeam) {
        double forceReal = calculateOwnForceReal();
        warriorOpponent.changeHp(forceReal);
        System.out.println(russType + " " + warriorType + " attack to " + warriorOpponent.warriorType + " from " + warriorOpponent.russType + ", damage is " + forceReal);
        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }
}

