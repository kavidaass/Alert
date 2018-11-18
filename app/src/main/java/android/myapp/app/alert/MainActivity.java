package android.myapp.app.alert;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showalert(View view){
        LayoutInflater showlayout  = getLayoutInflater();
        View custom = showlayout.inflate(R.layout.alert_layout,null);

        final AlertDialog altdialogue = new AlertDialog.Builder(MainActivity.this).create();
        altdialogue.setView(custom);
        altdialogue.setCancelable(false);
        altdialogue.show();

        Button btn  = (Button)custom.findViewById(R.id.btn_login);
        Button btnc  = (Button)custom.findViewById(R.id.btn_cancel);
        final TextInputEditText user= (TextInputEditText)custom.findViewById(R.id.username);
        final TextInputEditText pass= (TextInputEditText)custom.findViewById(R.id.userpass);
        final TextInputLayout userlayout = (TextInputLayout)custom.findViewById(R.id.userlayout);
        final TextInputLayout passlayout = (TextInputLayout)custom.findViewById(R.id.userpasslayout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().isEmpty()){
                    userlayout.setError("user name can't be empty");
                }
                else if(pass.getText().toString().isEmpty()){
                    passlayout.setError("password can't be Empty");
                }
            else
                {
                    Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_LONG).show();
               user.setText(null);
               pass.setText(null);
               userlayout.setError(null);
               passlayout.setError(null);
                }


            }

        });

        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                altdialogue.dismiss();
            }
        });
    }


}
