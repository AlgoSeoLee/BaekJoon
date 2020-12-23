package study.moon.test;

public class HyperVillain extends Villain {

    public HyperVillain(int hp, int attackPoint, int defensePoint) {
        super(hp, attackPoint, defensePoint);
    }

    @Override
    public void attack(Hero hero) {
        hero.isAttackedBy(this);
    }
}
