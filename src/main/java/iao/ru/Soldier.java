package iao.ru;

import java.util.List;

public class Soldier extends Warrior {

    public Soldier(RussType russType) {
        super.russType = russType;
        this.warriorType = WarriorType.soldier;
        if (russType == RussType.elf) {
            ownForce = 15;
        } else if (russType == RussType.people) {
            ownForce = 18;
        } else if (russType == RussType.orc) {
            ownForce = 20;
        } else if (russType == RussType.undead) {
            ownForce = 18;
        }
    }

    protected void selectGunRandom() {
        gun = Gun.one;
    }

    public void attack(Warrior warriorOpponent, List<Warrior> ownTeam) {
        double forceReal = calculateForceReal();
        System.out.println(russType + " " + warriorType + " attack to " + warriorOpponent.warriorType + " from " + warriorOpponent.russType + ", damage is " + forceReal);
        warriorOpponent.changeHp(forceReal);
        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }
}

