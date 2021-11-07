// Mets Haile
// Final Project
// 6/6/21

package it372.hailem.hailefinalproj;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmationActivity extends AppCompatActivity {
    private SQLiteDatabase db;

    private TextView txtName, txtID, txtEmail, txtCourse, txtYear, txtLocation, txtDays, txtVaccinated;
    private Cursor cursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);


        //calls db to create file to put data into
        SQLiteOpenHelper dataa = new CourseDbHelper(this);
        try {
            db = dataa.getWritableDatabase();
        }
        catch(SQLiteException e) {
            Toast toast = Toast.makeText(this,
                    "Database not created.", Toast.LENGTH_LONG);
        }


        txtName = findViewById(R.id.txt_name);
        txtID = findViewById(R.id.txt_id);
        txtEmail = findViewById(R.id.txt_email);
        txtCourse = findViewById(R.id.txt_course);
        txtYear = findViewById(R.id.txt_year);
        txtLocation = findViewById(R.id.txt_location);
        txtDays = findViewById(R.id.txt_days);
        txtVaccinated = findViewById(R.id.txt_vaccinated);


        //cursor creats registration db and puts the string into tables
        cursor = db.query("registration",
                new String[ ] {"name", "id", "email", "course", "year", "location", "days", "vaccinated"},
                null, null, null,
                null, null, null);



    }


    //runs through the db table and displays user input
    public void onClickFirst(View v) {
        if (cursor.moveToFirst()) {
            String name = cursor.getString(0);
            int id = cursor.getInt(1);
            String email = cursor.getString(2);
            String course = cursor.getString(3);
            String year = cursor.getString(4);
            String location = cursor.getString(5);
            String days = cursor.getString(6);
            String vaccinated = cursor.getString(7);
            txtName.setText(name);
            txtID.setText(String.valueOf(id));
            txtEmail.setText(email);
            txtCourse.setText(course);
            txtYear.setText(year);
            txtLocation.setText(location);
            txtDays.setText(days);
            txtVaccinated.setText(vaccinated);
        }
        else {
            txtName.setText("");
            txtID.setText("");
            txtEmail.setText("");
            txtCourse.setText("");
            txtYear.setText("");
            txtLocation.setText("");
            txtDays.setText("");
            txtVaccinated.setText("");
        }
    }

    public void onClickLast(View view) {
        if (cursor.moveToLast()) {
            String name = cursor.getString(0);
            int id = cursor.getInt(1);
            String email = cursor.getString(2);
            String course = cursor.getString(3);
            String year = cursor.getString(4);
            String location = cursor.getString(5);
            String days = cursor.getString(6);
            String vaccinated = cursor.getString(7);
            txtName.setText(name);
            txtID.setText(String.valueOf(id));
            txtEmail.setText(email);
            txtCourse.setText(course);
            txtYear.setText(year);
            txtLocation.setText(location);
            txtDays.setText(days);
            txtVaccinated.setText(vaccinated);
        }
        else {
            txtName.setText("");
            txtID.setText("");
            txtEmail.setText("");
            txtCourse.setText("");
            txtYear.setText("");
            txtLocation.setText("");
            txtDays.setText("");
            txtVaccinated.setText("");
        }
    }
}