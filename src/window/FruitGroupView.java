package window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import snake.Snake;
import fruit.Fruit;
import fruit.FruitGenerator;

/**
 * Aggregates all FruitView's for fruits in the FruitGenerator
 * @author Justin
 *
 */
public class FruitGroupView extends JComponent{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8018167239294109120L;
	private FruitGenerator fruitGenerator;
	private ArrayList<FruitView> fruitViews;
	private static FruitGroupView fruitGroupInstance = null;
	
	/**
	 * Returns the FruitGroupView
	 * @return fruitGroupInstance
	 */
	public static synchronized FruitGroupView getUniqueInstance(FruitGenerator fruitGenerator) {
		if (fruitGroupInstance == null)
			fruitGroupInstance = new FruitGroupView(fruitGenerator);

		return fruitGroupInstance;
	}
	
	/**
	 * Constructs a new FruitGroupView for the FruitGenerator
	 * @param fruitGenerator
	 */
	private FruitGroupView(FruitGenerator fruitGenerator){
		this.fruitGenerator = fruitGenerator;
		fruitViews = new ArrayList<FruitView>();
	}
	
	/**
	 * Draws all the FruitViews in the FruitGenerator
	 * @param g
	 */
	public void draw(Graphics g){
		ArrayList<Fruit> group = this.fruitGenerator.getFruitList(); //get the list of fruits in game
		for(Fruit fruit : group){
			FruitView view = new FruitView(fruit); //create a FruitView for each fruit
			fruitViews.add(view); //keep track of all fruitViews
			view.draw(g); //draw the fruit
		}
	}
	
	public void update(){
		for(int i = 0; i < fruitViews.size(); i++){
			FruitView view = fruitViews.get(i);
			view.update();
		}
	}
	
	/**
	 * Returns a list of all the FruitViews
	 * @return fruitViews
	 */
	public ArrayList<FruitView> getFruitViews(){
		return this.fruitViews;
	}
	
}
