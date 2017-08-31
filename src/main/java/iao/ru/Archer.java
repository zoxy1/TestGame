package iao.ru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Zoxy1 on 26.08.17.
 */
public class Archer extends Warrior {
    private double gunForce;
    private static Logger log = LogManager.getLogger(Archer.class);

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

    protected double calculateForceReal() {
        double forceReal = 0;
        if (gun == Gun.one) {
            if (group == Group.privileged && (!curseOneStep)) {
                forceReal = gunForce * 1.5;
            } else {
                forceReal = gunForce;
            }
        }
        if (gun == Gun.two) {
            if (group == Group.privileged && (!curseOneStep)) {
                forceReal = ownForce * 1.5;
            } else {
                forceReal = ownForce;
            }
        }
        if (disease50PercentOneStep) {
            forceReal = forceReal / 2;
        }
        return forceReal;
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

