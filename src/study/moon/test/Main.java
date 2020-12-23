package study.moon.test;

public class Main {

    public static void main(String[] args) {
        Hero superHero = new SuperHero(100,20,5);
        Hero hyperHero = new HyperHero(100,5,10);
        Villain superVillain = new SuperVillain(200,10,5);
        Villain hyperVillain = new HyperVillain(150,15,10);
        superHero.attack(superVillain);
        superHero.attack(hyperVillain);
        hyperHero.attack(superVillain);
        hyperHero.attack(hyperVillain);
        superVillain.attack(superHero);
        superVillain.attack(hyperHero);
        hyperVillain.attack(superHero);
        hyperVillain.attack(hyperHero);

        System.out.println(superHero);
        System.out.println(hyperHero);
        System.out.println(superVillain);
        System.out.println(hyperVillain);


    }

}

