package FromDMDev.Generics06;

import FromDMDev.Generics06.weapon.MagicWeapon;

public class Wand implements MagicWeapon {
    @Override
    public int getDamage() {
        return 20;
    }
}
