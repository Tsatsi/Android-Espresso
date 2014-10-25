package com.thoughtworks.android_espresso;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class RegisterActivity extends Activity {

    EditText nameEditText;
    EditText surnameEditText;
    EditText userNameEditText;
    EditText passwordEditText;

    TextView errorMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameEditText = (EditText) findViewById(R.id.reg_name);
        surnameEditText = (EditText) findViewById(R.id.reg_surname);
        userNameEditText = (EditText) findViewById(R.id.user_name);
        passwordEditText = (EditText) findViewById(R.id.password);
        errorMessageTextView = (TextView) findViewById(R.id.error_message);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
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

    public void loginLink(View view) {
    }

    public void register(View view) {
        String name = nameEditText.getText().toString();
        String surname = surnameEditText.getText().toString();
        String username = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if(!isValidEmail(username)){
            errorMessageTextView.setText("Incorrect email address");
        }
        else if(name.isEmpty() || surname.isEmpty() || username.isEmpty() || password.isEmpty()){
            errorMessageTextView.setText("Please enter all details");
        }
        else if(username.equals("tsatsi.mahase@gmail.com")){
            errorMessageTextView.setText("Already have user registered with this email");
        }else{
            startActivity(new Intent(this, WelcomeActivity.class));
        }

    }

    private final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
