package org.jzy3d.maths;

public class Scale {
	
	public Scale(float min, float max){
		this.min = min;
		this.max = max;
	}
	
	public Scale clone(){
		return new Scale(min, max);
	}

	public float getMin(){
		return min;
	}
	
	public float getMax(){
		return max;
	}
	
	public float getRange(){
		return max-min;
	}
	
	public void setMin(float min){
		this.min = min;
	}
	
	public void setMax(float max){
		this.max = max;
	}
	
	public Scale add(float value){
		return new Scale(min+value, max+value);
	}
	
	public boolean contains(float value){
		if( min<=value && value<=max)
			return true;
		else
			return false;
	}
	
	public boolean isMaxNan(){
		return Double.isNaN(max);
	}
	
	public boolean isMinNan(){
		return Double.isNaN(min);
	}

	public boolean valid(){
		if(min<=max)
			return true;
		return false;
	}

	/* */
	
	public static Scale widest(Scale scale1, Scale scale2){
		float min = Math.min(scale1.min, scale2.min);
		float max = Math.max(scale1.max, scale2.max);
		
		return new Scale(min, max);
	}
	
	public static Scale thinest(Scale scale1, Scale scale2){
		float min = Math.max(scale1.min, scale2.min);
		float max = Math.min(scale1.max, scale2.max);
		
		return new Scale(min, max);
	}
	
	public static Scale enlarge(Scale input, float ratio){
		float offset = (input.getMax()-input.getMin()) * ratio;
		if(offset==0)
    		offset=1;
    	return new Scale(input.getMin()-offset, input.getMax()+offset);
	}
	
	public String toString(){
		return new String("min="+min+" max="+max);
	}
	
	protected float min, max;
}
