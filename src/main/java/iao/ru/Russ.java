package iao.ru;

import java.util.ArrayList;
import java.util.List;

public abstract class Russ {
    protected List<Warrior> team = new ArrayList<Warrior>();

    public void removeDeadWarrior() {
        for (Warrior w : team) {
            if (w.isDead) {
                team.remove(w);
            }
        }
    }

    public abstract void initTeam(int mageNumber, int archerNumber, int soldierNumber);

    public List<Warrior> getTeam() {
        return team;
    }

    public void setTeam(List<Warrior> team) {
        this.team = team;
    }
}
