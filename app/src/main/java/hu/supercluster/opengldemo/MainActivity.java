package hu.supercluster.opengldemo;

import android.app.Activity;
import android.opengl.GLSurfaceView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Fullscreen;
import org.androidannotations.annotations.ViewById;

import hu.supercluster.opengldemo.opengl.renderer.OpenGlRenderer;


@EActivity(R.layout.activity_main)
@Fullscreen
public class MainActivity extends Activity {
    @ViewById
    GLSurfaceView glSurfaceView;

    @AfterViews
    void init() {
        glSurfaceView.setRenderer(new OpenGlRenderer());
    }
}
