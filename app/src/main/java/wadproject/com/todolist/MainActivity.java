package wadproject.com.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getFragmentManager().beginTransaction()
                    .add(R.id.container,new TaskListFragment())
                    .commit();
        }
        Button addTaskbtn = (Button)findViewById(R.id.addTask);
        addTaskbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTask = new Intent(MainActivity.this, TaskAddingActivity.class);
                startActivity(addTask);
            }
        });
		
			// Get ListView object from xml
            listView = (ListView) findViewById(R.id.list);
            
            // Defined Array values to show in ListView
            String[] values = new String[] { "Android List View", 
                                             "Adapter implementation",
                                             "Simple List View In Android",
                                             "Create List View Android", 
                                             "Android Example", 
                                             "List View Source Code", 
                                             "List View Array Adapter", 
                                             "Android Example List View" 
                                            };
    
            // Define a new Adapter
            // First parameter - Context
            // Second parameter - Layout for the row
            // Third parameter - ID of the TextView to which the data is written
            // Forth - the Array of data
    
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
              android.R.layout.simple_list_item_1, values);
    
    
            // Assign adapter to ListView
            listView.setAdapter(adapter);
		
		
		
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
