package info.duhovniy.maxim.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Settings extends AppCompatActivity implements View.OnClickListener {

    private String newPassword;

    private Button changePassword;
    private EditText newPassword1;
    private EditText newPassword2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        changePassword = (Button) findViewById(R.id.buttonChangePassword);
        newPassword1 = (EditText) findViewById(R.id.newPassword1);
        newPassword2 = (EditText) findViewById(R.id.newPassword2);

        changePassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        newPassword = String.valueOf(newPassword1.getText());
        if(newPassword.equals(String.valueOf(newPassword2.getText()))) {
            Intent intent = new Intent(Settings.this, MainActivity.class);
            intent.putExtra("info.duhovniy.maxim.newPassword", newPassword);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "passwords are different!", Toast.LENGTH_SHORT).show();
        }
    }
}
