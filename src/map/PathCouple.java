package map;

public class PathCouple {

	private Square square;
	private int distance;
	private Square[] path;
	
	public PathCouple(Square square, int distance, Square[] path){
		this.square = square;
		this.distance = distance;
		this.path = path;
	}
	
	public Square getSquare(){
		return square;
	}
	
	public int getDistance(){
		return distance;
	}
	
	public Square[] getPath(){
		return path;
	}
}
