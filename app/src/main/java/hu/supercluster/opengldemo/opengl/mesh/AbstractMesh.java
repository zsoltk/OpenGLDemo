package hu.supercluster.opengldemo.opengl.mesh;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public abstract class AbstractMesh implements Mesh {
    protected FloatBuffer vertexBuffer;
    protected ShortBuffer indexBuffer;
    protected FloatBuffer colorBuffer;
    protected int nbVertices;
    protected int nbIndices;
    protected int nbColors;

    // Translation params
    public float x = 0;
    public float y = 0;
    public float z = 0;

    // Rotate params
    public float rx = 0;
    public float ry = 0;
    public float rz = 0;

    protected void setVertices(float[] vertices) {
        vertexBuffer = AllocationHelper.allocateFloatBuffer(vertices);
        nbVertices = vertices.length;
    }

    protected void setIndices(short[] indices) {
        indexBuffer = AllocationHelper.allocateShortBuffer(indices);
        nbIndices = indices.length;
    }

    protected void setColors(float[] colors) {
        colorBuffer = AllocationHelper.allocateFloatBuffer(colors);
        nbColors = colors.length;
    }

    public final void draw(GL10 gl) {
        onPreDraw(gl);
        doDraw(gl);
        onPostDraw(gl);
    }

    private void onPreDraw(GL10 gl) {
        GlHelper.setWinding(gl);
        GlHelper.enableFaceCulling(gl);
        GlHelper.enableVertexBuffer(gl);
        translate(gl);
        rotate(gl);
        if (colorBuffer != null) {
            GlHelper.enableColorBuffer(gl);
        }
    }

    protected void translate(GL10 gl) {
        gl.glTranslatef(x, y, z);
    }

    private void rotate(GL10 gl) {
        gl.glRotatef(rx, 1, 0, 0);
        gl.glRotatef(ry, 0, 1, 0);
        gl.glRotatef(rz, 0, 0, 1);
    }

    protected void doDraw(GL10 gl) {
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawElements(GL10.GL_TRIANGLES, nbIndices, GL10.GL_UNSIGNED_SHORT, indexBuffer);
    }

    private void onPostDraw(GL10 gl) {
        GlHelper.disableFaceCulling(gl);
        GlHelper.disableVertexBuffer(gl);
        GlHelper.disableColorBuffer(gl);
    }
    
    private static class AllocationHelper {
        static FloatBuffer allocateFloatBuffer(float[] floats) {
            ByteBuffer bb = ByteBuffer.allocateDirect(floats.length * 4); // float is 4 bytes
            bb.order(ByteOrder.nativeOrder());

            FloatBuffer floatBuffer = bb.asFloatBuffer();
            floatBuffer.put(floats);
            floatBuffer.position(0);

            return floatBuffer;
        }

        static ShortBuffer allocateShortBuffer(short[] shorts) {
            ByteBuffer bb = ByteBuffer.allocateDirect(shorts.length * 2); // short is 2 bytes
            bb.order(ByteOrder.nativeOrder());

            ShortBuffer shortBuffer = bb.asShortBuffer();
            shortBuffer.put(shorts);
            shortBuffer.position(0);

            return shortBuffer;
        }
    }

    protected static class GlHelper {
        static void setWinding(GL10 gl) {
            gl.glFrontFace(GL10.GL_CCW);
        }

        static void enableFaceCulling(GL10 gl) {
            gl.glEnable(GL10.GL_CULL_FACE);
            gl.glCullFace(GL10.GL_BACK);
        }

        static void disableFaceCulling(GL10 gl) {
            gl.glDisable(GL10.GL_CULL_FACE);
        }

        static void enableVertexBuffer(GL10 gl) {
            gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        }

        static void disableVertexBuffer(GL10 gl) {
            gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        }

        public static void enableColorBuffer(GL10 gl) {
            gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
        }

        public static void disableColorBuffer(GL10 gl) {
            gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
        }
    }
}
