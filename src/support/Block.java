package support;

public class Block {
	private float var;
	private float min;
	private float max;
	
	
	public Block(float var, float min, float max) {
		super();
		this.var = var;
		this.min = min;
		this.max = max;
	}


	public float clamp() {
		if(var >= max)
			return var = max;
		else if(var <= min) 
			return var = min;
		else 
			return var;
		
	}
}
