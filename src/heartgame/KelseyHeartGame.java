package heartgame;

import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GL2ES1;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.fixedfunc.GLMatrixFunc;



import javax.swing.event.MouseInputListener;

import com.jogamp.opengl.util.Animator;

public class KelseyHeartGame implements GLEventListener, KeyListener, MouseInputListener {

	 
		private float rotateT = 0.0f;
	 
		private final float cslices = 100.0f;
		private final float cheight = 0.5f;
		
	
		
		@Override
		public void display(GLAutoDrawable gLDrawable) {
			final GL2 gl = gLDrawable.getGL().getGL2();
			gl.glClear(GL.GL_COLOR_BUFFER_BIT);
			gl.glClear(GL.GL_DEPTH_BUFFER_BIT);
			gl.glLoadIdentity();
			gl.glTranslatef(0.0f, 0.0f, -5.0f);
	 
			// rotate about the three axes
			gl.glRotatef(rotateT, 0.0f, 0.0f, 0.50f);
			gl.glRotatef(rotateT, 0.0f, 0.50f, 0.0f);
			gl.glRotatef(rotateT, 0.50f, 0.0f, 0.0f);
	
			gl.glColor4f(0.2f, 0.1f, 0.8f, 0.2f);
			cyl( 0, 1.0f, gLDrawable);
			gl.glColor3f(0.4f, 0.2f, 0.2f);
			cyl( 0, 0.8f, gLDrawable );
			// increasing rotation for the next iteration                   
			rotateT += 0.02f; 
		}
	 
		@Override
		public void init(GLAutoDrawable glDrawable) {
			GL2 gl = glDrawable.getGL().getGL2();
			gl.glShadeModel(GLLightingFunc.GL_SMOOTH);
			gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
			gl.glClearDepth(1.0f);
			gl.glEnable(GL.GL_BLEND);
			gl.glBlendFunc(GL.GL_ONE_MINUS_DST_ALPHA, GL.GL_DST_ALPHA);
			//gl.glEnable(GL.GL_DEPTH_TEST);
			gl.glDepthFunc(GL.GL_LEQUAL);
			gl.glHint(GL2ES1.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);
		}
	 
		@Override
		public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
			GL2 gl = gLDrawable.getGL().getGL2();
			final float aspect = (float) width / (float) height;
			gl.glMatrixMode(GLMatrixFunc.GL_PROJECTION);
			gl.glLoadIdentity();
			final float fh = 0.5f;
			final float fw = fh * aspect;
			gl.glFrustumf(-fw, fw, -fh, fh, 1.0f, 1000.0f);
			gl.glMatrixMode(GLMatrixFunc.GL_MODELVIEW);
			gl.glLoadIdentity();
		}
	 
		@Override
		public void dispose(GLAutoDrawable gLDrawable) {
		}
	 
		public static void main(String[] args) {
			final GLCanvas canvas = new GLCanvas();
			final Frame frame = new Frame("Circle Tetris");
			final Animator animator = new Animator(canvas);
			canvas.addGLEventListener(new KelseyHeartGame());
			
			frame.add(canvas);
			frame.setSize(640, 480);
			frame.setResizable(false);
			frame.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					animator.stop();
					frame.dispose();
					System.exit(0);
				}
			});
			frame.setVisible(true);
			animator.setRunAsFastAsPossible(false);
			animator.start();
			canvas.requestFocus();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
