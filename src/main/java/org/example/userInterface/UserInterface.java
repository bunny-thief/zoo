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

}
