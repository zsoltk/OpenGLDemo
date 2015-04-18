package hu.supercluster.opengldemo.opengl.renderer;

import javax.microedition.khronos.opengles.GL10;

import hu.supercluster.opengldemo.opengl.mesh.AbstractMesh;
import hu.supercluster.opengldemo.opengl.mesh.Mesh;
import hu.supercluster.opengldemo.opengl.mesh.SmoothColoredCube;
import hu.supercluster.opengldemo.opengl.mesh.SmoothColoredSquare;

public class OpenGLRenderer extends AbstractOpenGLRenderer {
    private Mesh square;
    private AbstractMesh cube;
    private float angle;
    private int demo;

    public OpenGLRenderer() {
        square = new SmoothColoredSquare();
        cube = new SmoothColoredCube(3, 3, 3);
        angle = 0f;
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        super.onDrawFrame(gl);

        gl.glLoadIdentity();
        demo(gl);
        angle++;
    }

    private void demo(GL10 gl) {
        switch (demo) {
            case 0:
                squares(gl);
                break;

            case 1:
                cube(gl);
                break;

            case 2:
                cubes(gl);
                break;
        }
    }

    private void squares(GL10 gl) {
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
    }

    private void cube(GL10 gl) {
        gl.glTranslatef(0, 0, -20);
        cube.rx = angle;
        cube.ry = angle;
        cube.draw(gl);
    }

    private void cubes(GL10 gl) {
        gl.glTranslatef(0, 0, -20);
        cube.rx = angle;
        cube.ry = angle;
        cube.draw(gl);

        gl.glScalef(0.5f, 0.5f, 0.5f);
        gl.glTranslatef(10, 0, 0);
        gl.glRotatef(-angle * 2, 0, 1.0f, 1.0f);
        cube.draw(gl);

        gl.glScalef(0.5f, 0.5f, 0.5f);
        gl.glTranslatef(10, 0, 0);
        gl.glRotatef(angle * 4, 1.0f, 0, 1.0f);
        cube.draw(gl);
    }

    public void nextDemo() {
        demo++;

        if (demo > 2) {
            demo = 0;
        }
    }
}
