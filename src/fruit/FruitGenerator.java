package fruit;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import snake.Snake;
import controllers.GameController;

public class FruitGenerator {//implements Runnable {
	
	private ArrayList<Fruit> group;
	private static FruitGenerator fruitGenerator = null;
	private GameController controller;
	private Timer fruitTimer;
	private Random r;
	private long previousTime;
	private long currentTime;
	private int count;
	private boolean dontSpawn;
	private boolean isPaused;
	
	private FruitGenerator(){
		this.controller = GameController.getUniqueInstance(Snake.getUniqueInstance(),this);
		this.group = new ArrayList<Fruit>();
		group.add(new RegularFruit());
		r = new Random();
		fruitTimer = new Timer();
		this.previousTime = System.currentTimeMillis();
		this.currentTime = System.currentTimeMillis();
		this.count = 0;
		this.dontSpawn = false;
		this.isPaused = false;
//		Thread spawn = new Thread(new Runnable() {
//		    public void run()
//		    {
//		        try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		        if(controller.getGameTime() < 15){
//			    	   group.add(new RegularFruit());
//			       }
//			       else if( controller.getGameTime() >= 15 && controller.getGameTime() < 30){
//			    	   int fruitID = r.nextInt(2);
//			    	   switch(fruitID){
//			    	   case 0:
//			    		   group.add(new RegularFruit());
//			    		   break;
//			    	   case 1:
//			    		   group.add(new LinearFruit());
//			    		   break;
//			    	   }
//			       } else {
//			    	   int fruitID = r.nextInt(3);
//			    	   switch(fruitID){
//			    	   case 0:
//			    		   group.add(new RegularFruit());
//			    		   break;
//			    	   case 1:
//			    		   group.add(new LinearFruit());
//			    		   break;
//			    	   case 2:
//			    		   group.add(new RandomFruit());
//			    	   }
//			       }
//			   }
//		});
//		spawn.start();
//		
//		Thread remove = new Thread(new Runnable() {
//		    public void run()
//		    {
//		        try {
//					Thread.sleep(10000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		        group.remove(0); 
//		    }
//		});
//		remove.start();
//		
	}
	
	public static synchronized FruitGenerator getUniqueInstance(){
		if(fruitGenerator == null){
			fruitGenerator = new FruitGenerator();
			return fruitGenerator;
		} else {
			return fruitGenerator;
		}
	}
	
	public void update(){
//		System.out.println(count);
//		System.out.println(currentTime);
//		System.out.println(previousTime);
//		System.out.println(currentTime-previousTime);
		if(!isPaused){
			updateTime();
		
			if(count%5 == 0 && count != 0){
				if(!dontSpawn){
					spawn();
				}
				this.dontSpawn = true;
				
			}
			if(count%9 ==0 && count != 0){
				remove();
				count++;
			}
		}
		for(Fruit fruit : group){
			fruit.update();
		}
		
	}
	
	private void updateTime(){
		currentTime = System.currentTimeMillis();
		if(currentTime-previousTime >= 1000){
			count++;
			previousTime = currentTime;
			dontSpawn = false;
		}
	}
	
	public void addFruit(Fruit fruit){
		this.group.add(fruit);		
	}
	
	public ArrayList<Fruit> getGroup(){
		return this.group;
	}
	
	public void pause(){
		this.isPaused = !isPaused;
		for(Fruit fruit : group){
			fruit.pause();
		}
	}
	
	private void spawn(){
		if(count < 15){
	    	   group.add(new RegularFruit());
	       }
	       else if( count >= 15 && count < 30){
	    	   int fruitID = r.nextInt(2);
	    	   switch(fruitID){
	    	   case 0:
	    		   group.add(new RegularFruit());
	    		   break;
	    	   case 1:
	    		   group.add(new LinearFruit());
	    		   break;
	    	   }
	       } else {
	    	   int fruitID = r.nextInt(3);
	    	   switch(fruitID){
	    	   case 0:
	    		   group.add(new RegularFruit());
	    		   break;
	    	   case 1:
	    		   group.add(new LinearFruit());
	    		   break;
	    	   case 2:
	    		   group.add(new RandomFruit());
	    	   }
	       }
	}
	
	private void remove(){
		group.remove(0);
	}
//	@Override
//	public void run() {
//		fruitTimer.schedule(new TimerTask() { 
//			   @Override  
//			   public void run() {
//			       if(controller.getGameTime() < 15){
//			    	   group.add(new RegularFruit());
//			       }
//			       else if( controller.getGameTime() >= 15 && controller.getGameTime() < 30){
//			    	   int fruitID = r.nextInt(2);
//			    	   switch(fruitID){
//			    	   case 0:
//			    		   group.add(new RegularFruit());
//			    		   break;
//			    	   case 1:
//			    		   group.add(new LinearFruit());
//			    		   break;
//			    	   }
//			       } else {
//			    	   int fruitID = r.nextInt(3);
//			    	   switch(fruitID){
//			    	   case 0:
//			    		   group.add(new RegularFruit());
//			    		   break;
//			    	   case 1:
//			    		   group.add(new LinearFruit());
//			    		   break;
//			    	   case 2:
//			    		   group.add(new RandomFruit());
//			    	   }
//			       }
//			   }
//			},  5000);
//			
//			fruitTimer.schedule(new TimerTask() { 
//				   @Override  
//				   public void run() {
//				       group.remove(0); 
//				   }
//				},  10000);
//		
//	}
}
