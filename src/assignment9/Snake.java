package assignment9;

import java.util.LinkedList;

public class Snake {

	private static final double SEGMENT_SIZE = 0.02;
	private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
	private LinkedList<BodySegment> segments;
	private double deltaX;
	private double deltaY;
	
	public Snake() {
		//FIXME - set up the segments instance variable
		deltaX = 0;
		deltaY = 0;
		this.segments = new LinkedList<BodySegment>();
		segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));
	}
	
	public void changeDirection(int direction) {
		if(direction == 1) { //up
			deltaY = MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 2) { //down
			deltaY = -MOVEMENT_SIZE;
			deltaX = 0;
		} else if (direction == 3) { //left
			deltaY = 0;
			deltaX = -MOVEMENT_SIZE;
		} else if (direction == 4) { //right
			deltaY = 0;
			deltaX = MOVEMENT_SIZE;
		}
	}
	
	/**
	 * Moves the snake by updating the position of each of the segments
	 * based on the current direction of travel
	 */
	public void move() {
		//FIXME
		for (int i = segments.size() - 1; i > 0; i--) {
			BodySegment prevBS = segments.get(i-1);
			segments.get(i).setX(prevBS.getX());
			segments.get(i).setY(prevBS.getY());
		}
		segments.get(0).setX(segments.get(0).getX() + deltaX);
		segments.get(0).setY(segments.get(0).getY() + deltaY);
	}
	
	/**
	 * Draws the snake by drawing each segment
	 */
	public void draw() {
		//FIXME
		for(int i = 0; i < this.segments.size();i++) {
			segments.get(i).draw();
		}
	}
	
	/**
	 * The snake attempts to eat the given food, growing if it does so successfully
	 * @param f the food to be eaten
	 * @return true if the snake successfully ate the food
	 */
	public boolean eatFood(Food f) {
		//FIXME
		double distance = Math.sqrt(Math.pow(f.getX() - segments.get(0).getX(), 2) + Math.pow(f.getY() - segments.get(0).getY(), 2));
		if (distance <= SEGMENT_SIZE + 0.02) {
			segments.add(new BodySegment(segments.get(0).getX() - deltaX, segments.get(0).getY() - deltaY, SEGMENT_SIZE));
			return true;
		} else 
			return false;
		}
	
	/**
	 * Returns true if the head of the snake is in bounds
	 * @return whether or not the head is in the bounds of the window
	 */
	public boolean isInbounds() {
		//FIXME
		if(segments.get(0).getX() <=1 && segments.get(0).getX() >=0 && segments.get(0).getY() <= 1 && segments.get(0).getY() >=0) {
			return true;
		} else {
			return false;
		}
	}
}
