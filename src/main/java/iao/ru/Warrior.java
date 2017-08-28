package iao.ru;

import java.util.Random;

public class Warrior {
    protected double hp = 100;
    protected boolean isDead = false;
    protected double ownForce;
    protected Group group = Group.notPrivileged;
    protected boolean disease50PercentOneStep = false;
    protected boolean curseOneStep = false;
    protected RussSelect russSelect;
    protected Gun gun = Gun.one;

    protected void changeHp(double forseOpponent) {
        if (hp >= forseOpponent) {
            hp = hp - forseOpponent;
        } else {
            hp = 0;
        }
        if (hp == 0) {
            isDead = true;
            System.out.println("Warior is dead");
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
    public void changeGroup(Group group) {
        this.group = group;
    }


    public void setDisease50PercentOneStep(boolean disease50PercentOneStep) {
        this.disease50PercentOneStep = disease50PercentOneStep;
    }

    public void setCurseOneStep(boolean curseOneStep) {
        this.curseOneStep = curseOneStep;
    }

}
