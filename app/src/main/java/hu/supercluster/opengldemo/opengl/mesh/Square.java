package hu.supercluster.opengldemo.opengl.mesh;

import javax.microedition.khronos.opengles.GL10;

public class Square extends AbstractMesh {

    private short[] connectionIndices = { 0, 1, 2, 0, 2, 3 };

    public Square() {
        float[] vertices = {
                -1.0f, 1.0f, 0.0f,  // 0, Top Left
                -1.0f, -1.0f, 0.0f,  // 1, Bottom Left
                1.0f, -1.0f, 0.0f,  // 2, Bottom Right
                1.0f, 1.0f, 0.0f,  // 3, Top Right
        };

        setVertices(vertices);
        setIndices(connectionIndices);
    }

    @Override
    protected void doDraw(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, connectionIndices.length, GL10.GL_UNSIGNED_SHORT, indexBuffer);
    }
}