package iao.ru;

/**
 * Created by Zoxy1 on 26.08.17.
 */
public class Archer extends Warrior {
    private double lossGun;
    public Archer(RussSelect russSelect) {
        super();
        this.russSelect = russSelect;
        if(russSelect == RussSelect.elf){
            lossGun = 7;
            lossSimpleAttack = 3;
        } else if(russSelect == RussSelect.people) {
            lossGun = 5;
            lossSimpleAttack = 3;
        } else if (russSelect == RussSelect.orc) {
            lossGun = 3;
            lossSimpleAttack = 2;
        } else if(russSelect == RussSelect.undead) {
            lossGun = 4;
            lossSimpleAttack = 2;
        }
    }
}

