package edu.iastate.netid.pocketcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /**
     * The instance of the calculator model for use by this controller.
     */
    private final CalculationStream mCalculationStream = new CalculationStream();

    /*
     * The instance of the calculator display TextView. You can use this to update the calculator display.
     */
    private TextView mCalculatorDisplay;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TODO - uncomment the below line after you make your layout. This line locates
           the instance of the calculator display's TextView.  You need to create this TextView
           and set its ID to CalculatorDisplay in your layout resource file.
         */
        mCalculatorDisplay = findViewById(R.id.CalculatorDisplay);
        Button button1 = findViewById(R.id.button19);
        Button button2 = findViewById(R.id.button21);
        Button button3 = findViewById(R.id.button20);
        Button button4 = findViewById(R.id.button24);
        Button button5 = findViewById(R.id.button25);
        Button button6 = findViewById(R.id.button26);
        Button button7 = findViewById(R.id.button28);
        Button button8 = findViewById(R.id.button31);
        Button button9 = findViewById(R.id.button29);
        Button button0 = findViewById(R.id.button32);
        Button buttonx = findViewById(R.id.button22);
        Button buttonsub = findViewById(R.id.button27);
        Button buttonadd = findViewById(R.id.button30);
        Button buttondiv = findViewById(R.id.button34);
        Button buttondec = findViewById(R.id.button35);
        Button buttoneq = findViewById(R.id.button33);
        Button clear = findViewById(R.id.button23);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClearClicked(view);
            }
        });

        buttoneq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEqualClicked(view);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOneClicked(view);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onTwoClicked(view);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onThreeClicked(view);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFourClicked(view);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFiveClicked(view);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSixClicked(view);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSevenClicked(view);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEightClicked(view);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNineClicked(view);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onZeroClicked(view);
            }
        });

        buttondec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDecClicked(view);
            }
        });

        buttonx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onXClicked(view);
            }
        });

        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddClicked(view);
            }
        });

        buttonsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubClicked(view);
            }
        });

        buttondiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDivClicked(view);
            }
        });

    }

    /* TODO - add event listeners for your calculator's buttons. See the model's API to figure out
       what methods should be called. The equals button event listener has been done for you. Once
       you've created the layout, you'll need to add these methods as the onClick() listeners
       for the corresponding buttons in the XML layout. */


    public void onClearClicked(View view){
        try{
            mCalculationStream.clear();
        } finally {
            updateCalculatorDisplay();
        }
    }
    public void onEqualClicked(View view) {
        try {
            mCalculationStream.calculateResult();
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onOneClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.ONE);
    } finally {
            updateCalculatorDisplay();
        }
    }

    public void onTwoClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.TWO);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onThreeClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.THREE);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onFourClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.FOUR);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onFiveClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.FIVE);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onSixClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.SIX);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onSevenClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.SEVEN);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onEightClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.EIGHT);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onNineClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.NINE);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onZeroClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.ZERO);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onDecClicked(View view){
        try {mCalculationStream.inputDigit(CalculationStream.Digit.DECIMAL);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onXClicked(View view){
        try{
            mCalculationStream.inputOperation(CalculationStream.Operation.MULTIPLY);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onAddClicked(View view){
        try{
            mCalculationStream.inputOperation(CalculationStream.Operation.ADD);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onSubClicked(View view){
        try{
            mCalculationStream.inputOperation(CalculationStream.Operation.SUBTRACT);
        } finally {
            updateCalculatorDisplay();
        }
    }

    public void onDivClicked(View view){
        try{
            mCalculationStream.inputOperation(CalculationStream.Operation.DIVIDE);
        } finally {
            updateCalculatorDisplay();
        }
    }

    /**
     * Call this method after every button press to update the text display of your calculator.
     */
    public void updateCalculatorDisplay() {
        String value = getString(R.string.empty);
        try {
            value = Double.toString(mCalculationStream.getCurrentOperand());
        } catch(NumberFormatException e) {
            value = getString(R.string.error);
        } finally {
            // TODO: this value may need to be formatted first so it fits on one line... try 0.8 - 0.2
            mCalculatorDisplay.setText(value);
        }
    }
}
