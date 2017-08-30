package iao.ru;

import java.util.List;
import java.util.Random;

public abstract class Warrior {
    protected double hp = 100;
    protected boolean isDead = false;
    protected double ownForce;
    protected Group group = Group.notPrivileged;
    protected boolean disease50PercentOneStep = false;
    protected boolean curseOneStep = false;
    protected RussType russType;
    protected WarriorType warriorType;
    protected Gun gun = Gun.one;

    protected void changeHp(double forseOpponent) {
        if (hp >= forseOpponent) {
            hp = hp - forseOpponent;
        } else {
            hp = 0;
        }
        if (hp == 0) {
            isDead = true;
            System.out.println(russType + " " + warriorType + " is dead");
        }
    }
    protected void selectGunRandom() {
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            gun = Gun.one;
        } else {
            gun = Gun.two;
        }
    }

    protected double calculateOwnForceReal() {
        double forceReal;
        if (group == Group.privileged && (!curseOneStep)) {
            forceReal = ownForce * 1.5;
        } else {
            forceReal = ownForce;
        }
        if (disease50PercentOneStep) {
            forceReal = forceReal / 2;
        }
        return forceReal;
    }

    public abstract void attack(Warrior warriorOpponent, List<Warrior> ownTeam);

    public void setDisease50PercentOneStep(boolean disease50PercentOneStep) {
        this.disease50PercentOneStep = disease50PercentOneStep;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public void setCurseOneStep(boolean curseOneStep) {
        this.curseOneStep = curseOneStep;
    }

}
