package vienan.app.patternlock;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.eftimoff.patternview.PatternView;
import com.faradaj.blurbehind.BlurBehind;


public class MainActivity extends Activity {

    private PatternView patternView;

    private String patternString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        patternView = (PatternView) findViewById(R.id.patternView);
        BlurBehind.getInstance()
                .withAlpha(80)
                .withFilterColor(Color.parseColor("#0075c0"))
                .setBackground(this);
        Toast.makeText(getApplicationContext(), "ENTER PATTERN", Toast.LENGTH_LONG).show();
        patternView.setOnPatternDetectedListener(new PatternView.OnPatternDetectedListener() {

            @Override
            public void onPatternDetected() {
                if (patternString == null) {
                    patternString = patternView.getPatternString();
//                    patternView.clearPattern();
                    return;
                }
                if (patternString.equals(patternView.getPatternString())) {
                    Toast.makeText(getApplicationContext(), "PATTERN CORRECT", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(getApplicationContext(), "PATTERN NOT CORRECT", Toast.LENGTH_SHORT).show();
//                patternView.clearPattern();
            }
        });

    }
}
