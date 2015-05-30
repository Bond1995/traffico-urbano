public class Auto extends Elemento {

	private final static int VELOCITA_AUTO = 2;
	private final static int PRIORITY_AUTO = 1;
	private final static String AUTO = ">";
	
	public Auto(int riga, int colonna, int priority, String placeholder) {
		
		super(riga,colonna,PRIORITY_AUTO, AUTO);
		
	}
	
	public Auto(int priority, String placeholder) {
		
		super(PRIORITY_AUTO, AUTO);
		
	}

	@Override
	public Coordinate getProssimaPosizone(){
		
		int prossimaPosizione= posizione.getColonna() + VELOCITA_AUTO;
		
		posizione.setColonna(prossimaPosizione);
		
		return posizione;
		
	}
	
	

}


