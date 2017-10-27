package code;

public class Block {
	private int var;
	private int min;
	private int max;
	
	
	public Block(int var, int min, int max) {
		super();
		this.var = var;
		this.min = min;
		this.max = max;
	}


	public int clamp() {
		if(var >= max)
			return var = max;
		else if(var <= min) 
			return var = min;
		else 
			return var;
		
	}
}
