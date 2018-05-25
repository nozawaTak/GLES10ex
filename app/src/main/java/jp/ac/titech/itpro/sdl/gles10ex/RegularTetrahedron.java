package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

// 正四面体のクラス
public class RegularTetrahedron implements SimpleRenderer.Obj {

    private final static float[] VERTICES = {
            // front
            1, 1, 1,
            -1, 1, -1,
            1, -1, -1,
            // back
            1, 1, 1,
            -1, 1, -1,
            -1, -1, 1,
            // right
            1, 1, 1,
            1, -1, -1,
            -1, -1, 1,
            // left
            -1, 1, -1,
            1, -1, -1,
            -1, -1, 1
    };

    private final FloatBuffer vbuf;

    RegularTetrahedron() {
        vbuf = ByteBuffer.allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // front
        gl.glNormal3f(1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3);

        // back
        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // right
        gl.glNormal3f(1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // left
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);
    }
}
