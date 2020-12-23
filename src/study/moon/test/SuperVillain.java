package study.moon.test;

public class SuperVillain extends Villain{

    public SuperVillain(int hp, int attackPoint, int defensePoint) {
        super(hp, attackPoint, defensePoint);
    }

    @Override
    public void attack(Hero hero) {
        hero.isAttackedBy(this);
    }

}
