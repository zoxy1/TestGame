package iao.ru;

import java.util.List;
import java.util.Random;

/**
 * Created by Zoxy1 on 26.08.17.
 */
public class Mage extends Warrior {

    public Mage(RussSelect russSelect) {
        super.russSelect = russSelect;
        if (russSelect == RussSelect.elf) {

            ownForce = 10;
        } else if (russSelect == RussSelect.people) {
            ownForce = 4;
        } else if (russSelect == RussSelect.orc) {
            ownForce = 0;
        } else if (russSelect == RussSelect.undead) {
            ownForce = 5;
        }
    }

    public void attack(Warrior warriorOpponent, List<Warrior> ownTeam) {
        if (russSelect == RussSelect.elf || russSelect == RussSelect.people) {

            if (gun == Gun.one) {
                Random random = new Random();
                ownTeam.get(random.nextInt(ownTeam.size())).group = Group.privileged;
            }
            double forceReal = 0;
            if (gun == Gun.two) {
                if (group == Group.privileged && (!curseOneStep)) {
                    forceReal = ownForce * 1.5;
                } else {
                    forceReal = ownForce;
                }

                if (disease50PercentOneStep) {
                    forceReal = forceReal / 2;
                }
                warriorOpponent.changeHp(forceReal);
            }
        }

        if (russSelect == RussSelect.orc) {

        }
        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }
}
