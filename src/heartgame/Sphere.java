package heartgame;

import javax.media.opengl.GLAutoDrawable;

public class Sphere {
	//    slice # xyz
	float[ ][ ][ ] vertexs;
	final int X = 0;
	final int Y = 1;
	final int Z = 2;
	float radius;
	int slices;
	float cx, cy, cz;
	boolean calcd;
	public Sphere(float radius, int slices){
		this.radius = radius;
		this.slices = slices;
		
		vertexs = new float[slices][][];
		
		//tops/bottoms
		vertexs[0] = new float[slices+1][3];
		vertexs[slices-1] = new float[slices+1][3];
		
		//centers double previous till equater 
		int inSlice = slices;
		for( int i = 1; i < slices / 2; i ++){
			inSlice *= 2;
			vertexs[i] = new float[inSlice+2][3];
			vertexs[slices-1-i]= new float[inSlice+2][3];
		}
		
		//odd case
		if( slices % 2 == 1){
			inSlice *=2;
			vertexs[(slices-1) / 2] =  new float[inSlice+2][3];
		}
		
		cx = 0;
		cy = 0;
		cz = 0;
		
		calcd = false;
	
	}
	
	public void setCenter( float x, float y, float z ){
		cx = x;
		cy = y;
		cz = z;
		
		
	}
	
	public void calc(){
		float divs = slices;
		float hoffset = 0;
		float voffset = 0;
		final float PI = (float)Math.PI;
		//top triangle fan
		//center
		vertexs[0][0][X] = cx;
		vertexs[0][0][Y] = cy;
		vertexs[0][0][Z] = cz + radius;
		for( int i = 1; i < slices; i++ ){
			vertexs[0][1][X] = 
			
		}
		//middles triangle strips
		for(){
			
		}
		
		//bottoms triangle fan
		for(){
			
		}
	}
	
	public void display( GLAutoDrawable glDrawable){
		if(!calcd){
		
		
		}
	}
	
}
