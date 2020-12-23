package study.moon.test;

public class HyperHero extends Hero {

    public HyperHero(int hp, int attackPoint, int level) {
        super(hp, attackPoint, level);
    }

    @Override
    public void attack(Villain villain) {
        villain.isAttackedBy(this);
    }

}
