package com.example.grant.rectanglecalculator;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class RectangleCalculator extends AppCompatActivity {
    private static final NumberFormat FORMATTER = DecimalFormat.getNumberInstance();

    static {
        FORMATTER.setMinimumFractionDigits(1);
        FORMATTER.setMaximumFractionDigits(6);
        FORMATTER.setMinimumIntegerDigits(1);
    }

    private EditText widthText;
    private EditText heightText;
    private TextView areaText;
    private TextView perimeterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle_calculator);

        widthText = (EditText) findViewById(R.id.width_etext);
        heightText = (EditText) findViewById(R.id.height_etext);
        areaText = (TextView) findViewById(R.id.area_label);
        perimeterText = (TextView) findViewById(R.id.perimeter_label);
    }

    public void calculate(View view) {
        Resources resources = getResources();
        try {
            float width = Float.parseFloat(widthText.getText().toString());
            float height = Float.parseFloat(heightText.getText().toString());

            float area = width * height;
            float perimeter = 2 * width + 2 * height;

            areaText.setText(resources.getText(R.string.area_label_preNum) + FORMATTER.format(area));
            perimeterText.setText(resources.getText(R.string.perimeter_label_preNum) + FORMATTER.format(perimeter));
        } catch (Exception e) {
            Toast.makeText(this, resources.getText(R.string.fail_message), Toast.LENGTH_SHORT).show();
        }
    }

}
