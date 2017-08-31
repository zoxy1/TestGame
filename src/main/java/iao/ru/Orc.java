package iao.ru;

public class Orc extends Russ {

    public void initTeam(int mageNumber, int archerNumber, int soldierNumber) {
        for (int i = 0; i < mageNumber; i++) {
            team.add(new Mage(RussType.orc));
        }
        for (int i = 0; i < archerNumber; i++) {
            team.add(new Archer(RussType.orc));
        }
        for (int i = 0; i < soldierNumber; i++) {
            team.add(new Soldier(RussType.orc));
        }
    }
}

