package hu.supercluster.opengldemo.opengl.shape;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public abstract class AbstractShape implements Shape {
    protected FloatBuffer vertexBuffer;
    protected ShortBuffer indexBuffer;

    protected void initIndexBuffer(short[] connectionIndices) {
        indexBuffer = AllocationHelper.allocateShortBuffer(connectionIndices);
    }

    protected void initVertexBuffer(float[] vertices) {
        vertexBuffer = AllocationHelper.allocateFloatBuffer(vertices);
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
    }

    protected abstract void doDraw(GL10 gl);

    private void onPostDraw(GL10 gl) {
        GlHelper.disableVertexBuffer(gl);
        GlHelper.disableFaceCulling(gl);
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

    private static class GlHelper {
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
    }
}
