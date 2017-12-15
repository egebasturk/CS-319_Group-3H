/**
 * Factory Level5 Class
 * Factory that implements creation methods for level 5
 * @ author Alp Ege Basturk
 * @ version 15.12.2017
 */

public class FactoryLevel5 extends AbstractFactory {
    private Tile[][] tiles;
    private Attacker[] attackers;
    private int level;
    public static int mapWidth = 20;
    public static int mapHeight =15;
    public static int tileEdge = 40;
    private int[][] typeMatrix;

    FactoryLevel5( )
    {
        this.level = 2;
        typeMatrix = new int[mapHeight][mapWidth];
        // TODO: implement an algorithm to calculate
        attackers = new Attacker[60];

        endColumn = mapWidth - 1;
        for ( int i = 0; i < mapHeight; i++ )
        {
            if ( typeMatrix[i][endColumn] == 0)
                endRow = i;
        }
    }
    @Override
    public Attacker[] createAttackers()
    {
        /*
        * Creates attackers according to level.
        * TODO: This initializes only the parent Model.Attacker class.
        * */
        for ( int i = 0; i < attackers.length; i++)
        {
            // TODO: Get rid of magic numbers
            attackers[i] = new Attacker(9);
        }

        return attackers;
    }
    @Override
    public Tile[][] createTiles()
    {
        return mapMatrixReader.readMapFromMatrix(mapHeight,mapWidth,tileEdge,level);
    }

    @Override
    int getEndRow() {
        return endRow;
    }

    @Override
    int getEndColumn() {
        return endColumn;
    }
}
