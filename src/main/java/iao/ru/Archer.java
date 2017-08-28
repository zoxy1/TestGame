package iao.ru;

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

    public void attack(Warrior warriorOpponent) {

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
            if (group == Group.privileged && (!curseOneStep)) {
                forceReal = ownForce * 1.5;
            } else {
                forceReal = ownForce;
            }

            if (disease50PercentOneStep) {
                forceReal = forceReal / 2;
            }
        }
        warriorOpponent.changeHp(forceReal);
        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }
}

