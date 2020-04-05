package id.dwichan.latihanview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView nyobainHTML, nyobainHTML2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nyobainHTML = (TextView) findViewById(R.id.nyobainHTML);
        String isiTeks = "Biasa <b>tebal</b> <i>miring</i> <a href='fb.com'>Link ke Facebook</a> <u>garis bawah</u> udah itu aja wkkw";

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            nyobainHTML.setText(Html.fromHtml(isiTeks, Html.FROM_HTML_MODE_LEGACY));
        } else {
            nyobainHTML.setText(Html.fromHtml(isiTeks));
        }

        nyobainHTML2 = (TextView) findViewById(R.id.nyobainHTMLPjg);
        String isiTeks2 = getString(R.string.FormatTeksPanjang);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            nyobainHTML2.setText(Html.fromHtml(isiTeks2, Html.FROM_HTML_MODE_LEGACY));
        } else {
            nyobainHTML2.setText(Html.fromHtml(isiTeks2));
        }

        final EditText btnKirim = (EditText) findViewById(R.id.btnKirim);
        btnKirim.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Toast.makeText(MainActivity.this, "Sended: " + btnKirim.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        final EditText btnCari = (EditText) findViewById(R.id.btnCari);
        btnCari.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    Toast.makeText(MainActivity.this, "Search: " + btnCari.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });

        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.acTextView);
        String[] countries = {"Indonesia", "India", "Inggris", "China", "Korea", "Jepang"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        acTextView.setAdapter(adapter);
    }
}
