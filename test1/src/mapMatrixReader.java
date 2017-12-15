/**
 * Map Matrix Reader
 * Provides static method to read map from the matrix
 * @ author Alp Ege Basturk
 * @ version 15.12.2017
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class mapMatrixReader
{

    public static Tile[][] readMapFromMatrix( int mapHeight, int mapWidth, int tileEdge, int level)
    {
        int[][] typeMatrix = new int[mapHeight][mapWidth];
        Tile[][] tiles = new Tile[mapHeight][mapWidth];
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/map" + level + ".mat"));
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
