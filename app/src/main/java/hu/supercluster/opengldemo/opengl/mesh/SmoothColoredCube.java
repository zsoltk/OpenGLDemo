package hu.supercluster.opengldemo.opengl.mesh;

import javax.microedition.khronos.opengles.GL10;

public class SmoothColoredCube extends Cube {
    public SmoothColoredCube(float width, float height, float depth) {
        super(width, height, depth);

        float[] colors = {
                 0,  1f,  1f,  1f,
                1f,   0,  1f,  1f,
                1f,   0,   0,  1f,
                1f,  1f,  1f,  1f,

                 0, .5f, .5f, .2f,
               .5f,   0, .5f, .2f,
               .5f,   0,   0, .2f,
               .5f, .5f, .5f, .2f,
        };

        setColors(colors);
    }

    @Override
    protected void doDraw(GL10 gl) {
        gl.glColorPointer(4, GL10.GL_FLOAT, 0, colorBuffer);
        super.doDraw(gl);
    }
}