package map;

import java.util.LinkedList;

public class Path {
	private Square finalSquare;
	private int maxRange;
	private LinkedList<PathCouple> fifo = new LinkedList<PathCouple>();
	private Square[] path;
	private boolean reachable = false;
	
	
	public Path(Square initialSquare, Square finalSquare, int maxRange){
		this.finalSquare = finalSquare;
		this.maxRange = maxRange;
		fifo.add(new PathCouple(initialSquare, 0, new Square[] {}));
		deepPath();
	}
	
	private void deepPath(){
		PathCouple currentSquare = fifo.getFirst();
		int[] maxDim = currentSquare.getSquare().getMap().getDim();
		while ((currentSquare.getSquare() != finalSquare) && !(fifo.isEmpty()) ){
			currentSquare = fifo.pop();
			if (currentSquare.getDistance() <= maxRange){
				int[] coord = currentSquare.getSquare().getCoord();
				
				
				Square[] array = new Square[currentSquare.getPath().length+1];
				for(int j=0;  j<currentSquare.getPath().length;j++){
					array[j] = currentSquare.getPath()[j];
				}
				array[currentSquare.getPath().length] = currentSquare.getSquare();
				
				if(coord[0] < maxDim[0]-1 ){
					fifo.add(new PathCouple(currentSquare.getSquare().getMap().getSquare(coord[0]+1, coord[1])
							,currentSquare.getDistance()+1, array) );
				}
				
				if(coord[0] > 0 ){
					fifo.add(new PathCouple(currentSquare.getSquare().getMap().getSquare(coord[0]-1, coord[1])
							,currentSquare.getDistance()+1, array) );
				}
				
				if(coord[1] < maxDim[1]-1 ){
					fifo.add(new PathCouple(currentSquare.getSquare().getMap().getSquare(coord[0], coord[1]+1)
							,currentSquare.getDistance()+1, array) );
				}
				
				if(coord[1] > 0 ){
					fifo.add(new PathCouple(currentSquare.getSquare().getMap().getSquare(coord[0], coord[1]-1)
							,currentSquare.getDistance()+1, array) );
				}
			}
		}
		
		if(currentSquare.getSquare() == finalSquare){
			setReachable(true);
			setPath(currentSquare.getPath());
		}
	}
	
	public boolean isReachable(){
		return reachable;
	}
	
	public Square[] getPath(){
		return path;
	}
	
	private void setReachable(boolean bool){
		reachable = bool;
	}
	
	private void setPath(Square[] path){
		this.path = path;
	}
}
