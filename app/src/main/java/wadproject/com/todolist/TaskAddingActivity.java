package wadproject.com.todolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TaskAddingActivity extends Activity {

    EditText editTask;
    String addedTask;
    ListItem taskToAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_adding);
        taskToAdd = new ListItem("No Task");
         editTask = (EditText)findViewById(R.id.editTask);
        TextView alarmtv = (TextView)findViewById(R.id.AlarmTV);
        alarmtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTask.getText().toString().equals("")){
                    Log.d("Alert", "No Input");
                    AlertDialog.Builder noInputAlert = new AlertDialog.Builder(TaskAddingActivity.this);
                    noInputAlert.setMessage(R.string.noInputAlert);
                    noInputAlert.setTitle(R.string.noInputAlertTitle);
                    noInputAlert.show();
                }else{
                    showEditAlarmDialog(v);
                }

            }
        });
        TextView dueDatetv = (TextView)findViewById(R.id.dueDateTV);
        dueDatetv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTask.getText().toString().equals("")) {
                    Log.d("Alert", "No Input");
                    AlertDialog.Builder noInputAlert = new AlertDialog.Builder(TaskAddingActivity.this);
                    noInputAlert.setMessage(R.string.noInputAlert);
                    noInputAlert.setTitle(R.string.noInputAlertTitle);
                    noInputAlert.show();
                }else{
                    showEditDueDateDialog(v);
                }

            }
        });
        Button save = (Button)findViewById(R.id.saveTask);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addedTask = editTask.getText().toString();
                taskToAdd.setTaskTitle(addedTask);
                Intent backToHome = new Intent(TaskAddingActivity.this,MainActivity.class);
                backToHome.putExtra("addTask", taskToAdd);
                startActivity(backToHome);




            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_adding, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void showEditAlarmDialog(View v){
        FragmentManager showAlarm = getFragmentManager();
        if(showAlarm.findFragmentById(R.id.addAlarm).isVisible()==false) {
            showAlarm.findFragmentById(R.id.addAlarm).getView().setVisibility(View.VISIBLE);
        }else{
            showAlarm.findFragmentById(R.id.addAlarm).getView().setVisibility(View.GONE);
        }
    /*    DialogFragment alarmFragment = new AlarmTimeDialogFragment();
        alarmFragment.show(getFragmentManager(), "setAlarm");*/
    }
    public void showEditDueDateDialog(View v) {
        FragmentManager showEditDate = getFragmentManager();
        if(showEditDate.findFragmentById(R.id.addDueDate).isVisible()==false) {
            showEditDate.findFragmentById(R.id.addDueDate).getView().setVisibility(View.VISIBLE);
        }else{
            showEditDate.findFragmentById(R.id.addDueDate).getView().setVisibility(View.GONE);
        }

    }
}
