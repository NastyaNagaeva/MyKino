package com.example.mykino;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class filmDetails extends AppCompatActivity {

    TextView detailDesc, detailTitle;

    TextView dataYear, dataGanr, dataTime, dataAge, dataDirector;

    ImageView detailImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_details);

        //возможность вернуться на предыдущую активити
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detailDesc = findViewById(R.id.descriptionDetails);
        detailTitle = findViewById(R.id.titleDetail);
        detailImage = findViewById(R.id.imageDetails);

        dataYear = findViewById(R.id.yearDetails);
        dataGanr = findViewById(R.id.genreDetails);
        dataTime = findViewById(R.id.timeDetails);
        dataAge = findViewById(R.id.ageDetails);
        dataDirector = findViewById(R.id.directorDetails);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailDesc.setText(bundle.getString("Desc"));
            detailImage.setImageResource(bundle.getInt("Image"));
            detailTitle.setText(bundle.getString("Title"));

            dataYear.setText(bundle.getString("Year"));
            dataGanr.setText(bundle.getString("Ganr"));
            dataTime.setText(bundle.getString("Time"));
            dataAge.setText(bundle.getString("Age"));
            dataDirector.setText(bundle.getString("Director"));

        }


    }
}