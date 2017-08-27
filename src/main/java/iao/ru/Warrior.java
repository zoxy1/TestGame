package iao.ru;

public class Warrior {
    protected double hp = 100;
    protected boolean isDead = false;
    protected double lossSimpleAttack;
    protected Group group = Group.notPrivileged;
    protected boolean disease50OneStep = false;
    protected boolean curseOneStep = false;
    protected RussSelect russSelect;

    public void changeHp(double hp) {
        if (this.hp >= hp) {
            this.hp = this.hp - hp;
        } else {
            this.hp = 0;
        }
        if (this.hp == 0) {
            isDead = true;
            System.out.println("Warior is dead");
        }
    }

    public void changeGroup(Group group) {
        this.group = group;
    }

    public double getLossSimpleAttack() {
        if (disease50OneStep) {
            double lossHpOpponent = this.lossSimpleAttack / 2;
            if (group == Group.privileged && (!curseOneStep)) {
                lossHpOpponent = (this.lossSimpleAttack * 1.5) / 2;
            }
        } else {
            double lossHpOpponent = this.lossSimpleAttack;
            if (group == Group.privileged && (!curseOneStep)) {
                lossHpOpponent = this.lossSimpleAttack * 1.5;
            }
        }
        disease50OneStep = false;
        curseOneStep = false;
        group = Group.notPrivileged;
        return lossSimpleAttack;
    }

    public void setDisease50OneStep(boolean disease50OneStep) {
        this.disease50OneStep = disease50OneStep;
    }

    public void setCurseOneStep(boolean curseOneStep) {
        this.curseOneStep = curseOneStep;
    }

}
