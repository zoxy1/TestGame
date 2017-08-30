package iao.ru;

public class UnDead extends Russ {
    public void initTeam(int mageNumber, int archerNumber, int soldierNumber) {
        for (int i = 0; i < mageNumber; i++) {
            team.add(new Mage(RussType.undead));
        }
        for (int i = 0; i < archerNumber; i++) {
            team.add(new Archer(RussType.undead));
        }
        for (int i = 0; i < soldierNumber; i++) {
            team.add(new Soldier(RussType.undead));
        }
    }
}
