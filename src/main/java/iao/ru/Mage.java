package iao.ru;

/**
 * Created by Zoxy1 on 26.08.17.
 */
public class Mage {

    private double hp = 100;
    private boolean isDead = false;
    private double lossHpOpponent = 10;
    private Group group = Group.notPrivileged;
    private boolean disease50OneStep = false;
    private boolean curseOneStep = false;

    public void changeHp(double hp) {
        if (this.hp >= hp) {
            this.hp = this.hp - hp;
        } else {
            this.hp = 0;
        }
        if (this.hp == 0) {
            isDead = true;
        }
    }

    public void changeGroup(Group group) {
        this.group = group;
    }

    public double getLossHpOpponent() {
        if (disease50OneStep) {
            double lossHpOpponent = this.lossHpOpponent / 2;
            if (group == Group.privileged && (!curseOneStep)) {
                lossHpOpponent = (this.lossHpOpponent * 1.5) / 2;
            }
        } else {
            double lossHpOpponent = this.lossHpOpponent;
            if (group == Group.privileged && (!curseOneStep)) {
                lossHpOpponent = this.lossHpOpponent * 1.5;
            }
        }
        disease50OneStep = false;
        curseOneStep = false;
        return lossHpOpponent;
    }

    public void setDisease50OneStep(boolean disease50OneStep) {
        this.disease50OneStep = disease50OneStep;
    }
    public void setCurseOneStep(boolean curseOneStep) {
        this.curseOneStep = curseOneStep;
    }

}
