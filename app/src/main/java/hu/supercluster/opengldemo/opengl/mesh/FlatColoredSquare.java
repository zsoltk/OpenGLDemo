package hu.supercluster.opengldemo.opengl.mesh;

import javax.microedition.khronos.opengles.GL10;

public class FlatColoredSquare extends Square {
    @Override
    protected void doDraw(GL10 gl) {
        gl.glColor4f(0, 1.0f, 1.0f, 1.0f);
        super.doDraw(gl);
    }
}