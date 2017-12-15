import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FactoryLevel1 extends AbstractFactory {
    private Tile[][] tiles;
    private Attacker[] attackers;
    private int level;
    public static int mapWidth = 20;
    public static int mapHeight =15;
    public static int tileEdge = 40;
    private int[][] typeMatrix;

    FactoryLevel1( )
    {
        this.level = 1;
        // TODO: implement an algorithm to calculate
        attackers = new Attacker[15];
        tiles = new Tile[mapHeight][mapWidth];
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
        typeMatrix = new int[mapHeight][mapWidth];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/map1.mat"));
            // Reads according to octaves output format
            // May directly read rows and columns from the file.
            for ( int i = 0; i < 5 ; i++) {
                String tmpLine = bufferedReader.readLine();
                System.out.println(tmpLine);
            }
            for (int y = 0; y < mapHeight; y++)
            {
                String []row = bufferedReader.readLine().trim().split(" ");
                for (int x = 0; x < mapWidth; x++) {
                    typeMatrix[y][x] = Integer.parseInt(row[x]);
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error loading map");
            System.exit(-1);
        }

        for ( int y = 0; y < mapHeight; y++)
        {
            for ( int x = 0; x < mapWidth;x++)
                tiles[y][x] = new Tile(x * tileEdge, y * tileEdge,
                        tileEdge, tileEdge, 0, typeMatrix[y][x]);
        }
        System.out.println("Tiles Created");
        return tiles;
    }
}
