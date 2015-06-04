package window;

import java.awt.Graphics;
import java.util.ArrayList;

import fruit.Fruit;
import fruit.FruitGenerator;

public class FruitGroupView {
	private FruitGenerator fruitGenerator;
	
	public FruitGroupView(FruitGenerator g){
		this.fruitGenerator = g;
	}
	
	public void draw(Graphics g){
		ArrayList<Fruit> group = this.fruitGenerator.getGroup();
		ArrayList<FruitView> fruitViews = new ArrayList<FruitView>();
		for(Fruit fruit : group){
			FruitView view = new FruitView(fruit);
			fruitViews.add(view);
		}
		for(FruitView view : fruitViews){
			view.draw(g);
		}
	}
	
	public void update(){
		this.fruitGenerator.update();
	}
	
}
