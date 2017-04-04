package gui;


public enum IconEnum {
	
	JAMY(1);
	
	private int numberIcon;
	
	IconEnum(int numberIcon) {
		this.numberIcon = numberIcon;
	}
	public int getIcon() {
		return this.numberIcon;
		
		
	}

	
}
