package Model;

import Model.GameMap;
import Model.GameObject;

/**
 * Map Controller Class
 * Currently Obsolete
 * @ author Alp Ege Basturk
 * @ version 04.11.2017
 */

public class MapController {

	private GameMap map;
	private int pathColour;
	private int nonPathColour;
	/*private ArrayList<Model.Attacker> attackers;
	private ArrayList<Model.Tower> towers;
	private Hero hero;*/

	/**
	 * 
	 * @param level
	 * @param map
	 */
	public void loadMap(int level, int[][] map) {
		// TODO - implement Model.MapController.loadMap
		throw new UnsupportedOperationException();
	}

	public void drawMap() {
		// TODO - implement Model.MapController.drawMap
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posX
	 * @param posY
	 */
	public boolean isTowerPlaceable(int posX, int posY) {
		// TODO - implement Model.MapController.isTowerPlaceable
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param posX
	 * @param posY
	 * @param object
	 * @param objectID
	 */
	public void updateMap(int posX, int posY, GameObject object, int objectID) {
		// TODO - implement Model.MapController.updateMap
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ListOfObjects
	 */
	public void updateMap(int ListOfObjects) {
		// TODO - implement Model.MapController.updateMap
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param towerID
	 */
	/*public ArrayList<Model.Attacker> findAttackersInTheTowerRange(int towerID) {
		// TODO - implement Model.MapController.findAttackersInTheTowerRange
		throw new UnsupportedOperationException();
	}*/

}