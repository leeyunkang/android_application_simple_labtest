package com.example.labtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public Button btnCal;
    public TextView txtProduct, txtAmountProduct, txtMaterial, txtAmountMaterial, txtSize,
                    txtAmountSize, txtVAT, txtSubtotal, txtTotal;
    public Spinner spnProduct, spnMaterial, spnSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCal = findViewById(R.id.btnCal);
        btnCal.setOnClickListener(this);
        btnCal2.setOnClickListener(this);


        txtProduct = findViewById(R.id.txtProduct);
        txtAmountProduct = findViewById(R.id.txtAmountProduct);
        txtMaterial = findViewById(R.id.txtMaterial);
        txtAmountMaterial = findViewById(R.id.txtAmountMaterial);
        txtSize = findViewById(R.id.txtSize);
        txtAmountSize = findViewById(R.id.txtAmountSize);
        txtVAT = findViewById(R.id.txtVAT);
        txtSubtotal = findViewById(R.id.txtSubtotal);
        txtTotal = findViewById(R.id.txtTotal);

        spnProduct = findViewById(R.id.spinnerProduct);
        spnMaterial = findViewById(R.id.spinnerMaterial);
        spnSize = findViewById(R.id.spinnerSize);

        String[] arrayProduct = new String[] {"Bag", "Wallet"};
        String[] arrayMaterial = new String[] {"Calf", "Ostrich", "Crocodile"};
        String[] arraySize = new String[] {"Small", "Medium", "Large"};

        ArrayAdapter<String> adapterProduct = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayProduct);
        ArrayAdapter<String> adapterMaterial = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayMaterial);
        ArrayAdapter<String> adapterSize = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySize);

        adapterProduct.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterMaterial.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnProduct.setAdapter(adapterProduct);
        spnMaterial.setAdapter(adapterMaterial);
        spnSize.setAdapter(adapterSize);

        spnProduct.setSelection(0);
        spnMaterial.setSelection(0);
        spnSize.setSelection(0);
    }

    public void onClick(View view){
        switch (view.getId()) {
            case R.id.btnCal:
                   showTotal();
                break;
            case R.id.btnCal2:
                calculate();
                break;
        }
       //  Intent intent = new Intent(this, MainActivity2.class);
       // float n = Float.parseFloat("0.0003");
       // int op = Integer.parseInt("123");
     //   double o = Double.parseDouble("20.00");
      //  int a = 3;
      //          int b = 4;

        // intent.putExtra( "leeyunkang",a);
      //  intent.putExtra( "michelle",b);
     //   intent.putExtra( "hs",10);

       // startActivity(intent);
       // showTotal();

    }

    public void showTotal(){

        double amtProduct, amtMaterial, amtSize, amtVAT, subtotal, total;
        String selectedProduct, selectedMaterial, selectedSize;


        selectedProduct = spnProduct.getSelectedItem().toString();
        if(selectedProduct.equals("Bag")){
            amtProduct = 3000;
        }
        else{
            amtProduct = 5000;
        }

        selectedMaterial = spnMaterial.getSelectedItem().toString();
        if(selectedMaterial.equals("Calf")){
            amtMaterial = 2000;
        }
        else if(selectedMaterial.equals("Ostrich")){
            amtMaterial = 5000;
        }
        else{
            amtMaterial = 7000;
        }

        selectedSize = spnSize.getSelectedItem().toString();
        if(selectedSize.equals("Small")){
            amtSize = 1000;
        }
        else if(selectedSize.equals("Medium")){
            amtSize = 4000;
        }
        else{
            amtSize = 8000;
        }

        subtotal = amtProduct + amtMaterial + amtSize;
        amtVAT = subtotal * 0.21;
        total = subtotal + amtVAT;

        txtProduct.setText("Product - " + selectedProduct);
        txtMaterial.setText("Material - " + selectedMaterial);
        txtSize.setText("Size - " + selectedSize);

        txtAmountProduct.setText(String.format("%.2f", amtProduct));
        txtAmountMaterial.setText(String.format("%.2f", amtMaterial));
        txtAmountSize.setText(String.format("%.2f", amtSize));
        txtSubtotal.setText(String.format("%.2f", subtotal));
        txtVAT.setText(String.format("%.2f", amtVAT));
        txtTotal.setText(String.format("%.2f", total));

    }






}