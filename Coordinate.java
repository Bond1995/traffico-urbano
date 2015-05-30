public class Coordinate {

	private int riga;
	private int colonna;
	private static final String MESS_COORDINATE = "RIGA:%d;COLONNA:%d";
	
	public Coordinate (int riga, int colonna) {
		
		this.riga = riga;
		this.colonna = colonna;
		
	}
	
	public int getRiga() {
		
		return riga;
		
	}
	
	public int getColonna() {
		
		return colonna;
		
	}
	
	public void setRiga(int riga) {
		
		this.riga = riga;
		
	}
	
	public void setColonna(int colonna) {
		
		this.colonna = colonna;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (colonna != other.colonna)
			return false;
		if (riga != other.riga)
			return false;
		return true;
		
	}

	@Override
	public String toString() {
		
		return String.format(MESS_COORDINATE, (riga + 1), (colonna + 1));
		
	}
	
}
