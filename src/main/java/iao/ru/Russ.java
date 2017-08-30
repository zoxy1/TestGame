package iao.ru;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Russ {
    protected List<Warrior> team = new ArrayList<Warrior>();
    RussType russ;

    public void removeDeadWarrior() {
        if (team.size() != 0) {
            Iterator<Warrior> iter = team.iterator();
            while (iter.hasNext()) {
                Warrior warrior = iter.next();
                if (warrior.isDead) {
                    iter.remove();
                }
            }
        }
    }

    public abstract void initTeam(int mageNumber, int archerNumber, int soldierNumber);

    public List<Warrior> getTeam() {
        return team;
    }

    public RussType getSelectedRuss() {
        return russ;
    }

    public void setSelectedRuss(RussType russ) {
        this.russ = russ;
    }
}
