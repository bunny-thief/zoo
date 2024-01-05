package org.example.userInterface;

import org.example.repository.AnimalRepository;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private AnimalRepository animalRepository;

    public UserInterface(Scanner scanner, AnimalRepository animalRepository) {
        this.scanner = scanner;
        this.animalRepository = animalRepository;
    }

    public void run() {
        System.out.println("Animal Management System");

        while (true) {
            System.out.println("Select an option from the following menu:");
            System.out.println("1 - Insert animal");
            System.out.println("2 - Display Animals");
            System.out.println("4 - Exit\n");

            System.out.print("Enter choice: ");
            int choice = Integer.valueOf(scanner.nextLine());

            if (choice == 1) {
                addAnimal();
                continue;
            }

            if (choice == 2) {
                displayAnimals();
                continue;
            }

            if (choice == 4) {
                System.out.println("Good Bye!");
                break;
            }
        }
    }

    private void addAnimal() {
        System.out.println("\nEnter animal name and species:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Species: ");
        String species = scanner.nextLine();

        int result = animalRepository.addAnimal(name, species);

        if (result == 1) {
            System.out.printf("%s was added.\n\n", name);
        } else {
            System.out.printf("%s was not added.\n\n", name);
        }
    }

    private void displayAnimals() {
        System.out.println();
        animalRepository.displayAnimals();
        System.out.println();
    }

}