package Model;

import Model.Attacker;
import Model.Tile;

public abstract class AbstractFactory {
    abstract Attacker[] createAttackers();
    abstract Tile[][] createTiles();

}
