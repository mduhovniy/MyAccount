package info.duhovniy.maxim.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Created by maxduhovniy on 8/28/15.
 */
public class MainMenu extends AppCompatActivity implements OnClickListener {

    private Button buttonCalculator;
    private Button buttonAlbum;
    private Button buttonInternet;
    private Button buttonCall;
    private Button buttonEmail;
    private Button buttonCamera;
    private Button buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        buttonCalculator = (Button) findViewById(R.id.butCalculator);
        buttonAlbum = (Button) findViewById(R.id.butAlbum);
        buttonInternet = (Button) findViewById(R.id.butInternet);
        buttonCall = (Button) findViewById(R.id.butCall);
        buttonEmail = (Button) findViewById(R.id.butEmail);
        buttonCamera = (Button) findViewById(R.id.butCamera);
        buttonSettings = (Button) findViewById(R.id.butSettings);

        buttonCalculator.setOnClickListener(this);
        buttonAlbum.setOnClickListener(this);
        buttonInternet.setOnClickListener(this);
        buttonCall.setOnClickListener(this);
        buttonEmail.setOnClickListener(this);
        buttonCamera.setOnClickListener(this);
        buttonSettings.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.butCalculator:
                Intent intent1 = new Intent(MainMenu.this, Calculator.class);
                startActivity(intent1);
                break;
            case R.id.butAlbum:
                Intent intent2 = new Intent(MainMenu.this, Album.class);
                startActivity(intent2);
                break;
            case R.id.butInternet:

                break;
            case R.id.butCall:

                break;
            case R.id.butEmail:

                break;
            case R.id.butCamera:

                break;
            case R.id.butSettings:
                Intent intent7 = new Intent(MainMenu.this, Settings.class);
                startActivity(intent7);
                break;
        }

    }
}
