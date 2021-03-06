package hu.supercluster.opengldemo;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.view.View;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;

import hu.supercluster.opengldemo.opengl.renderer.OpenGLRenderer;


@EActivity(R.layout.activity_main)
@Fullscreen
public class MainActivity extends Activity {
    @ViewById
    GLSurfaceView glSurfaceView;

    @AfterViews
    void init() {
        final OpenGLRenderer renderer = new OpenGLRenderer();

        glSurfaceView.setRenderer(renderer);
        glSurfaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                renderer.nextDemo();
            }
        });
    }
}
