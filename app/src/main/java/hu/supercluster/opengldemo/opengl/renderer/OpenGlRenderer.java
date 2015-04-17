package hu.supercluster.opengldemo.opengl.renderer;

import javax.microedition.khronos.opengles.GL10;

import hu.supercluster.opengldemo.opengl.mesh.Mesh;
import hu.supercluster.opengldemo.opengl.mesh.SmoothColoredSquare;

public class OpenGlRenderer extends AbstractOpenGlRenderer {
    private Mesh square;
    private float angle;

    public OpenGlRenderer() {
        square = new SmoothColoredSquare();
        angle = 0f;
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        super.onDrawFrame(gl);

        gl.glLoadIdentity();

        gl.glTranslatef(0, 0, -20);
        gl.glRotatef(angle, 0, 0, 1.0f);
        square.draw(gl);

        gl.glScalef(0.5f, 0.5f, 0.5f);
        gl.glTranslatef(10, 0, 0);
        gl.glRotatef(-angle * 2, 0, 0, 1.0f);
        square.draw(gl);

        gl.glScalef(0.5f, 0.5f, 0.5f);
        gl.glTranslatef(10, 0, 0);
        gl.glRotatef(angle * 4, 0, 0, 1.0f);
        square.draw(gl);

        gl.glScalef(0.5f, 0.5f, 0.5f);
        gl.glTranslatef(7, 0, 0);
        gl.glRotatef(-angle * 6, 0, 0, 1.0f);
        square.draw(gl);

        angle++;
    }
}
