package com.example.app;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    Button btnClick;
    Button button1;
    Button button2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mennu);

        btnClick = findViewById(R.id.btn12);
        button1 = findViewById(R.id.btn123);
        button2 = findViewById(R.id.btn1234);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });


        registerForContextMenu(btnClick);


    }

    public void showMenu(View v){
        PopupMenu popup = new PopupMenu(this,v);
        //this activity implements OnMenuItemClickListener

        popup.setOnMenuItemClickListener((PopupMenu.OnMenuItemClickListener) this);
        popup.inflate(R.menu.menu1);
        popup.show();

    }

    //PopUpMEnu
    @Override
    public boolean onMenuItemClick(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.item1)
        {
            Toast.makeText(getApplicationContext(), "Item1 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        }
        else if (id == R.id.item2)
        {
            Toast.makeText(getApplicationContext(), "Item2 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        }
        else if (id == R.id.item3)
        {
            Toast.makeText(getApplicationContext(), "Item3 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        }
        else{

            return super.onContextItemSelected(item);
        }
    }


    //dialog
    public void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
        builder.setTitle("Exit App");
        builder.setMessage("Do you want to exit App?");
        builder.setCancelable(true);

        builder.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        builder.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();


    }


    //contextMenu

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.item1)
        {
            Toast.makeText(getApplicationContext(), "Item1 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        }
        else if (id == R.id.item2)
        {
            Toast.makeText(getApplicationContext(), "Item2 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        }
        else if (id == R.id.item3)
        {
            Toast.makeText(getApplicationContext(), "Item3 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        }
        else{

                return super.onContextItemSelected(item);
        }
    }





    //options menu

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast.makeText(getApplicationContext(), "Item1 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        } else if (id == R.id.item2) {
            Toast.makeText(getApplicationContext(), "Item2 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        }

        else if (id == R.id.item3) {
            Toast.makeText(getApplicationContext(), "Item3 selected",
                    Toast.LENGTH_LONG).show();
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }

}
