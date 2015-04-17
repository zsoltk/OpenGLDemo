package hu.supercluster.opengldemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.OptionsItem;
import org.androidannotations.annotations.OptionsMenu;


@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.menu_main)
public class MainActivity extends ActionBarActivity {

    @OptionsItem(R.id.action_settings)
    void settings() {
        Toast.makeText(this, android.R.string.ok, Toast.LENGTH_SHORT).show();
    }
}
