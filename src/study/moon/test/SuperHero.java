package study.moon.test;

public class SuperHero extends Hero{

    public SuperHero(int hp, int attackPoint, int level) {
        super(hp, attackPoint, level);
    }

    @Override
    public void attack(Villain villain) {
        villain.isAttackedBy(this);
    }
}
