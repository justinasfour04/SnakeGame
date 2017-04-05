package util;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import model.Snake;
import util.Constants.Direction;

public class GameActions {

	public class UpAction extends AbstractAction
	{
		private Direction direction;
		private Snake snake;

		public UpAction(String name, Direction direction)
		{
			super(name);
			this.direction = direction;
			snake = Snake.getUniqueInstance();
		}

		public void actionPerformed(ActionEvent e)
		{
			if (snake.getDirection() != Direction.SOUTH || snake.getDirection() == Direction.NONE)
				snake.setDirection(Direction.NORTH);
		}
	}
	
	public class DownAction extends AbstractAction
	{
		private Direction direction;
		private Snake snake;

		public DownAction(String name, Direction direction)
		{
			super(name);
			this.direction = direction;
			snake = Snake.getUniqueInstance();
		}

		public void actionPerformed(ActionEvent e)
		{
			if (snake.getDirection() != Direction.NORTH || snake.getDirection() == Direction.NONE)
				snake.setDirection(Direction.SOUTH);
		}
	}
	
	public class RightAction extends AbstractAction
	{
		private Direction direction;
		private Snake snake;

		public RightAction(String name, Direction direction)
		{
			super(name);
			this.direction = direction;
			snake = Snake.getUniqueInstance();
		}

		public void actionPerformed(ActionEvent e)
		{

			if (snake.getDirection() != Direction.WEST || snake.getDirection() == Direction.NONE)
				snake.setDirection(Direction.EAST);
		}
	}
	
	public class LeftAction extends AbstractAction
	{
		private Direction direction;
		private Snake snake;

		public LeftAction(String name, Direction direction)
		{
			super(name);
			this.direction = direction;
			snake = Snake.getUniqueInstance();
		}

		public void actionPerformed(ActionEvent e)
		{
			if (snake.getDirection() != Direction.EAST || snake.getDirection() == Direction.NONE)
				snake.setDirection(Direction.WEST);
		}
	}


}
