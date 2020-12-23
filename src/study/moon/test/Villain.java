package study.moon.test;

public abstract class Villain extends Unit {

    int defensePoint;

    public Villain(int hp, int attackPoint, int defensePoint) {
        super(hp, attackPoint);
        this.defensePoint = defensePoint;
    }

    public abstract void attack(Hero hero);

    public void isAttackedBy(SuperHero superHero) {
        hp -= (superHero.attackPoint + superHero.level - defensePoint);
    }

    public void isAttackedBy(HyperHero hyperHero) {
        hp -= (hyperHero.level * 3);
    }



    @Override
    public String toString() {
        return "Villain{" +
            "hp=" + hp +
            ", attackPoint=" + attackPoint +
            ", defensePoint=" + defensePoint +
            '}';
    }
}
