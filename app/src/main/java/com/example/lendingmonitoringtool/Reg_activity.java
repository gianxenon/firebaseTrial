package com.example.lendingmonitoringtool;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class Reg_activity extends AppCompatActivity {


    private CircleImageView ProfileImage;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;


    EditText editTextDate,edt_fn,edt,ln,edt_num,edt_bday,edt_email,edt_pass;
    DatePickerDialog.OnDateSetListener onDateSetListener;
    Button btn_done;

    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference reference = db.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);

         editTextDate  = findViewById(R.id.edt_bday);

        ProfileImage = (CircleImageView) findViewById(R.id.profile_image);
        ProfileImage.setOnClickListener(v -> {

            Intent gallery = new Intent();
            gallery.setType("image/*");
            gallery.setAction(Intent.ACTION_GET_CONTENT);

            startActivityForResult(Intent.createChooser(gallery, "Select Picture"), PICK_IMAGE);
        });
        editTextDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(Reg_activity.this, onDateSetListener, year, month, day);

            datePickerDialog.show();
        });

        onDateSetListener = (view, year, month, dayOfMonth) -> {
            month = month+1;
            String date = dayOfMonth + "/" + month + "/" + year;
            editTextDate.setText(date);
        };

        btn_done.setOnClickListener(v -> {



        });


    }//On Create

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();

            try {

                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                ProfileImage.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            } }
         }





    }//reg end
