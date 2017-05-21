package map;

public class PathQueueObject {

	private Square square;
	private int distance;
	private Square[] path;
	
	public PathQueueObject(Square square, int distance, Square[] path){
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
