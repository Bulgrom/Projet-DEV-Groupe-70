
public class Square {
	private int background;
	private int hight = -1;
	private int elem = -1;
	private int pers = -1;
	
	public Square(String descr){
		String[] separator = descr.split("b");
		background = Integer.parseInt(separator[0]);
		if (separator.length == 2){
			separator[0] = separator[1];
		}
		
		separator = separator[0].split("h");
		if (separator.length == 2){
			hight = Integer.parseInt(separator[0]);
			separator[0] = separator[1];
		}
		
		separator = separator[0].split("e");
		if (separator.length == 2){
			elem = Integer.parseInt(separator[0]);
			separator[0] = separator[1];
		}
		
		separator = separator[0].split("p");
		if (separator.length == 2){
			pers = Integer.parseInt(separator[0]);
			separator[0] = separator[1];
		}
	}
		
	
	public String toString(){
		String line = background + "b";
		if (hight != -1){
			line = line + hight + "h";
		}
		if (elem != -1){
			line = line + elem + "e";
		}
		if (pers != -1){
			line = line + pers + "p";
		}
		return line;
	}
}
