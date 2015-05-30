public class Auto extends Elemento {

	private final static int VELOCITA_AUTO = 2;
	private final static String AUTO = ">";
	
	public Auto(int riga, int colonna, int priority, String placeholder) {
		
		super(riga,colonna,priority, AUTO);
		
	}
	
	public Auto(int priority, String placeholder) {
		
		super(priority, AUTO);
		
	}

	@Override
	public Coordinate getProssimaPosizone(){
		
		int prossimaPosizione= posizione.getColonna() + VELOCITA_AUTO;
		
		posizione.setColonna(prossimaPosizione);
		
		return posizione;
		
	}
	
	

}
