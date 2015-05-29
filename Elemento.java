public abstract class Elemento {
	
	protected int x, y, velocità;
	
	public Elemento( int x, int y, int velocità){
		
		this.x = x;
		this.y = y;
		this.velocità = velocità;
		
	}
	
	public abstract String toString();
	
	public abstract int getAscissa();
	
	public abstract int getOrdinata();
	
	public abstract void move();
	
	

}
