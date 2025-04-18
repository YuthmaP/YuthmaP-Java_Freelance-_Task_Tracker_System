import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class FreelanceTaskTracker {
    private List<TaskTracker> tasks = new ArrayList<>();

    // Class to represent a task with all its details

    private static class TaskTracker{
        private String taskName;
        private String clientName;
        private LocalDate deadline;
        private String taskDescription;
        private String taskPriority;
        private String taskStatus;
        private String taskCategory;
        private boolean completed;

        // Constructor to initialize a new task with all its details

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

        // Method to return a formatted string of the task details
        public String toString(){
            return "\n\uD83D\uDCCCTask Name: " + taskName + "\n\uD83D\uDCCCClient Name: "+ clientName + "\n\uD83D\uDCCCDeadline: " + deadline +  "\n\uD83D\uDCCCDescription: " + taskDescription + "\n\uD83D\uDCCCTask Priority: "+ taskPriority +"\n\uD83D\uDCCCTask Status: "+ taskStatus + "\n\uD83D\uDCCCTask Category: "+ taskCategory + " \n\uD83D\uDCCC(" + (completed ? "completed" : "not completed") + ")";
        }
    }

    // Method to add a new task to the list

    public void addTask(String taskName, String clientName, LocalDate deadline,  String taskDescription, String taskPriority, String taskStatus, String taskCategory){
        TaskTracker task = new TaskTracker(taskName, clientName, deadline, taskDescription, taskPriority, taskStatus, taskCategory);
        tasks.add(task);
    }

    // Method to edit an existing task in the list

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

    // Method to retrieve the list of all tasks

    public List<TaskTracker>getTasks(){return tasks;}

    // Method to display all tasks in the list

    public void viewTask(){
        if(tasks.isEmpty()){
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("\u26A0\uFE0FNo tasks found. Please try again!");
            System.out.println("-------------------------------------------------------------------------");
            return;
        }
        for(int i=0; i<tasks.size(); i++){
            System.out.println("Task Number- "+(i+1));
            System.out.println(tasks.get(i)); // Print task details using toString method
            System.out.println();
        }
    }

    // Method to delete a task from the list

    public void deleteTask(int taskNo){tasks.remove(taskNo);}

    // Method to mark a task as completed

    public void markTaskAsCompleted(int taskNo){
        TaskTracker task = tasks.get(taskNo); // Get the task by its index
        task.setCompleted(true); // Set the task's completion status to true
    }

    public static void main(String[] args){
        FreelanceTaskTracker freelanceTaskTracker = new FreelanceTaskTracker();
        Scanner scanner = new Scanner(System.in);

        while(true){

            // Displaying options for the user to choose from menu

            System.out.println("\n \uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDE80\uD83D\uDEA9Welcome to the Freelance Task Tracker!\uD83C\uDFAF\uD83D\uDE0E\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39 \n");

            System.out.println("\u0031\uFE0F\u20E3 Add a Task");
            System.out.println("\u0032\uFE0F\u20E3 Edit a Task");
            System.out.println("\u0033\uFE0F\u20E3 View all Tasks");
            System.out.println("\u0034\uFE0F\u20E3 Delete a Task");
            System.out.println("\u0035\uFE0F\u20E3 Mark a Task as completed");
            System.out.println("\u0036\uFE0F\u20E3 Income After Tax Calculator");
            System.out.println("\u0037\uFE0F\u20E3 Hourly Rate Earning Calculator");
            System.out.println("\u0038\uFE0F\u20E3 Exit");

            try{
                System.out.println("\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39\uD83D\uDD39");
                System.out.println("\uD83D\uDC49Choose an option(1-8): ");

                int option = scanner.nextInt(); // Read user input for chosen option
                scanner.nextLine();

                // Check if the input option is valid (between 1 and 8)

                if(option <1 || option > 8){

                    System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("\u274CInvalid option. Please enter a number between 1 to 8");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                    continue;
                }

                // Switch block to handle different actions based on user input
                switch (option) {

                    case 1:

                        // create a new task

                        String taskName = "";
                        while(taskName.isEmpty()) {
                            System.out.println("\u2B55Enter the task name: ");
                            taskName = scanner.nextLine().trim();
                            if(taskName.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Task name can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        // Similarly, add validation for client name, deadline, description, etc.

                        String clientName = "";
                        while(clientName.isEmpty()) {
                            System.out.println("\n\u2B55Enter the client Name: ");
                            clientName= scanner.nextLine().trim();
                            if(clientName.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Client name can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        LocalDate deadline = null;
                        while(deadline == null){
                            System.out.println("\n\u2B55Enter the task deadline (YYYY-MM-DD): ");
                            String deadlineString = scanner.nextLine();

                            try{
                                deadline = LocalDate.parse(deadlineString);
                            } catch (DateTimeParseException e){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid date format. Please try again.");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String taskDescription = "";
                        while(taskDescription.isEmpty()) {
                            System.out.println("\n\u2B55Enter your task's description: ");
                            taskDescription= scanner.nextLine().trim();
                            if(taskDescription.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Task's Description can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String taskPriority = "";
                        while(taskPriority.isEmpty()) {
                            System.out.println("\n\u2B55Enter your task' priority(e.g., High, Medium, Low): ");
                            taskPriority= scanner.nextLine().trim();
                            if(taskPriority.isEmpty()){
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError:Task's priority can not be empty or contain only spaces");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String taskStatus = "";
                        while(taskStatus.isEmpty()) {
                            System.out.println("\n\u2B55Enter your task's status(e.g., Not Started, In Progress, Completed, On Hold): ");
                            taskStatus= scanner.nextLine().trim();
                            if(taskStatus.isEmpty()){
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Task's status can not be empty or contain only spaces");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }

                        }

                        String taskCategory = "";
                        while(taskCategory.isEmpty()) {
                            System.out.println("\n\u2B55Enter your task's category(e.g., Writing, Design, Development): ");
                            taskCategory= scanner.nextLine().trim();
                            if(taskCategory.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: Task's category can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        // Add the task to the list
                        freelanceTaskTracker.addTask(taskName, clientName, deadline, taskDescription, taskPriority, taskStatus, taskCategory);

                        // Confirmation message
                        System.out.println("\n**********************************************************************");
                        System.out.println("\u2705Task added successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 2:

                        // Edit an existing task

                        int editTaskNo;

                        while(true) {
                            System.out.println("\n\uD83D\uDD22Enter the task number to edit: ");

                            if(scanner.hasNextInt()) {
                                editTaskNo = scanner.nextInt();
                                scanner.nextLine();

                                // Display error message for invalid inputs
                                if (editTaskNo <= 0 || editTaskNo > freelanceTaskTracker.getTasks().size()) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CInvalid task number. Please try again!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                } else {
                                    break;
                                }

                            }else{

                                // Display error message for invalid inputs
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid input. Please try again!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                scanner.nextLine();
                            }
                        }

                        // Repeat for the new values of task name, client name, etc.
                        String newTask = "";
                        while(newTask.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new task name: ");
                            newTask = scanner.nextLine().trim();
                            if(newTask.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New task can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String newClient = "";
                        while(newClient.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new client name: ");
                            newClient= scanner.nextLine().trim();
                            if(newClient.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New client name can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        LocalDate newDeadline = null;
                        while (newDeadline == null){
                            System.out.println("\n\u2B55Enter the new task deadline(YYYY-MM-DD): ");
                            String newDeadlineString = scanner.nextLine();

                            try{
                                newDeadline = LocalDate.parse(newDeadlineString);
                            }catch (DateTimeParseException e) {

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid date format. please try again!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            }
                        }

                        String newDescription= "";
                        while(newDescription.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new description: ");
                            newDescription= scanner.nextLine().trim();
                            if(newDescription.isEmpty()){
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New description can not be empty or contain only spaces");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String newPriority= "";
                        while(newPriority.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new priority(e.g., High, Medium, Low): ");
                            newPriority= scanner.nextLine().trim();
                            if(newPriority.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New Priority can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String newStatus= "";
                        while(newStatus.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new status(e.g., Not Started, In Progress, Completed, On Hold): ");
                            newStatus= scanner.nextLine().trim();
                            if(newStatus.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New status can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        String newCategory= "";
                        while(newCategory.isEmpty()) {
                            System.out.println("\n\u2B55Enter the new category(e.g., Writing, Design, Development): ");
                            newCategory= scanner.nextLine().trim();
                            if(newCategory.isEmpty()){
                                System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CError: New category can not be empty or contain only spaces");
                                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                            }
                        }

                        // Edit the task in the list
                        freelanceTaskTracker.editTask(editTaskNo - 1, newTask, newClient, newDeadline, newDescription, newPriority, newStatus, newCategory );

                        // Confirmation message
                        System.out.println("\n**********************************************************************");
                        System.out.println("\u2705Task edited successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 3:

                        // View all tasks

                        freelanceTaskTracker.viewTask();
                        break;

                    case 4:

                        // Delete a task

                        int deleteTaskNo;

                        while(true) {
                            System.out.println("\n\uD83D\uDD22Enter the task Number to delete: ");

                            if(scanner.hasNextInt()) {
                                deleteTaskNo = scanner.nextInt();
                                scanner.nextLine();

                                // Display error message for invalid inputs
                                if (deleteTaskNo <= 0 || deleteTaskNo > freelanceTaskTracker.getTasks().size()) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u26A0\uFE0FTask not found. Please try again!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                } else {
                                    break;
                                }

                            }else{

                                // Display error message for invalid inputs
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid input. Please try again!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                scanner.nextLine();
                            }
                        }

                        freelanceTaskTracker.deleteTask(deleteTaskNo - 1);

                        // Confirmation message
                        System.out.println("\n**********************************************************************");
                        System.out.println("\u2705Task deleted successfully!");
                        System.out.println("**********************************************************************");

                        break;

                    case 5:

                        // Mark task as completed

                        int completeTaskNo;

                        while(true) {
                            System.out.print("\n\uD83D\uDD22Enter the task number to mark as completed: ");

                            if(scanner.hasNextInt()) {
                                completeTaskNo = scanner.nextInt();
                                scanner.nextLine();

                                // Display error message for invalid inputs
                                if (completeTaskNo <= 0 || completeTaskNo > freelanceTaskTracker.getTasks().size()) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u26A0\uFE0FTask not found. Please try again!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                } else {
                                    break;
                                }

                            }else{

                                // Display error message for invalid inputs
                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid input. Please try again!");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                scanner.nextLine();
                            }
                        }

                        freelanceTaskTracker.deleteTask(completeTaskNo - 1);

                        // Confirmation message
                        System.out.println("\n*********************************************************************************");
                        System.out.println("\u2705 Task number- "+completeTaskNo+" marked as completed successfully & removed from the task list!");
                        System.out.println("*********************************************************************************");

                        break;

                    case 6:

                        // Income After Tax Calculator

                        double income = 0;

                        while(true){

                            try { // Prevent crash on non-numeric input

                                System.out.println("\n\u2B55Enter the total income: ");
                                String num = scanner.nextLine().trim();

                                // Display error message for empty input
                                if (num.isEmpty()) {
                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CTotal income can not be empty!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                    continue;
                                }

                                income = Double.parseDouble(num);

                                // Display message if input is a negative number or zero
                                if (income <= 0) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CTotal income can not be zero or negative!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                } else {

                                    break;
                                }
                            }catch(NumberFormatException e){

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid input! Please enter numbers only.");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                            }

                        }

                        double taxPecentage = 0;

                        while(true){

                            try { // Prevent crash on non-numeric input

                                System.out.println("\n\u2B55Enter the estimated tax percentage%(e.g. 10 or 12.5): ");
                                String num = scanner.nextLine().trim();

                                // Display error message for empty input
                                if (num.isEmpty()) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CTax percentage can not be empty!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                    continue;
                                }

                                taxPecentage = Double.parseDouble(num);

                                // Display message if input is a negative number or zero
                                if (taxPecentage <= 0) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CTax percentage can not be zero or negative!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                } else {

                                    break;
                                }
                            }catch(NumberFormatException e){

                            System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                            System.out.println("\u274CInvalid input! Please enter numbers only.");
                            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                            }
                        }

                        double tax = income*taxPecentage/100 ;
                        double afterTax = income-tax;


                        // Display total income after calculating tax
                        System.out.println("\n**********************************************************************");
                        System.out.printf("\uD83D\uDCB5Total Income after tax: Rs. %.2f%n",afterTax);
                        System.out.println("**********************************************************************");

                        break;

                    case 7:

                        // Hourly Rate Earning Calculator

                        double hourlyRate = 0;

                        while(true){

                            try { // Prevent crash on non-numeric input

                                System.out.println("\n\u2B55Enter the hourly rate amount: ");
                                String num = scanner.nextLine().trim();

                                // Display error message for empty input
                                if (num.isEmpty()) {
                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CHourly rate can not be empty!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                    continue;
                                }

                                hourlyRate = Double.parseDouble(num);

                                // Display message if input is a negative number or zero
                                if (hourlyRate <= 0) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CHourly rate can not be zero or negative!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

                                } else {

                                    break;
                                }

                            }catch(NumberFormatException e){

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid input! Please enter numbers only.");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                                }

                        }

                        double hoursWorked = 0;

                        while(true){ // Prevent crash on non-numeric input

                            try {

                                System.out.println("\n\u2B55Enter the hours worked: ");
                                String num = scanner.nextLine().trim();

                                // Display error message for empty input
                                if (num.isEmpty()) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CHours worked can not be empty!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
                                    continue;
                                }

                                hoursWorked = Double.parseDouble(num);

                                // Display message if input is a negative number or zero
                                if (hoursWorked <= 0) {

                                    System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                    System.out.println("\u274CHours worked can not be zero or negative!");
                                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");


                                } else {

                                    break;
                                }

                            }catch(NumberFormatException e){

                                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                                System.out.println("\u274CInvalid input! Please enter numbers only.");
                                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                            }
                        }

                        double earning = hourlyRate*hoursWorked;

                        // Display total earning
                        System.out.println("\n**********************************************************************");
                        System.out.printf("\uD83D\uDCB5Total earning: Rs. %.2f%n",earning);
                        System.out.println("**********************************************************************");

                        break;

                    case 8:

                        // Display thank you message to the user
                        System.out.println("\n============================================================================================");
                        System.out.println("\uD83D\uDE00Thank you for using Freelance task tracker. Catch you tomorrow—keep hustling!\uD83D\uDE80");
                        System.out.println("============================================================================================");

                        break;
                }
                System.out.println();


            }catch(InputMismatchException e){

                // Show message for invalid user entry
                System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("\u274CInvalid input! Please enter numbers only.");
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

                scanner.nextLine();

            }
        }
    }
}

