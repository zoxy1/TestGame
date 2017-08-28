package iao.ru;

import java.util.List;

/**
 * Created by Zoxy1 on 26.08.17.
 */
public class Archer extends Warrior {
    private double gunForce;

    public Archer(RussSelect russSelect) {
        this.russSelect = russSelect;
        if (russSelect == RussSelect.elf) {
            gunForce = 7;
            ownForce = 3;
        } else if (russSelect == RussSelect.people) {
            gunForce = 5;
            ownForce = 3;
        } else if (russSelect == RussSelect.orc) {
            gunForce = 3;
            ownForce = 2;
        } else if (russSelect == RussSelect.undead) {
            gunForce = 4;
            ownForce = 2;
        }
    }

    private double calculateForceReal() {
        double forceReal = 0;
        if (gun == Gun.one) {
            if (group == Group.privileged && (!curseOneStep)) {
                forceReal = gunForce * 1.5;
            } else {
                forceReal = gunForce;
            }

            if (disease50PercentOneStep) {
                forceReal = forceReal / 2;
            }
        }

        if (gun == Gun.two) {
            forceReal = super.calculateOwnForceReal();
        }

        return forceReal;
    }

    public void attack(Warrior warriorOpponent, List<Warrior> ownTeam) {
        warriorOpponent.changeHp(calculateForceReal());
        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }
}

