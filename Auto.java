public class Auto extends Elemento {
	
	private final static int VELOCITA_AUTO = 3;
	
	public Auto( int x, int y, int velocità){
		
		super(x,  y, VELOCITA_AUTO);
		
	}
	
	@Override
	public String toString(){
		
		return "A";
		
	}
	
	@Override
	public int getAscissa(){
		
		return x;
		
	}
	
	@Override
	public int getOrdinata(){
		
		return y;
		
	}
	
	@Override
	public void move(){
		
		x+= VELOCITA_AUTO;
	
	}

}
