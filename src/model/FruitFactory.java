package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import util.Constants;
/**
 * Periodically generates different Fruits.
 * Uses Singleton principle
 * @author Justin
 *
 */
public class FruitFactory {
	
	private ArrayList<Fruit> fruitList;
	private static volatile FruitFactory fruitFactory = null;
	private Random r;
	private long previousTime;
	private long currentTime;
	private int spawnTimer;
	private boolean dontSpawn;
	private boolean isPaused;
	
	/**
	 * Constructor for FruitGenerator
	 */
	private FruitFactory(){
		this.fruitList = new ArrayList<Fruit>();
		fruitList.add(new RegularFruit());
		r = new Random();
		this.previousTime = System.currentTimeMillis();
		this.currentTime = System.currentTimeMillis();
		this.spawnTimer = 0;
		this.dontSpawn = false;
		this.isPaused = false;
	}
	
	/**
	 * Returns the FruitGenerator
	 * @return FruitGenerator
	 */
	public static synchronized FruitFactory getUniqueInstance(){
		if(fruitFactory == null){
			fruitFactory = new FruitFactory();
		}
		return fruitFactory;
	}
	
	/**
	 * Updates the fruits in game, and spawns/removes fruits when necessary
	 */
	public void update() {
		if (!fruitFactory.isPaused) {
			fruitFactory.updateTime();
			// spawns fruit periodically
			if (fruitFactory.spawnTimer % Constants.FRUIT_SPAWN_RATE == 0 && fruitFactory.spawnTimer != 0) {
				if (!fruitFactory.dontSpawn) {
					fruitFactory.spawn();
					if (fruitFactory.fruitList.size() > Constants.MAX_FRUITS) {
						fruitFactory.removeOldestFruit();
					}
				}
				fruitFactory.dontSpawn = true; // Stop from spawning again while the count is still the same
			}
		}
		for (Fruit fruit : fruitFactory.fruitList) {
			fruit.update();
		}
	}
	
	/**
	 * Keeps track of time, counting seconds
	 */
	private void updateTime() {
		fruitFactory.currentTime = System.currentTimeMillis();
		if (fruitFactory.currentTime - fruitFactory.previousTime >= 1000) {
			fruitFactory.spawnTimer++;
			fruitFactory.previousTime = fruitFactory.currentTime;
			fruitFactory.dontSpawn = false;
		}
	}
	
	/**
	 * Adds Fruits to the list of fruits in game
	 * @param fruit
	 */
	public void addFruit(Fruit fruit){
		fruitFactory.fruitList.add(fruit);		
	}
	
	/**
	 * Returns the list of fruits is game
	 * @return group
	 */
	public ArrayList<Fruit> getFruitList(){
		return fruitFactory.fruitList;
	}
	
	/**
	 * Pauses all fruits in game
	 */
	public void pause(){
		fruitFactory.isPaused = !fruitFactory.isPaused;
		for(Fruit fruit : fruitFactory.fruitList){
			fruit.pause();
		}
	}
	
	/**
	 * Spawns different fruits depending on time
	 */
	private void spawn() {
		if (fruitFactory.spawnTimer < Constants.LINEAR_FRUIT_SPAWN_TIME) { // only spawn regular fruits
			fruitFactory.fruitList.add(new RegularFruit());
			// spawn regular or random fruit
		} else if (fruitFactory.spawnTimer >= Constants.LINEAR_FRUIT_SPAWN_TIME && fruitFactory.spawnTimer < Constants.RANDOM_FRUIT_SPAWN_TIME) {
			int fruitID = fruitFactory.r.nextInt(2); // randomly choose which kind of fruit to spawn
			switch (fruitID) {
			case 0:
				fruitFactory.fruitList.add(new RegularFruit());
				break;
			case 1:
				fruitFactory.fruitList.add(new LinearFruit());
				break;
			}
		} else { // spawn any of the three fruits
			int fruitID = fruitFactory.r.nextInt(3); // randomly choose which kind of fruit to spawn
			switch (fruitID) {
			case 0:
				fruitFactory.fruitList.add(new RegularFruit());
				break;
			case 1:
				fruitFactory.fruitList.add(new LinearFruit());
				break;
			case 2:
				fruitFactory.fruitList.add(new RandomFruit());
			}
		}
	}
	
	/**
	 * Removes the oldest fruit in the game
	 */
	private void removeOldestFruit(){
		fruitFactory.fruitList.remove(0);
	}
	
	/**
	 * Removes a specific fruit from the game
	 * @param fruit
	 */
	public void removeFruit(Fruit fruit){
		int index = fruitFactory.fruitList.indexOf(fruit);
		fruitFactory.fruitList.remove(index);
	}
	
	public void draw(Graphics g)
	{
		for (Fruit fruit : fruitFactory.fruitList)
		{
			g.setColor(fruit.color);
			g.fillRect(fruit.position.x, fruit.position.y, Constants.FRUIT_SIZE, Constants.FRUIT_SIZE);
		}
		g.setColor(Color.BLACK);
	}
	
	public static void reset() {
		fruitFactory = new FruitFactory();
	}
}
