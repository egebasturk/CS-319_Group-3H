public interface AttackBehaviour {
    void attack();
    void singleAttack( Tower attackSource);
    void areaAttack( Tower attackSource);
    boolean heroAttack( Hero attackSource );
}
