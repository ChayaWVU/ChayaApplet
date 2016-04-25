package domain.chaya;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class EditMedicineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_medicine);
    }
    public void medOnClick(View view)
    {
        Intent i = new Intent(this, AddEditMed.class);

        switch(view.getId()) {

            case R.id.editSunday_button:
                i.putExtra("KEY","Sunday");
                break;

            case R.id.editMonday_button:
                i.putExtra("KEY","Monday");
                break;

            case R.id.editTuesday_button:
                i.putExtra("KEY","Tuesday");
                break;

            case R.id.editWednesday_button:
                i.putExtra("KEY","Wednesday");
                break;

            case R.id.editThursday_button:
                i.putExtra("KEY","Thursday");
                break;

            case R.id.editFriday_button:
                i.putExtra("KEY","Friday");
                break;

            case R.id.editSaturday_button:
                i.putExtra("KEY","Saturday");
                break;
        }

        startActivity(i);
    }
}
