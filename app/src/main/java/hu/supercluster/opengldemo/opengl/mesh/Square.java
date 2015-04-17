package hu.supercluster.opengldemo.opengl.mesh;

public class Square extends AbstractMesh {
    public Square() {
        float[] vertices = {
                -1.0f,  1.0f,  0.0f,  // 0, Top Left
                -1.0f, -1.0f,  0.0f,  // 1, Bottom Left
                 1.0f, -1.0f,  0.0f,  // 2, Bottom Right
                 1.0f,  1.0f,  0.0f,  // 3, Top Right
        };

        short[] connectionIndices = {0, 1, 2, 0, 2, 3};

        setVertices(vertices);
        setIndices(connectionIndices);
    }
}