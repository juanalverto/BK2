package com.belikeu.wilder.bk2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.GradientDrawable;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
// member variables del ActionBar

    private Button mSharePicture;

    public static final int TAKE_PHOTO_REQUEST = 0;
    public static final int PICK_PHOTO_REQUEST = 1;

    ImageView iv;


    //Code onclick listener de los botones Action bar

    protected DialogInterface.OnClickListener mDialogListener =
            new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which){
                    switch (which){
                        case 0: // Take picture
                            Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(takePhotoIntent, TAKE_PHOTO_REQUEST );


                            break;
                        case 1: // Pick Photo




                    }


                }



            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.imageView);

        Button btn = (Button) findViewById(R.id.takePhoto);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                startActivityForResult(intent,0);
            }
        });



    }

    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 0)

        {
            Bitmap theImage = (Bitmap) data.getExtras().get("data");
            iv.setImageBitmap(theImage);

            iv.setRotation(90);


        }

       }



    // ActionBar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_share, menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.






        int id = item.getItemId();

        switch (id) {

            case R.id.action_camera:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setItems(R.array.camera_choices, mDialogListener);
                AlertDialog dialog = builder.create();
                dialog.show();
                break;

            case R.id.action_search:

                Intent intent = new Intent(this, Share.class);
                startActivity(intent);


                //mSharePicture.setOnClickListener(new View.OnClickListener() {
                    //@Override
                    //public void onClick(View v) {
                       // startShare();
                   // }


                //});







        }



        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//Button Share Picture

    //Metodo Start Share



    //private void startShare(){
       // Intent intent = new Intent(this, Share.class);
        //startActivity(intent);
    //}







}
