package wadproject.com.todolist;


import java.io.Serializable;

/**
 * Created by Lee on 17/8/2015.
 */
public class ListItem implements Serializable {
    private String taskTitle;

    public String getTaskTitle(){
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle){
        this.taskTitle = taskTitle;
    }

    public ListItem(String title){
        this.taskTitle = title;
    }

}
