package iao.ru;

public class Soldier extends Warrior {
    public Soldier(RussSelect russSelect) {
        super.russSelect = russSelect;
        if (russSelect == RussSelect.elf) {
            ownForce = 15;
        } else if (russSelect == RussSelect.people) {
            ownForce = 18;
        } else if (russSelect == RussSelect.orc) {
            ownForce = 20;
        } else if (russSelect == RussSelect.undead) {
            ownForce = 18;
        }
    }

    protected void selectGunRandom() {
        gun = Gun.one;
    }
    public void attack(Warrior warriorOpponent) {
            double forceReal;
            if (group == Group.privileged && (!curseOneStep)) {
                forceReal = ownForce * 1.5;
            } else {
                forceReal = ownForce;
            }

            if (disease50PercentOneStep) {
                forceReal = forceReal / 2;
            }
            warriorOpponent.changeHp(forceReal);

        disease50PercentOneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
    }

}

