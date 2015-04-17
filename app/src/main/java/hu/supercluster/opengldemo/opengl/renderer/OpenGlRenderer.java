package hu.supercluster.opengldemo.opengl.renderer;

import javax.microedition.khronos.opengles.GL10;

import hu.supercluster.opengldemo.opengl.shape.Shape;
import hu.supercluster.opengldemo.opengl.shape.Square;

public class OpenGlRenderer extends AbstractOpenGlRenderer {
    Shape square;

    public OpenGlRenderer() {
        square = new Square();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        super.onDrawFrame(gl);

        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -40);
        square.draw(gl);
    }
}
