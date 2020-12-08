/*
 *Nicholas Vourlas
 *December 10, 2020
 * ICS4U-01
 * Mr. Hofstatter
 * Grade Converter Assignment
 * A program that converts the numerical grades of students to letter grades and acts as a database by storing the grades
 * in a .txt file using the Java .nio class. These files can then be read and updated when the program is run again.
 */

package com.company;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class GradeConverter {

    //An instance variable that is assigned a value from the grade converter method below.
    static String specificLetterGrade = "";

    //Numerical-to-letter grade converter method. Includes data type and range error checking.
    public static String NumericalGradeConverter(String numericalGrade) {

        Scanner scan = new Scanner(System.in);
        Double roundedGrade = -1.0;
        String letterGrade = "";

        System.out.print("Please enter the student's numerical grade: ");
        numericalGrade = scan.nextLine();

        while (roundedGrade == -1.0) {
            try {
                roundedGrade = Double.parseDouble(numericalGrade);
                roundedGrade = Math.round(roundedGrade * 100.0) / 100.0;
            } catch (Exception e) {
                System.out.print("Invalid input, enter a number between 0 and 100; exceptions can be specified as a comment later: ");
                numericalGrade = scan.nextLine();
            }
            if (roundedGrade > 100.01) {
                System.out.print("Invalid input, enter a number between 0 and 100; exceptions can be specified as a comment later: ");
                numericalGrade = scan.nextLine();
                roundedGrade = -1.0;
            } else if (roundedGrade < 0) {
                System.out.print("Invalid input, enter a number between 0 and 100; exceptions can be specified as a comment later: ");
                numericalGrade = scan.nextLine();
                roundedGrade = -1.0;
            }
        }

        if (roundedGrade <= 100.0 && roundedGrade >= 0.0) {
            if (roundedGrade <= 100.0 && roundedGrade >= 95.0) {
                letterGrade = "A+";
            } else if (roundedGrade < 95.0 && roundedGrade >= 90.0) {
                letterGrade = "A";
            } else if (roundedGrade < 90.0 && roundedGrade >= 85.0) {
                letterGrade = "A-";
            } else if (roundedGrade < 85.0 && roundedGrade >= 80.0) {
                letterGrade = "B";
            } else if (roundedGrade < 80.0 && roundedGrade >= 70.0) {
                letterGrade = "C";
            } else if (roundedGrade < 70.0 && roundedGrade >= 60.0) {
                letterGrade = "D";
            } else if (roundedGrade < 90.0 && roundedGrade >= 0) {
                letterGrade = "F";
            }
        }

        specificLetterGrade = letterGrade;

        return letterGrade;
    }

    //An instance variable that is assigned a value from the error-checking method below.
    static String userChoice = "";

    //Versatile text error-catching method that only allows specified single-letter inputs.
    public static String InputErrorChecker(String optionOne, String optionTwo, String optionThree, String errorMessage) {
        Scanner scan = new Scanner(System.in);

        String userInputToCheck = scan.nextLine();

        while (!userInputToCheck.equalsIgnoreCase(optionOne) && !userInputToCheck.equalsIgnoreCase(optionTwo) && !userInputToCheck.equalsIgnoreCase(optionThree)) {
            System.out.print(errorMessage);
            userInputToCheck = scan.nextLine();
        }

        userChoice = userInputToCheck;

        return userInputToCheck;
    }

    //Instance variable that decides whether or not to continue running the program.
    static Boolean running = true;

    //Method that displays the main menu of the program and allows users to make the choice of what they want to do.
    public static String MainMenu() {
        System.out.print("Enter 'a' to view/rewrite existing student files, 'b' to create a new one, or 'c' to exit the program: ");

        InputErrorChecker("a", "b", "c",
                "Invalid input. Enter 'a' to view/rewrite existing student files, 'b' to create a new one, or 'c' to exit the program: ");

        if (userChoice.equalsIgnoreCase("a")) {
            ViewOrEditStudentLog();
        }
        if (userChoice.equalsIgnoreCase("b")) {
            CreateStudentLog();
        } else if (userChoice.equalsIgnoreCase("c")) {
            running = false;
        }

        return userChoice;
    }

    //Method that allows the user to create a student log
    public static String CreateStudentLog() {
        Scanner scan = new Scanner(System.in);

        String studentName = "";
        String subjectName1 = "";
        String subjectName2 = "";
        String subjectName3 = "";
        String subjectName4 = "";
        String subjectName5 = "";
        String subjectName6 = "";
        String subjectName7 = "";
        String subjectName8 = "";

        String subjectGrade1 = "";
        String subjectGrade2 = "";
        String subjectGrade3 = "";
        String subjectGrade4 = "";
        String subjectGrade5 = "";
        String subjectGrade6 = "";
        String subjectGrade7 = "";
        String subjectGrade8 = "";

        String comments = "";

        System.out.println("");
        System.out.print("What is the full name of the student whose file you are creating?: ");
        studentName = scan.nextLine();

        //Entering the names and grades of each subject.
        System.out.println("");
        System.out.print("What is the name of the first subject you would like to enter?: ");
        subjectName1 = scan.nextLine();
        NumericalGradeConverter(subjectGrade1);
        subjectGrade1 = specificLetterGrade;

        System.out.println("");
        System.out.print("What is the name of the second subject you would like to enter?: ");
        subjectName2 = scan.nextLine();
        NumericalGradeConverter(subjectGrade2);
        subjectGrade2 = specificLetterGrade;

        System.out.println("");
        System.out.print("What is the name of the third subject you would like to enter?: ");
        subjectName3 = scan.nextLine();
        NumericalGradeConverter(subjectGrade3);
        subjectGrade3 = specificLetterGrade;

        System.out.println("");
        System.out.print("What is the name of the fourth subject you would like to enter?: ");
        subjectName4 = scan.nextLine();
        NumericalGradeConverter(subjectGrade4);
        subjectGrade4 = specificLetterGrade;

        System.out.println("");
        System.out.print("What is the name of the fifth subject you would like to enter?: ");
        subjectName5 = scan.nextLine();
        NumericalGradeConverter(subjectGrade5);
        subjectGrade5 = specificLetterGrade;

        System.out.println("");
        System.out.print("What is the name of the sixth subject you would like to enter?: ");
        subjectName6 = scan.nextLine();
        NumericalGradeConverter(subjectGrade6);
        subjectGrade6 = specificLetterGrade;

        System.out.println("");
        System.out.print("What is the name of the seventh subject you would like to enter?: ");
        subjectName7 = scan.nextLine();
        NumericalGradeConverter(subjectGrade7);
        subjectGrade7 = specificLetterGrade;

        System.out.println("");
        System.out.print("What is the name of the eighth subject you would like to enter?: ");
        subjectName8 = scan.nextLine();
        NumericalGradeConverter(subjectGrade8);
        subjectGrade8 = specificLetterGrade;

        System.out.println("");
        System.out.print("Specify any addition comments you wish to include below: ");
        comments = scan.nextLine();

        System.out.println("");
        System.out.print("Would you like to save this student log as a .txt file? (Y/N): ");
        InputErrorChecker("Y", "Y", "N", "Invalid input. Would you like to save this student log as a .txt file? (Y/N): ");

        System.out.println("");
        if (userChoice.equalsIgnoreCase("y")) {
            String directory = System.getProperty("user.home");
            Path path = Paths.get(directory, "Student Log of " + studentName + ".txt");

            //Writing to files!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            try {
                Files.write(path, ("Student Log of " + studentName + "\r\n \r\n"
                        + subjectName1 + ": " + subjectGrade1 + "\r\n"
                        + subjectName2 + ": " + subjectGrade2 + "\r\n"
                        + subjectName3 + ": " + subjectGrade3 + "\r\n"
                        + subjectName4 + ": " + subjectGrade4 + "\r\n"
                        + subjectName5 + ": " + subjectGrade5 + "\r\n"
                        + subjectName6 + ": " + subjectGrade6 + "\r\n"
                        + subjectName7 + ": " + subjectGrade7 + "\r\n"
                        + subjectName8 + " " + subjectGrade8 + "\r\n"
                        + "\r\n Additional Comments:\r\n" + comments).getBytes(), StandardOpenOption.CREATE);
                System.out.println("File was saved under C:\\Users\\(user)");
            } catch (IOException e) {
                // exception handling
                System.out.println("An IO error occured and your file could not be saved.");
            }
        }
        if (userChoice.equalsIgnoreCase("n")) {
            System.out.println("File was not saved.");
        }

        return studentName;

    }

    //Method that allows the user to create a student log
    public static String ViewOrEditStudentLog() {
        Scanner scan = new Scanner(System.in);

        System.out.println("");

        String[] pathNames;

        String fileToOpen = "";

        // Used to locate the files that end in .txt in the Users folder and print them for selection.
        File f = new File("C:/Users/nicho");//MUST EDIT THIS LINE TO CORRESPOND WITH DESIRED DIRECTORY-------------------------------------------------------------------

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".txt");
            }
        };

        pathNames = f.list(filter);

        System.out.println("Below is a list of the .txt files in C:\\Users\\(user).");

        // For each pathname in the pathnames array...
        for (String pathname : pathNames) {
            // ...print the names of files and directories.
            System.out.println("-" + pathname);
        }

        System.out.print("Which one would you like to open?: ");
        fileToOpen = scan.nextLine();

        //Reading a selected file!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        String directory = System.getProperty("user.home");
        Path path = Paths.get(directory, fileToOpen);
        System.out.println("");

        try {
            List<String> list = Files.readAllLines(path);
            list.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            // exception handling
            System.out.println("Invalid input. Specified file does not exist.");
            ViewOrEditStudentLog();
        }

        System.out.println("");
        System.out.println("Would you like to rewrite this file? (Y/N):");
        InputErrorChecker("Y", "Y", "N", "Invalid Input. Would you like to rewrite this file? (Y/N):");

        if (userChoice.equalsIgnoreCase("Y")) {
            try {
                File fileToDelete = new File("C:\\Users\\nicho\\" + fileToOpen); //File to be deleted. MUST EDIT THIS LINE TO CORRESPOND WITH DESIRED DIRECTORY----------
                if (fileToDelete.delete()) //Produces a boolean value to use right after.
                {
                    System.out.println(fileToDelete.getName() + " is being rewritten..."); //Getting and printing the file name.
                } else {
                    System.out.println("to open file.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            CreateStudentLog();
        }

        return String.valueOf(pathNames);
    }

    //Main method.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello and welcome to the grade converter/student database. Files will be stored under C:\\Users\\(user).");

        while (running) {

            MainMenu();

        }
    }
}
