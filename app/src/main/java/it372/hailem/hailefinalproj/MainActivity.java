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

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private EditText edtxtName, edtxtEmail, edtxtID, edtxtCourse;
    private Spinner spnYear, spnLocation;
    private RadioButton radMonWed, radTuTh, radEveryday;
    private CheckBox chkVaccinated;
    private TextView txtName, txtID, txtEmail, txtCourse, txtYear, txtLocation, txtDays, txtVaccinated;
    private Cursor cursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //calls db to create file to put data into

        SQLiteOpenHelper dataa = new CourseDbHelper(this);
        try {
            db = dataa.getWritableDatabase();
        }
        catch(SQLiteException e) {
            Toast toast = Toast.makeText(this,
                    "Database not created.", Toast.LENGTH_LONG);
        }

        edtxtName = findViewById(R.id.edtxt_name);
        edtxtID = findViewById(R.id.edtxt_id);
        edtxtEmail = findViewById(R.id.edtxt_email);
        edtxtCourse = findViewById(R.id.edtxt_course);
        spnYear = findViewById(R.id.spn_year);
        spnLocation = findViewById(R.id.spn_location);
        radMonWed = findViewById(R.id.rad_monwed);
        radTuTh = findViewById(R.id.rad_tuth);
        radEveryday = findViewById(R.id.rad_everyday);
        chkVaccinated = findViewById(R.id.chk_vaccinated);


        txtName = findViewById(R.id.txt_name);
        txtID = findViewById(R.id.txt_id);
        txtEmail = findViewById(R.id.txt_email);
        txtCourse = findViewById(R.id.txt_course);
        txtYear = findViewById(R.id.txt_year);
        txtLocation = findViewById(R.id.txt_location);
        txtDays = findViewById(R.id.txt_days);
        txtVaccinated = findViewById(R.id.txt_vaccinated);



        cursor = db.query("registration",
                new String[ ] {"name", "id", "email", "course", "year", "location", "days", "vaccinated"},
                null, null, null,
                null, null, null);
    }


    //button to submit and retrieve data
    public void submitInfo(View view) {
        String name = edtxtName.getText( ).toString( );
        int id = Integer.parseInt(edtxtID.getText( ).toString( ));
        String email = edtxtEmail.getText( ).toString( );
        String course = edtxtCourse.getText( ).toString( );
        String year =  spnYear.getSelectedItem( ).toString( );
        String location =  spnLocation.getSelectedItem( ).toString( );
        String days = radMonWed.isChecked( ) ? "Monday/Wednesday" : "Tuesday/Thursday";
        String vaccinated = chkVaccinated.isChecked( ) ? "Yes" : "No";



        //content values puts the data into db database and stores them
        ContentValues registrationValues = new ContentValues( );
        registrationValues.put("name", name);
        registrationValues.put("id", id);
        registrationValues.put("email", email);
        registrationValues.put("course", course);
        registrationValues.put("year", year);
        registrationValues.put("location", location);
        registrationValues.put("days", days);
        registrationValues.put("vaccinated", vaccinated);

        db.insert("registration", null, registrationValues);
        edtxtName.setText("");
        edtxtID.setText("");
        edtxtEmail.setText("");
        edtxtCourse.setText("");

        cursor = db.query("registration",
                new String[ ] {"name", "id", "email", "course", "year", "location", "days", "vaccinated"},
                null, null, null,
                null, null, null);


        //this will open up the confirmation activity
        Intent i = new Intent(MainActivity.this, ConfirmationActivity.class);
        startActivity(i);

    }


}