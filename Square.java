
public class Square {
	private int background;
	private int hight = 0;
	private Element elem;
	private Personage pers;
	
	public Square(String descr){
		String[] separator = descr.split("b");
		background = Integer.parseInt(separator[0]);
		if (separator.length == 2){
			separator[0] = separator[1];
		
			separator = separator[0].split("h");
			if (separator.length == 2){
				hight = Integer.parseInt(separator[0]);
				separator[0] = separator[1];
			}
		
			separator = separator[0].split("e");
			if (separator.length == 2){
				elem = new Element(Integer.parseInt(separator[0]));
				separator[0] = separator[1];
			}
		
			separator = separator[0].split("p");
			if (separator.length == 1){
				pers = new Personage(Integer.parseInt(separator[0]));
			}
		}
	}
		
	
	public String toString(){
		String line = background + "b";
		if (hight != 0){
			line = line + hight + "h";
		}
		if (elem != null){
			line = line + elem.getId() + "e";
		}
		if (pers != null){
			line = line + pers.getId() + "p";
		}
		return line;
	}
}
