package iao.ru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Random;

/**
 * Created by Zoxy1 on 26.08.17.
 */
public class Mage extends Warrior {
    private static Logger log = LogManager.getLogger(Mage.class);

    public Mage(RussType russType) {
        super.russType = russType;
        this.warriorType = WarriorType.mage;
        if (russType == RussType.elf) {
            ownForce = 10;
        } else if (russType == RussType.people) {
            ownForce = 4;
        } else if (russType == RussType.orc) {
            ownForce = 0;
        } else if (russType == RussType.undead) {
            ownForce = 5;
        }
    }

    public void attack(Warrior warriorOpponent, List<Warrior> ownTeam) {
        if (russType == RussType.elf || russType == RussType.people) {
            if (gun == Gun.one) {
                Random random = new Random();
                Warrior warriorOwn = ownTeam.get(random.nextInt(ownTeam.size()));
                warriorOwn.setGroup(Group.privileged);
                log.info(russType + " " + warriorType + " set privileged for " + warriorOwn.russType + " " + warriorOwn.warriorType);
            }

            if (gun == Gun.two) {
                double forceReal = calculateForceReal();
                log.info(this.russType + " " + this.warriorType + " attack to " + warriorOpponent.warriorType + " from " + warriorOpponent.russType + ", damage is " + forceReal);
                warriorOpponent.changeHp(forceReal);
            }
        }

        if (russType == RussType.orc) {
            if (gun == Gun.one) {
                Random random = new Random();
                Warrior warriorOwn = ownTeam.get(random.nextInt(ownTeam.size()));
                warriorOwn.setGroup(Group.privileged);
                log.info(russType + " " + warriorType + " set privileged for " + warriorOwn.russType + " " + warriorOwn.warriorType);
            }

            if (gun == Gun.two) {
                warriorOpponent.setCurseOneStep(true);
                log.info(russType + " " + warriorType + " set curse on " + warriorOpponent.russType + " " + warriorOpponent.warriorType);
            }
        }

        if (russType == RussType.undead) {
            if (gun == Gun.one) {
                warriorOpponent.setDisease50PercentOneStep(true);
                log.info(russType + " " + warriorType + " set disease 50 percent on " + warriorOpponent.russType + " " + warriorOpponent.warriorType);
            }

            if (gun == Gun.two) {
                double forceReal = calculateForceReal();
                log.info(russType + " " + warriorType + " attack to " + warriorOpponent.warriorType + " from " + warriorOpponent.russType + ", damage is " + forceReal);
                warriorOpponent.changeHp(forceReal);
            }
        }

        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }
}
