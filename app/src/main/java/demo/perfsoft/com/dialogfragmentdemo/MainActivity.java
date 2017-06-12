package demo.perfsoft.com.dialogfragmentdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MyCustomDialogFragment.OnTextSubmit {
    private Button btnShow;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.btnShow);
        tv = (TextView) findViewById(R.id.tv);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCustomDialogFragment dialogFragment = new MyCustomDialogFragment();
                dialogFragment.setOnTextSubmit(MainActivity.this);
                dialogFragment.show(getFragmentManager(),"tag1");

            }
        });
    }

    @Override
    public void onTextSubmitted(String value) {
        tv.setText(value);
    }
}
