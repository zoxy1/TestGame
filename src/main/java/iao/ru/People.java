package iao.ru;

public class People extends Russ {
    public void initTeam(int mageNumber, int archerNumber, int soldierNumber) {
        for (int i = 0; i < mageNumber; i++) {
            team.add(new Mage(RussSelect.people));
        }
        for (int i = 0; i < archerNumber; i++) {
            team.add(new Archer(RussSelect.people));
        }
        for (int i = 0; i < soldierNumber; i++) {
            team.add(new Soldier(RussSelect.people));
        }
    }
}