package study.moon.test;

public abstract class Hero extends Unit {

    int level;

    public Hero(int hp, int attackPoint, int level) {
        super(hp, attackPoint);
        this.level = level;
    }
    public abstract void attack(Villain villain);

    public void isAttackedBy(SuperVillain superVillain) {
        hp -= (superVillain.attackPoint * 2 - level);
    }

    public void isAttackedBy(HyperVillain hyperVillain) {
        hp -= (hyperVillain.attackPoint);
    }


    @Override
    public String toString() {
        return "Hero{" +
            "hp=" + hp +
            ", attackPoint=" + attackPoint +
            ", level=" + level +
            '}';
    }
}
