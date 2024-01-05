package com.example.uidesignapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edtFName, edtLName, edtSName, edtSNumber, edtState, edtCity, edtZipCode, edtEmail, edtPassword, edtConfirmPassword, edtPoBox;
    Spinner spinnerCountry, spinnerProfile;
    private Button btnAdd, btnModify, btnDelete, btnQuery, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        ImageView back = findViewById(R.id.back);
        ImageView search = findViewById(R.id.search_icon);
        TextView title = findViewById(R.id.title);
        title.setText("User Profile");
        edtFName = findViewById(R.id.edtFName);
        edtLName = findViewById(R.id.edtLName);
        edtSName = findViewById(R.id.edtSName);
        edtSNumber = findViewById(R.id.edtSNumber);
        edtState = findViewById(R.id.edtState);
        edtCity = findViewById(R.id.edtCity);
        edtPoBox = findViewById(R.id.edtPoBox);
        edtZipCode = findViewById(R.id.edtZipcode);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtComPassword);
        spinnerCountry = findViewById(R.id.spinnerCountry);
        spinnerProfile = findViewById(R.id.spinnerProfile);
        btnAdd = findViewById(R.id.btnAdd);
        btnModify = findViewById(R.id.btnModify);
        btnDelete = findViewById(R.id.btnDelete);
        btnQuery = findViewById(R.id.btnQuery);
        btnNext = findViewById(R.id.btnNext);

        ArrayAdapter<CharSequence> adapterCountries = ArrayAdapter.createFromResource(
                this,
                R.array.countries,
                android.R.layout.simple_spinner_item
        );
        adapterCountries.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(adapterCountries);

        ArrayAdapter<CharSequence> adapterProfile = ArrayAdapter.createFromResource(
                this,
                R.array.profile,
                android.R.layout.simple_spinner_item
        );
        adapterProfile.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProfile.setAdapter(adapterProfile);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DetailsListActivity.class));
            }
        });

        btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = edtPassword.getText().toString();
                String confirmPassword = edtConfirmPassword.getText().toString();

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(MainActivity.this, "Password and Confirm Password must match", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, DetailsListActivity.class);

                intent.putExtra("firstName", edtFName.getText().toString());
                intent.putExtra("lastName", edtLName.getText().toString());
                intent.putExtra("streetName", edtSName.getText().toString());
                intent.putExtra("streetNumber", edtSNumber.getText().toString());
                intent.putExtra("state", edtState.getText().toString());
                intent.putExtra("city", edtCity.getText().toString());
                intent.putExtra("pobox", edtPoBox.getText().toString());
                intent.putExtra("zipCode", edtZipCode.getText().toString());
                intent.putExtra("email", edtEmail.getText().toString());
                intent.putExtra("password", edtPassword.getText().toString());
                intent.putExtra("confirmPassword", edtConfirmPassword.getText().toString());
                intent.putExtra("country", spinnerCountry.getSelectedItem().toString());
                intent.putExtra("profile", spinnerProfile.getSelectedItem().toString());

                startActivity(intent);
            }
        });
    }
}
