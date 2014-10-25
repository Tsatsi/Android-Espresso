package com.thoughtworks.android_espresso;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends Activity {

    EditText userNameEditText;
    EditText passwordEditText;
    TextView errorMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameEditText = (EditText) findViewById(R.id.user_name);
        errorMessageTextView = (TextView) findViewById(R.id.error_message);
        passwordEditText = (EditText) findViewById(R.id.password);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void login(View view) {
        CharSequence userName= userNameEditText.getText().toString().trim();
        String password= passwordEditText.getText().toString();

        if(!isValidEmail(userName)){
            errorMessageTextView.setText("Incorrect email address");
        }
        else if(!isValidCredentials(userName.toString(), password)) {
            errorMessageTextView.setText("Wrong username / password");
        }
        else{
            startActivity(new Intent(this, WelcomeActivity.class));
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return (username.equals("tsatsi.mahase@gmail.com") && password.equals("Password123"));
    }

    public void registerLink(View view) {
    }
    private final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
