package hu.supercluster.opengldemo.opengl.renderer;

import javax.microedition.khronos.opengles.GL10;

import hu.supercluster.opengldemo.opengl.shape.Shape;
import hu.supercluster.opengldemo.opengl.shape.Square;
import hu.supercluster.opengldemo.opengl.shape.FlatColoredSquare;
import hu.supercluster.opengldemo.opengl.shape.SmoothColoredSquare;

public class OpenGlRenderer extends AbstractOpenGlRenderer {
    Shape square;

    public OpenGlRenderer() {
        square = new SmoothColoredSquare();
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        super.onDrawFrame(gl);

        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -20);
        square.draw(gl);
    }
}
