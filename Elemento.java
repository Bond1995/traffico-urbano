public abstract class Elemento {

	private Coordinate posizione;
	private int priority;
	private String placeholder;
	
	public Elemento(int riga, int colonna, int priority, String placeholder) {
		
		this.posizione = new Coordinate(riga, colonna);
		this.priority = priority;
		this.placeholder = placeholder;
		
	}
	
	public Elemento(int priority, String placeholder) {
		
		this.posizione = new Coordinate(0, 0);
		this.priority = priority;
		this.placeholder = placeholder;
		
	}
	
	public Elemento() {
		
		this.posizione = new Coordinate(0, 0);
		this.priority = 0;
		this.placeholder = " ";
		
	}
	
	public int getRiga() {
		
		return posizione.getRiga();
		
	}
	
	public int getColonna() {
		
		return posizione.getColonna();
		
	}
	
	public void setRiga(int riga) {
		
		posizione.setRiga(riga);
	
	}
	
	public void setColonna(int colonna) {
		
		posizione.setColonna(colonna);
		
	}
	
	@Override
	public String toString() {
		
		return placeholder;
		
	};
	
	public int getPriority() {
		
		return priority;
		
	}
	
	public String toStringPosizione() {
		
		return posizione.toString();
		
	}
	
	public abstract void move();
	
	public boolean prevaleSu(Elemento e) {
		
		if (this.priority > e.priority) return true;
		return false;
		
	}
	
	public boolean collisioneCon(Elemento e) {
		
		if (this.posizione.equals(e.posizione)) return true;
		return false;
		
	}
	
}
