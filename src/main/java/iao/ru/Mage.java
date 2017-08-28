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
                ownTeam.get(random.nextInt(ownTeam.size())).setGroup(Group.privileged);
            }

            if (gun == Gun.two) {
                warriorOpponent.changeHp(super.calculateOwnForceReal());
            }
        }

        if (russSelect == RussSelect.orc) {
            if (gun == Gun.one) {
                Random random = new Random();
                ownTeam.get(random.nextInt(ownTeam.size())).setGroup(Group.privileged);
            }

            if (gun == Gun.two) {
                warriorOpponent.setCurseOneStep(true);
            }
        }

        if (russSelect == RussSelect.undead) {
            if (gun == Gun.one) {
                warriorOpponent.setDisease50PercentOneStep(true);
            }

            if (gun == Gun.two) {
                warriorOpponent.changeHp(super.calculateOwnForceReal());
            }
        }

        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }
}
