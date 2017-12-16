/**
 * Abstract Factory Class
 * Abstract Factory which provides methods to create levels easily
 * @ author Alp Ege Basturk
 * @ version 22.11.2017
 */
public abstract class AbstractFactory {
    int endRow;
    int endColumn;
    abstract Attacker[] createAttackers();
    abstract Tile[][] createTiles();
    abstract int getEndRow();
    abstract int getEndColumn();
}
