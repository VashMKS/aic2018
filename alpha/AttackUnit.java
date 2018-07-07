package alpha;

import aic2018.*;

public class AttackUnit {

    UnitController uc;
    UsefulInfo data;

    public AttackUnit(){}

    public AttackUnit(UnitController _uc) {
        uc = _uc;
        data = new UsefulInfo(uc);
    }

    public void run() {

        //Move in a random direction
        int dirIndex = (int)(Math.random()*8);
        if (uc.canMove(data.dirs[dirIndex])) uc.move(data.dirs[dirIndex]);

        //Attack the first target you see
        UnitInfo[] enemies = uc.senseUnits(data.enemy);
        for (UnitInfo unit : enemies){
            if (uc.canAttack(unit)) uc.attack(unit);
        }

    }

}