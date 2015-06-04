package fruit;

import java.util.ArrayList;
import java.util.Random;

import snake.Snake;
import utility.Constants;
import controllers.GameController;
/**
 * Periodically generates different Fruits.
 * Uses Singleton principle
 * @author Justin
 *
 */
public class FruitGenerator {
	
	private ArrayList<Fruit> fruitList;
	private static FruitGenerator fruitGenerator = null;
	private GameController controller;
	private Random r;
	private long previousTime;
	private long currentTime;
	private int spawnTimer;
	private boolean dontSpawn;
	private boolean isPaused;
	
	/**
	 * Constructor for FruitGenerator
	 */
	private FruitGenerator(){
		this.controller = GameController.getUniqueInstance(Snake.getUniqueInstance(),this);
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
	public static synchronized FruitGenerator getUniqueInstance(){
		if(fruitGenerator == null){
			fruitGenerator = new FruitGenerator();
			return fruitGenerator;
		} else {
			return fruitGenerator;
		}
	}
	
	/**
	 * Updates the fruits in game, and spawns/removes fruits when necessary
	 */
	public void update(){
		
		if(!isPaused && controller.isStarted()){
			updateTime();
			if(spawnTimer%Constants.FRUIT_SPAWN_RATE == 0 && spawnTimer != 0){ //spawn fruits periodically
				if(!dontSpawn){
					spawn();
					if(fruitList.size() > Constants.MAX_FRUITS){
						removeOldestFruit();
					}
				}
				this.dontSpawn = true;	//Stop from spawning again while the count is still the same
			}
		}
		for(Fruit fruit : fruitList){
			fruit.update();
		}
	}
	
	/**
	 * Keeps track of time, counting seconds
	 */
	private void updateTime(){
		currentTime = System.currentTimeMillis();
		if(currentTime-previousTime >= 1000){
			spawnTimer++;
			previousTime = currentTime;
			dontSpawn = false;
		}
	}
	
	/**
	 * Adds Fruits to the list of fruits in game
	 * @param fruit
	 */
	public void addFruit(Fruit fruit){
		this.fruitList.add(fruit);		
	}
	
	/**
	 * Returns the list of fruits is game
	 * @return group
	 */
	public ArrayList<Fruit> getFruitList(){
		return this.fruitList;
	}
	
	/**
	 * Pauses all fruits in game
	 */
	public void pause(){
		this.isPaused = !isPaused;
		for(Fruit fruit : fruitList){
			fruit.pause();
		}
	}
	
	/**
	 * Spawns different fruits depending on time
	 */
	private void spawn(){
		
		if(spawnTimer < Constants.LINEAR_FRUIT_SPAWN_TIME){ //only spawn regular fruits
			fruitList.add(new RegularFruit());
		} else if( spawnTimer >= Constants.LINEAR_FRUIT_SPAWN_TIME && spawnTimer < Constants.RANDOM_FRUIT_SPAWN_TIME){ //spawn regular or linear fruits
			int fruitID = r.nextInt(2);  //randomly choose which kind of fruit to spawn
			switch(fruitID){
	    	   case 0:
	    		   fruitList.add(new RegularFruit());
	    		   break;
	    	   case 1:
	    		   fruitList.add(new LinearFruit());
	    		   break;
	    	   }
	    } else {	//spawn any of the three fruits
	    	   		
	    	   int fruitID = r.nextInt(3); //randomly choose which kind of fruit to spawn
	    	   switch(fruitID){
	    	   case 0:
	    		   fruitList.add(new RegularFruit());
	    		   break;
	    	   case 1:
	    		   fruitList.add(new LinearFruit());
	    		   break;
	    	   case 2:
	    		   fruitList.add(new RandomFruit());
	    	   }
	       }
	}
	
	/**
	 * Removes the oldest fruit in the game
	 */
	private void removeOldestFruit(){
		fruitList.remove(0);
	}
	
	/**
	 * Removes a specific fruit from the game
	 * @param fruit
	 */
	public void removeFruit(Fruit fruit){
		int index = fruitList.indexOf(fruit);
		fruitList.remove(index);
	}
}
