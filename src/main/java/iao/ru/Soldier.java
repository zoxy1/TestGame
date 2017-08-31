package iao.ru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Soldier extends Warrior {
    private static Logger log = LogManager.getLogger(Archer.class);

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
        log.info(russType + " " + warriorType + " attack to " + warriorOpponent.warriorType + " from " + warriorOpponent.russType + ", damage is " + forceReal);
        warriorOpponent.changeHp(forceReal);
        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }
}

