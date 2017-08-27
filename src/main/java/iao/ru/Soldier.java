package iao.ru;

public class Soldier extends Warrior {
    public Soldier(RussSelect russSelect) {
        super();
        super.russSelect = russSelect;
        if (russSelect == RussSelect.elf) {
            lossSimpleAttack = 15;
        } else if (russSelect == RussSelect.people) {
            lossSimpleAttack = 18;
        } else if (russSelect == RussSelect.orc) {
            lossSimpleAttack = 20;
        } else if (russSelect == RussSelect.undead) {
            lossSimpleAttack = 18;
        }
    }
}

