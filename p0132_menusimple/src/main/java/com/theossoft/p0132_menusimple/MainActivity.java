package com.theossoft.p0132_menusimple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
//        if (id == R.id.action_setting) {
//            Toast.makeText(MainActivity.this, getString(R.string.action_settins), Toast.LENGTH_LONG).show();
//        }

        switch (id) {
            case R.id.action_setting:
                Toast.makeText(MainActivity.this, getString(R.string.action_settins), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_item1:
                Toast.makeText(MainActivity.this, getString(R.string.action_item1), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_item2:
                Toast.makeText(MainActivity.this, getString(R.string.action_item2), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_item3:
                Toast.makeText(MainActivity.this, getString(R.string.action_item3), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}