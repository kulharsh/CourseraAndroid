package com.example.harshad.projectweek5;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SeekBar seekbar = (SeekBar) findViewById(R.id.seekbar);
        final ImageView imageView1 = (ImageView) findViewById(R.id.imageView1);
        final ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
        final ImageView imageView3 = (ImageView) findViewById(R.id.imageView3);
        final ImageView imageView4 = (ImageView) findViewById(R.id.imageView4);
        final ImageView imageView5 = (ImageView) findViewById(R.id.imageView5);

        int progress = 0;
        imageView1.setBackgroundColor(Color.rgb((int) (progress/100.0 * 256), 0, 100));
        imageView2.setBackgroundColor(Color.rgb((int) (progress/100.0 * 256), 50, 100));
        imageView3.setBackgroundColor(Color.rgb(120, 0, (int) (progress/100.0 * 256)));
        imageView4.setBackgroundColor(Color.rgb(120, 50, (int) (progress/100.0 * 256)));
        imageView5.setBackgroundColor(Color.rgb(255,255,255));

        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser)
                {
                    imageView1.setBackgroundColor(Color.rgb((int) (progress/100.0 * 255), 0, 100));
                    imageView2.setBackgroundColor(Color.rgb((int) (progress/100.0 * 255), 50, 100));
                    imageView3.setBackgroundColor(Color.rgb(120, 0, (int) (progress/100.0 * 255)));
                    imageView4.setBackgroundColor(Color.rgb(120, 50, (int) (progress/100.0 * 255)));

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

// 2. Chain together various setter methods to set the dialog characteristics
            builder.setMessage("Inspired by the works of artists such as Piet Mondrian and Ben Nicholson.\n Click below to learn more!");
            builder.setPositiveButton("Visit MOMA", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User clicked OK button
                    Uri uri = Uri.parse("http://www.moma.org"); // missing 'http://' will cause crashed
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("Not now", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // User cancelled the dialog
                }
            });
// 3. Get the AlertDialog from create()
            AlertDialog dialog = builder.create();
            dialog.show();
        }

        return super.onOptionsItemSelected(item);
    }
}
