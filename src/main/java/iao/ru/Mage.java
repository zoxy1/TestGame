package iao.ru;

/**
 * Created by Zoxy1 on 26.08.17.
 */
public class Mage extends Warrior {

    public Mage(RussSelect russSelect) {
        super();
        super.russSelect = russSelect;
        if(russSelect == RussSelect.elf){
            lossSimpleAttack = 10;
        } else if(russSelect == RussSelect.people) {
            lossSimpleAttack = 4;
        } else if (russSelect == RussSelect.orc) {
            lossSimpleAttack = 0;
        } else if(russSelect == RussSelect.undead) {
            lossSimpleAttack = 5;
        }
    }
}
