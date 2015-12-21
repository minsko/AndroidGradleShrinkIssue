package com.example.helloworld;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        TextView tv = (TextView) findViewById(R.id.hwtv);
        StringBuffer sb = new StringBuffer();
        sb.append("A: ").append(readXML(getApplicationContext(), R.raw.aa)).append("\n");
        sb.append("B: ").append(readXML(getApplicationContext(), "b")).append("\n");
        sb.append("C: ").append(readXML(getApplicationContext(), "c")).append("\n");
        sb.append("D: ").append(readXML(getApplicationContext(), "d")).append("\n");
        tv.setText(sb.toString());
    }
    private static String readXML(Context context, String name) {
        int id = 0;
        try {
            id = context.getResources().getIdentifier(name + name, "raw", "com.example.helloworld");
        } catch (Exception e) {
            return "ID not found.";
        }
        return readXML(context, id);
    }
    private static String readXML(Context context, int id) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(id)));
            String str;
            while ((str = in.readLine()) != null) {
                sb.append(str);
            }
        } catch (Exception e) {
          return "Error Reading: "+e;
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe) {}
            }
        }
        return sb.toString();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
