package by.bsu.andrew.camerademo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView iw;
    public static final int CAPTURE_CODE=10;
    Uri uri;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iw = findViewById(R.id.imageView);
        preferences = getSharedPreferences("init_data",MODE_PRIVATE);
        String addr = preferences.getString("myaddr","");
        if(!addr.equalsIgnoreCase("")){
           iw.setImageURI(Uri.parse(addr));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CAPTURE_CODE && resultCode==RESULT_OK){
           uri = data.getData();
           iw.setImageURI(uri);
           SharedPreferences.Editor editor = preferences.edit();
           editor.putString("myaddr",uri.toString());
           editor.apply();

           editor.p
        }

    }

    public void takePhoto(View view) {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("image/*");
        startActivityForResult(intent,CAPTURE_CODE);
    }
}
