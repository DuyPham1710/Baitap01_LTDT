package vn.duy.baitap01;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnLogNumber;
    private EditText editText;
    private TextView text;
    private Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        btnLogNumber =  findViewById(R.id.btnLogNumbers);

        btnLogNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLog(randomArray(20));
            }
        });

        editText = findViewById(R.id.editTextInput);
        text = findViewById(R.id.textViewResult);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text.setText(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnToast = findViewById(R.id.btnToast);
        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = text.getText().toString();
                if (!inputText.isEmpty()) {
                    String reversedText = reverse(inputText);
                    Toast.makeText(MainActivity.this, reversedText, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private ArrayList<Integer> randomArray(int size) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i=0; i<size; i++) {
            numbers.add(random.nextInt(100));
        }
        return numbers;
    }

    private void showLog(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        for (int number : numbers) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
            else {
                oddNumbers.add(number);
            }
        }

        Log.d("ArrayList","Dánh sách số chẵn: " + evenNumbers);
        Log.d("ArrayList","Dánh sách số lẻ: " + oddNumbers);
    }

    private String reverse(String text) {
        String[] words = text.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            reversed.append(words[i].toUpperCase()).append(" ");
        }
        return reversed.toString().trim();
    }
}