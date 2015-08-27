package info.duhovniy.maxim.myaccount;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String userName = "maxim.duhovniy@gmail.com";
    public static String userPassword = "hello";

    protected Button enterButton;
    private EditText emailTextInput;
    private EditText passwordTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterButton = (Button) findViewById(R.id.enterButton);
        emailTextInput = (EditText) findViewById(R.id.editEmail);
        passwordTextInput = (EditText) findViewById(R.id.editPassword);

        enterButton.setOnClickListener(this);

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

    @Override
    public void onClick(View v) {
        if(String.valueOf(emailTextInput.getText()).equals(userName) && String
                .valueOf(passwordTextInput.getText()).equals(userPassword)) {
            Intent intent = new Intent(MainActivity.this, Calculator.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Try again)", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        emailTextInput.setText("");
        passwordTextInput.setText("");
    }
}
