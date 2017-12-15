public abstract class AbstractFactory {
    int endRow;
    int endColumn;
    abstract Attacker[] createAttackers();
    abstract Tile[][] createTiles();
    abstract int getEndRow();
    abstract int getEndColumn();
}
