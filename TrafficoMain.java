package ing.unibs.esercitazioni.traffico;

import ing.unibs.esercitazioni.mylib.MyMenu;
import ing.unibs.esercitazioni.mylib.MyUtil;

public class TrafficoMain {

	private static final String[] VOCI = {"Esci", "Simula"};
	private static final int MIN_RIGHE = 2;
	private static final int MAX_RIGHE = 5;
	private static final int MIN_COLONNE = 10;
	private static final int MAX_COLONNE = 30;
	private static final String MESS_NUMERO_RIGHE = "Inserisci il numero di righe della strada:";
	private static final String MESS_NUMERO_COLONNE = "Inserisci il numero di colonne della strada:";
	private static final String MESS_PERCENTUALE_VUOTI = "Inserisci la percentuale di spazi vuoti che desideri avere sulla strada:";
	private static final String MESS_PERCENTUALE_PEDONI = "Inserisci la percentuale di pedoni che desideri avere sulla strada:";
	private static final String MESS_PERCENTUALE_AUTO = "Inserisci la percentuale di auto che desideri avere sulla strada:";
	private static final String MESS_INSERIRE_NUOVE_PERCENTUALI = " Inserisci delle nuove percentuali:";
	private static final String SALUTO = "Ciao e benvenuto nel tuo Simulatore di Traffico!\n";
	private static final String TITOLO = "Elenco opzioni:\n";
	private static final String MESS_STRADA_VUOTA = "Tutti gli elementi hanno liberato la strada!";
	private static final String ARRIVEDERCI = "Grazie per aver giocato. Alla prossima!";
	
	public static void main(String[] args) {
		
		System.out.println(SALUTO);
		Strada miaStrada = setDimensioneStrada();
		setPercentuali(miaStrada);
		MyMenu menu = new MyMenu(TITOLO, VOCI);
		System.out.println(miaStrada.toString());
		
		int scelta = 0;
		do {
			
			scelta = menu.scegliVoce();
			if (scelta != 0) {
				
				miaStrada.step();
				System.out.println(miaStrada.toString());
				System.out.println(miaStrada.toStringStats());
				
			}
			
		} while (scelta != 0 && miaStrada.getNumeroElementi() != 0);
		
		if (miaStrada.getNumeroElementi() == 0) 
			System.out.println(MESS_STRADA_VUOTA);
		
		System.out.println(ARRIVEDERCI);
		
	}
	
	private static void setPercentuali(Strada miaStrada) {
		
		boolean finito = false;
		
		do {
			
			System.out.println(MESS_PERCENTUALE_VUOTI);
			int vuoti = MyUtil.leggiInt(0, 100);
			System.out.println(MESS_PERCENTUALE_PEDONI);
			int pedoni = MyUtil.leggiInt(0, 100);
			System.out.println(MESS_PERCENTUALE_AUTO);
			int auto = MyUtil.leggiInt(0, 100);
		
			try {
			
				miaStrada.setPercentuali(vuoti, pedoni, auto);
				finito = true;
				
			} catch (ArithmeticException exc) {
			
				System.out.print(exc.getMessage());
				System.out.println(MESS_INSERIRE_NUOVE_PERCENTUALI);
			
			}
		
		} while (!finito);
		
	}
	
	private static Strada setDimensioneStrada() {
		
		System.out.println(MESS_NUMERO_RIGHE);
		int righe = MyUtil.leggiInt(MIN_RIGHE, MAX_RIGHE);
		System.out.println(MESS_NUMERO_COLONNE);
		int colonne = MyUtil.leggiInt(MIN_COLONNE, MAX_COLONNE);
		
		return new Strada(righe, colonne);
		
	}
	
}
