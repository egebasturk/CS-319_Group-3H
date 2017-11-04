public class HeroType2 extends Hero {

    final double RATE_OF_ATTACK = 4;

    public HeroType2() {
        // TODO - implement HeroType2.HeroType2
        super();
        this.setrateOfAttack(RATE_OF_ATTACK);
        this.setHeroType(2);

        throw new UnsupportedOperationException();
    }

    public void attack(int attackerID, double damage) {
        attack(attackerID, damage);
    }
}