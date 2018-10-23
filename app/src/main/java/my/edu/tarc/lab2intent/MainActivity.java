package my.edu.tarc.lab2intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG_MESSAGE = "my.edu.tarc.lab2intent.MESSAGE";
    private EditText editTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link UI to program
        editTextMessage = findViewById(R.id.editTextMessage);
    }

    public void sendMessage(View view){
        String stringMessage;
        if(TextUtils.isEmpty(editTextMessage.getText())){
            editTextMessage.setError("Please enter your message");
            return;
        }
        stringMessage = editTextMessage.getText().toString();

        //pass data to secondActivity
        //"this"refer to main activity
        Intent intent = new Intent(this,SecondActivity.class);

        //putExtra is used to pass data
        //intent.putExtra(name:"TAG_NAME", value:"VALUE");
        intent.putExtra(TAG_MESSAGE,stringMessage);
        startActivity(intent);
    }
}
