import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FreelanceTaskTracker {
    private List<TaskTracker> tasks = new ArrayList<>();

    private static class TaskTracker{
        private String taskName;
        private String clientName;
        private LocalDate deadline;
        private String taskDescription;
        private String taskPriority;
        private String taskStatus;
        private String taskCategory;
        private boolean completed;

        // Constructor

        public TaskTracker(String taskName, String clientName, LocalDate deadline,  String taskDescription, String taskPriority, String taskStatus, String taskCategory) {
            this.taskName = taskName;
            this.clientName = clientName;
            this.deadline = deadline;
            this.taskDescription = taskDescription;
            this.taskPriority = taskPriority;
            this.taskStatus = taskStatus;
            this.taskCategory = taskCategory;
            this.completed = false;
        }

        // Getter & Setter
        public String getTaskName(){return taskName;}
        public void setTaskName(String taskName){this.taskName = taskName;}

        public String getClientName(){return clientName;}
        public void setClientName(String clientName){this.clientName = clientName;}

        public LocalDate getDeadline(){return deadline;}
        public void setDeadline(LocalDate deadline){this.deadline = deadline;}

        public String getTaskDescription(){return taskDescription;}
        public void setTaskDescription(String taskDescription){this.taskDescription = taskDescription;}

        public String getTaskPriority(){return taskPriority;}
        public void setTaskPriority(String taskPriority){this.taskPriority = taskPriority;}

        public String getTaskStatus(){return taskStatus;}
        public void setTaskStatus(String taskStatus){this.taskStatus = taskStatus;}

        public String getTaskCategory(){return taskCategory;}
        public void setTaskCategory(String taskCategory){this.taskCategory = taskCategory;}

        public boolean isCompleted(){return completed;}
        public void setCompleted(boolean completed){this.completed = completed;}

        public String toString(){
            return "Task Name: " + taskName + "| Client Name: "+ clientName + "| Deadline: " + deadline +  "| Description: " + taskDescription + "| Task Priority: "+ taskPriority +"| Task Status: "+ taskStatus + "| Task Category: "+ taskCategory + " (" + (completed ? "completed" : "not completed") + ")";
        }
    }

    // Add a task

    public void addTask(String taskName, String clientName, LocalDate deadline,  String taskDescription, String taskPriority, String taskStatus, String taskCategory){
        TaskTracker task = new TaskTracker(taskName, clientName, deadline, taskDescription, taskPriority, taskStatus, taskCategory);
        tasks.add(task);

    }

    // Edid a task

    public void editTask(int taskNo, String taskName, String clientName, LocalDate deadline,  String taskDescription, String taskPriority, String taskStatus, String taskCategory){
        TaskTracker task = tasks.get(taskNo);
        task.setTaskName(taskName);
        task.setClientName(clientName);
        task.setDeadline(deadline);
        task.setTaskDescription(taskDescription);
        task.setTaskPriority(taskPriority);
        task.setTaskStatus(taskStatus);
        task.setTaskCategory(taskCategory);
    }
    public List<TaskTracker>getTasks(){return tasks;}

    // View all tasks

    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("No tasks found. Please try again!");
            System.out.println("-------------------------------------------------------------------------");
            return;
        }
        for(int i=0; i<tasks.size(); i++){
            System.out.println("Task Number- "+(i+1));
            System.out.println(tasks.get(i));
            System.out.println();
        }

    }

    // Delete a task

    public void deleteTask(int taskNo){tasks.remove(taskNo);}

    // Mark a task as completed

    public void markTaskAsCompleted(int taskNo){
        TaskTracker task = tasks.get(taskNo);
        task.setCompleted(true);


    }

    public static void main(String[] args){
        FreelanceTaskTracker freelanceTaskTracker = new FreelanceTaskTracker();
        Scanner scanner = new Scanner(System.in);

        while(true){

            // Display the option list

            System.out.println("\n \uD83D\uDE00Welcome to the Freelance Task Tracker!\uD83D\uDE00 \n");

            System.out.println("1. Add a Task");
            System.out.println("2. Edit a Task");
            System.out.println("3. View all Tasks");
            System.out.println("4. Delete a Task");
            System.out.println("5. Mark a Task as completed");
            System.out.println("6. Exit");

            try{
                System.out.println("------------------------------------------------------------------------------------------------");
                System.out.println("Choose an option(1-6): ");


                int option = scanner.nextInt();
                scanner.nextLine();

                // check weather valid input

                if(option <1 || option > 6){

                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("Invalid option. Please enter a number between 1 to 6");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                    continue;
                }

                switch (option) {

                    case 1:
                        // create a task

                        System.out.println("Enter the task name: ");
                        String taskName= scanner.nextLine();

                        System.out.println("Enter the client Name: ");
                        String clientName= scanner.nextLine();


                        LocalDate deadline = null;
                        while(deadline == null){
                            System.out.println("Enter the task deadline (YYYY-MM-DD): ");
                            String deadlineString = scanner.nextLine();

                            try{
                                deadline = LocalDate.parse(deadlineString);
                            } catch (DateTimeParseException e){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("Invalid date format. Please try again.");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        System.out.println("Enter your task's description: ");
                        String taskDescription= scanner.nextLine();

                        System.out.println("Enter your task' priority(e.g., High, Medium, Low): ");
                        String taskPriority= scanner.nextLine();

                        System.out.println("Enter your task's status(e.g., Not Started, In Progress, Completed, On Hold): ");
                        String taskStatus= scanner.nextLine();

                        System.out.println("Enter your task's category(e.g., Writing, Design, Development): ");
                        String taskCategory= scanner.nextLine();

                        freelanceTaskTracker.addTask(taskName, clientName, deadline, taskDescription, taskPriority, taskStatus, taskCategory);

                        System.out.println("\n**********************************************************************");
                        System.out.println("Task added successfully!");
                        System.out.println("**********************************************************************");

                        break;



                    case 2:

                        // Edit a task

                        System.out.println("Enter the task number to edit: ");
                        int editTaskNo = scanner.nextInt();
                        scanner.nextLine();

                        if (editTaskNo <= 0 || editTaskNo > freelanceTaskTracker.getTasks().size()) {

                            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("Invalid task number. Please try again!");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                            break;
                        }

                        System.out.println("Enter the new task name: ");
                        String newTask = scanner.nextLine();

                        System.out.println("Enter the new client name: ");
                        String newClient = scanner.nextLine();

                        LocalDate newDeadline = null;
                        while (newDeadline == null){
                            System.out.println("Enter the new task deadline(YYYY-MM-DD): ");
                            String newDeadlineString = scanner.nextLine();

                            try{
                                newDeadline = LocalDate.parse(newDeadlineString);
                            }catch (DateTimeParseException e) {

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("Invalid date format. please try again!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            }
                        }

                        System.out.println("Enter the new description: ");
                        String newDescription = scanner.nextLine();

                        System.out.println("Enter the new priority(e.g., High, Medium, Low): ");
                        String newPriority = scanner.nextLine();

                        System.out.println("Enter the new status(e.g., Not Started, In Progress, Completed, On Hold): ");
                        String newStatus = scanner.nextLine();

                        System.out.println("Enter the new category(e.g., Writing, Design, Development): ");
                        String newCategory = scanner.nextLine();

                        freelanceTaskTracker.editTask(editTaskNo - 1, newTask, newClient, newDeadline, newDescription, newPriority, newStatus, newCategory );

                        System.out.println("\n**********************************************************************");
                        System.out.println("Task edited successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 3:

                        // View all tasks

                        freelanceTaskTracker.viewTask();
                        break;

                    case 4:

                        // Delete a task

                        System.out.println("Enter the task Number to delete: ");
                        int deleteTaskNo = scanner.nextInt();
                        scanner.nextLine();

                        if (deleteTaskNo <= 0 || deleteTaskNo > freelanceTaskTracker.getTasks().size()) {

                            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("Task not found. Please try again!");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                            break;

                        }

                        freelanceTaskTracker.deleteTask(deleteTaskNo - 1);

                        System.out.println("\n**********************************************************************");
                        System.out.println("Task deleted successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 5:

                        // Mark task as completed

                        System.out.print("Enter the task number to mark as completed: ");
                        int completeTaskNo = scanner.nextInt();
                        scanner.nextLine();

                        if (completeTaskNo <= 0 || completeTaskNo > freelanceTaskTracker.getTasks().size()) {

                            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("Invalid task number. Please try again!");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                            break;
                        }

                        freelanceTaskTracker.deleteTask(completeTaskNo - 1);

                        System.out.println("\n**********************************************************************");
                        System.out.println("Task marked as completed successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    default:
                        System.out.println("\n============================================================================================");
                        System.out.println("\uD83D\uDE00Thank you for using Freelance task tracker. Catch you tomorrow—keep hustling!");
                        System.out.println("============================================================================================");

                        break;

                }
                System.out.println();


            }catch(InputMismatchException e){

                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Invalid input! Please enter a number between 1 and 6");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                scanner.nextLine();

            }

        }

    }
}