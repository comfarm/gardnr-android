package com.gradnr.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v4.BuildConfig;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Toast;

import com.afollestad.materialcamera.MaterialCamera;
import com.bumptech.glide.Glide;
import com.gradnr.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlantActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int TAKE_PHOTO = 1;
    private final static int CAMERA_RQ = 6969;

    @BindView(R.id.imageButton)
    ImageButton plantImageButton;
    @BindView(R.id.plant_progressDate)
    TextInputLayout progressDate;

    StrictMode.VmPolicy.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);

        ButterKnife.bind(this);
        builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        progressDate.setOnClickListener(this);
        plantImageButton.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == TAKE_PHOTO && resultCode == RESULT_OK) {
//            Bundle b = data.getExtras();
//            Bitmap bm = (Bitmap) b.get("data");
//            Glide.with(getApplicationContext()).load(bm).into(plantImageButton);
//        }

        // Received recording or error from MaterialCamera
        if (requestCode == CAMERA_RQ) {

            if (resultCode == RESULT_OK) {
//                Toast.makeText(this, "Saved to: " + data.getDataString(), Toast.LENGTH_LONG).show();
                Glide.with(getApplicationContext()).load(data.getDataString()).into(plantImageButton);
            } else if(data != null) {
                Exception e = (Exception) data.getSerializableExtra(MaterialCamera.ERROR_EXTRA);
                e.printStackTrace();
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageButton:
                new MaterialCamera(this)
                        /** all the previous methods can be called, but video ones would be ignored */
                        .stillShot() // launches the Camera in stillshot mode
                        .start(CAMERA_RQ);
                break;
            case R.id.plant_progressDate:
                DatePickerDialog dpd = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        progressDate.getEditText().setText(i + "/" + i1 + "/" + i2);
                    }
                }, Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH);
                dpd.show();Toast.makeText(this, "oops", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(this, "oops", Toast.LENGTH_LONG).show();
                break;
        }

//
//        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
//
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
//
//        File output = new File(dir, "PLNT_"+timeStamp+".png");
//
//
//
//
//        Uri photoUri = Uri.fromFile(output);
//
////        Uri photoUri = FileProvider.getUriForFile(getBaseContext(), BuildConfig.APPLICATION_ID + ".provider", output);
//        Log.i("photoUri", photoUri.getPath());
//
//        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
//        String filePath= output.getAbsolutePath();
//        startActivityForResult(cameraIntent, TAKE_PHOTO);
//
////        // Create Bitmap from sd-card.
////        Bitmap bitmap = BitmapFactory.decodeFile(filePath);
////        plantImageButton.setImageBitmap(bitmap);
    }
}
