package mrxxy.github.com.ratioimageview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import mrxxy.github.ratioimageview.RatioImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RatioImageView ratioImageView = findViewById(R.id.ratio_image);
//        ratioImageView.setRatio(16 / 9.0f);
        ratioImageView.setRatio(16, 9);
    }



}