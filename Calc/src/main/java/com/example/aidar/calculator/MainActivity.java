package com.example.aidar.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aidar.calculator.exceptions.EvaluateException;
import com.example.aidar.calculator.exceptions.ExpressionParser;
import com.example.aidar.calculator.exceptions.ParseException;
import com.example.aidar.calculator.exceptions.Parser;
import com.example.aidar.calculator.exceptions.TripleExpression;

public class MainActivity extends AppCompatActivity {
    static CharSequence s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (s != null)
            ((TextView) findViewById(R.id.field)).setText(s);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        s = ((TextView) findViewById(R.id.field)).getText();
    }

    public void edit(View view) {
        TextView field = (TextView) findViewById(R.id.field);
        String es = getResources().getString(R.string.empty_expression);
        switch (view.getId()) {
            case R.id.clear:
                field.setText(es);
                break;
            case R.id.delete:
                if (!field.getText().toString().equals(es)) {
                    CharSequence s = field.getText();
                    field.setText(s.subSequence(0, s.length() - 1));
                }
                break;
            default:
                if (field.getText().toString().equals(es))
                    field.setText("");
                field.append(((Button) view).getText());
        }
        if (field.length() == 0)
            field.setText(es);
    }

    public void eval(View view) {
        TextView field = (TextView) findViewById(R.id.field);
        TripleExpression expression;
        try {
            Parser parser = new ExpressionParser();
            expression = parser.parse(field.getText().toString());
        } catch (ParseException e) {
            field.append(" Wrong format");
            return;
        }
        try {
            field.setText(Double.toString(expression.evaluate(0, 0, 0)));
        } catch (EvaluateException e) {
            field.append(" Can't evaluate");
        }
    }
}
