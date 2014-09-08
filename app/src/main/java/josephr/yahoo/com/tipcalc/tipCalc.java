package josephr.yahoo.com.tipcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class tipCalc extends Activity {
    double billAmount;
    TextView viewableBillTotal;
    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calc);
        viewableBillTotal = (TextView) findViewById(R.id.tv_tip_value);
    }

    public void calculateClick(View v){
        switch (v.getId()) {
            case (R.id.bt_15):
                this.calculate(0.15);
                break;
            case (R.id.bt_18):
                this.calculate(0.18);
                break;
            case (R.id.bt_20):
                this.calculate(0.20);
                break;
        }
    }

    private void calculate(double d) {
        EditText billTotal = (EditText) findViewById(R.id.et_bill_total);
        billAmount = Double.parseDouble(billTotal.getText().toString());
        viewableBillTotal.setText("$" + df.format(billAmount * d));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calc, menu);
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
}
