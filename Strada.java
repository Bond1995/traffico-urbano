import ing.unibs.esercitazioni.mylib.MyUtil;

public class Strada {
	
	private int contatoreCollisioni = 0;
	private int contatorePedoni = 0;
	private int contatoreAuto = 0;
	private int percentualeVuoti = 50;
	private int percentualePedoni = 30;
	private int percentualeAuto = 20;
	private static final String ERRORE_PERCENTUALE = "Attenzione: le percentuali di elementi sulla strada superano il 100%!";
	private static final String ELEMENTO_LINEA = " -";
	private static final String SEPARATORE = "|";
	private static final String MESS_BILANCIO = "Durante questo passo sono avvenute %d collisioni.%n%d pedoni hanno attraversato la strada.%n%d auto hanno percorso l'intera strada.%n";
	
	private Elemento[][] strada;
	
	public Strada (int righe, int colonne) {
		
		strada = new Elemento[righe][colonne];
		for (int i = 0; i < strada.length; i++) 
			for (int j = 0; j < strada[0].length; j++)
				strada[i][j] = estraiNuovoElemento(i, j);
		
	}
	
	public void step() {
		
		contatoreCollisioni = 0;
		contatorePedoni = 0;
		contatoreAuto = 0;
		Elemento[][] nuovaStrada = new Elemento[strada.length][strada[0].length];
		
		for (int i = 0; i < nuovaStrada.length; i++)
			for (int j = 0; j < nuovaStrada[0].length; j++)
				nuovaStrada[i][j] = new Vuoto(i, j);
		
		for (int i = 0; i < strada.length; i++)
			for (int j = 0; j < strada[0].length; j++) {
				
				Elemento elemento1 = strada[i][j];
				
				if (!(elemento1 instanceof Vuoto)) {
					
					elemento1.move();
					
					try {
						
						Elemento elemento2 = nuovaStrada[elemento1.getRiga()][elemento1.getColonna()];
						
						if (!(elemento2 instanceof Vuoto)) {
						
							if (elemento1.prevaleSu(elemento2)) nuovaStrada[elemento1.getRiga()][elemento1.getColonna()] = elemento1;
							contatoreCollisioni++;
						
						} else nuovaStrada[elemento1.getRiga()][elemento1.getColonna()] = elemento1;
						
					} catch (IndexOutOfBoundsException exc) {
						
						if (elemento1 instanceof Pedone) contatorePedoni++;
						else contatoreAuto++;
						
					}
					
				}
				
			}
		
		strada = nuovaStrada;
		
	}
	
	private Elemento estraiNuovoElemento(int x, int y) throws ArithmeticException {
		
		if ((percentualeVuoti + percentualePedoni + percentualeAuto) != 100)
			throw new ArithmeticException(ERRORE_PERCENTUALE);
		
		int i = MyUtil.randomInt(1, 100);
		
		if (i >= 1 && i <= percentualeVuoti) return new Vuoto(x, y);
		if (i >= (percentualeVuoti + 1) && i <= (percentualeVuoti + percentualePedoni)) return new Pedone(x, y);
		if (i >= (percentualeVuoti + percentualePedoni + 1) && i <= 100) return new Auto(x, y);
		return new Vuoto(x, y);
		
	}
	
	public void setPercentuali(int vuoti, int pedoni, int auto) throws ArithmeticException {
		
		if ((vuoti + pedoni + auto) != 100)
			throw new ArithmeticException(ERRORE_PERCENTUALE);
		
		percentualeVuoti = vuoti;
		percentualePedoni = pedoni;
		percentualeAuto = auto;
		
	}
	public int getNumeroElementi() {
		
		int totale = 0;
		
		for (int i = 0; i < strada.length; i++)
			for (int j = 0; j < strada[0].length; j++)
				if (!(strada[i][j] instanceof Vuoto)) totale++;
		
		return totale;
		
	}
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < strada[0].length; i++)
			builder.append(ELEMENTO_LINEA);
		builder.append("\n");
		
		for (int i = 0; i < strada.length; i++) {
			
			for (int j = 0; j < strada[0].length; j++)
				builder.append(SEPARATORE).append(strada[i][j].toString());
			
			builder.append(SEPARATORE).append("\n");
			
			for (int j = 0; j < strada[0].length; j++)
				builder.append(ELEMENTO_LINEA);
			
			builder.append("\n");
			
		}
		
		return builder.toString();
		
	}
	
	public String toStringStats() {
		
		return String.format(MESS_BILANCIO, contatoreCollisioni, contatorePedoni, contatoreAuto);
		
	}
	
}
