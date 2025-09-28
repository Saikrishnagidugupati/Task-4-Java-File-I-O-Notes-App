/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.task4;
import java.io.*;
import java.util.Scanner;

public class Task4{
    private static final String FILE_NAME = "notes.txt";

    // Write notes to file
    public static void writeNote(String note) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) { // append mode
            fw.write(note + "\n");
            System.out.println("Note saved successfully!");
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }

    // Read notes from file
    public static void readNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
            System.out.println("------------------");
        } catch (FileNotFoundException e) {
            System.out.println("No notes found. Add some first!");
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }

    // Main Menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes App Menu ---");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    writeNote(note);
                }
                case 2 -> readNotes();
                case 3 -> System.out.println("Exiting Notes App...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        sc.close();
    }
}
