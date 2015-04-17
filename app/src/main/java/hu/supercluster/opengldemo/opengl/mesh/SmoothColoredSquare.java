package hu.supercluster.opengldemo.opengl.mesh;

import javax.microedition.khronos.opengles.GL10;

public class SmoothColoredSquare extends Square {
    float[] colors = {
            0f, 1f, 1f, 1f, // vertex 0 cyan
            1f, 0f, 1f, 1f, // vertex 1 magenta
            1f, 0f, 0f, 1f, // vertex 2 yellow
            1f, 1f, 1f, 1f, // vertex 3 white
    };

    public SmoothColoredSquare() {
        super();
        initColorBuffer(colors);
    }

    @Override
    protected void doDraw(GL10 gl) {
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
        super.doDraw(gl);
    }
}