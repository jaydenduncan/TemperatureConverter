package com.example.temperatureconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.temperatureconverter.databinding.ActivityMainBinding;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if(binding.fahrenheitEditText.getText() != null){

                        String fahrenheitText = binding.fahrenheitEditText.getText().toString();
                        BigDecimal fahrenheitTemp = new BigDecimal(fahrenheitText);
                        BigDecimal result = fToC(fahrenheitTemp);

                        binding.celsiusEditText.setText(result.toString());

                    }
                    else{
                        System.out.println("Fahrenheit Text View is empty");
                    }

                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private BigDecimal fToC(BigDecimal fTemp){
        MathContext mc = new MathContext(3, RoundingMode.HALF_UP);

        BigDecimal result1 = fTemp.subtract(new BigDecimal("32"), mc);

        System.out.println(result1.toString());

        BigDecimal finalResult = result1.multiply(new BigDecimal(String.valueOf(5/9.0)), mc);

        System.out.println(finalResult.toString());

        return finalResult;
    }

    private BigDecimal cToF(BigDecimal cTemp){
        BigDecimal result = null;

        return result;
    }
}