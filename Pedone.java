public class Pedone extends Elemento {

	private final static int VELOCITA_PEDONE = 1;
	private final static int PRIORITY_PEDONE = 2;
	private final static String PEDONE = "*";
	
	public Pedone(int riga, int colonna, int priority, String placeholder) {
		
		super(riga,colonna,PRIORITY_PEDONE, PEDONE);
		
	}
	
	public Pedone(int priority, String placeholder) {
		
		super(PRIORITY_PEDONE, PEDONE);
		
	}

	@Override
	public Coordinate getProssimaPosizone(){
		
		int prossimaPosizione= posizione.getRiga() + VELOCITA_PEDONE;
		
		posizione.setRiga(prossimaPosizione);
		
		return posizione;
		
	}
	
	

}


