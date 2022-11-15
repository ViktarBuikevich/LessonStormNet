package FromDMDev.Generics06;

import FromDMDev.Generics06.weapon.MelleWeapon;

public class Sword implements MelleWeapon {
    @Override
    public int getDamage() {
        return 15;
    }
}
