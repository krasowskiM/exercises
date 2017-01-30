package com.company.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    ServerSocket serverSocket = new ServerSocket();
//    Zapisać listę obiektów które mają zapisany login i hasło usera
//    sprawdzenie poprawnosci loginu i hasla podanie loginu i hasla login nie moze sie powtarzac

    private String[] passwords = {"123", "aaa", "qwerty", "Ania:)"};
    private List<UserCredentials> credentials = getCredentials();

    private List<UserCredentials> getCredentials(){
        List<UserCredentials> credentials = new ArrayList<>();
        credentials.add(new UserCredentials("Ania:)", "123"));
        credentials.add(new UserCredentials("Maciek", "aaa"));
        credentials.add(new UserCredentials("koteu", "qwerty"));
        credentials.add(new UserCredentials("nuuuuu", "567"));
        return credentials;
    }

    private void checkCredentials(){
        Scanner usernameInput = new Scanner(System.in);
        Scanner passwordInput = new Scanner(System.in);
        boolean credentialsOk = false;

        do {
            System.out.println("Please enter your username");
            String username = usernameInput.nextLine();
            System.out.println("Please enter your password");
            String password = passwordInput.nextLine();

            if(username.isEmpty() || password.isEmpty()){
                System.out.println("One of the credentials you provided is empty!");
                continue;
            }

            for (UserCredentials userCredentials : credentials) {
                if (username.equals(userCredentials.getUsername()) && password.equals(userCredentials.getPassword())) {
                    System.out.println("You are logged in.");
                    credentialsOk = true;
                    break;
                }
            }


            if(!credentialsOk){
              System.out.println("Wrong credentials! Please reenter.");
            }

        } while (!credentialsOk);
    }

    private void register(){
        System.out.println("To register, enter your username and password");
        Scanner unInput = new Scanner(System.in);
        Scanner passInput = new Scanner(System.in);
        String username;
        String password;
        String retypePassword;
        boolean exists;

        do {
            exists = false;
            System.out.println("Enter your username");
            username = unInput.nextLine();
            for (UserCredentials userCredentials : credentials) {
                if(username.equals(userCredentials.getUsername())){
                    System.out.println("Username already exists!");
                    exists = true;
                    break;
                }
            }

        } while (exists);

        do {
            System.out.println("Enter your password");
            password = passInput.nextLine();
            System.out.println("Retype password");
            retypePassword = passInput.nextLine();
            if (!retypePassword.equals(password)) {
                System.out.println("Passwords not match");
            }
        }
        while (!retypePassword.equals(password));

        credentials.add(new UserCredentials(username, password));
        System.out.println("You are registered, you can now log in.");
    }

    private void checkPassword() {
        String passwordToCheck;
        boolean found = false;
        System.out.println("Hello and welcome. Please enter your password.");
        Scanner input = new Scanner(System.in);
        do {
            passwordToCheck = input.nextLine();
            if (passwordToCheck.isEmpty()) {
                System.out.println("No empty passwords! LOL");
                continue;
            }
            for (String password : passwords) {
                if (passwordToCheck.equals(password)) {
                    System.out.println("You are now logged in.");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Password not found. Please reenter!");
            }
        } while (!found);
    }

    public static void main(String[] args) {
        Main main = new Main();
        boolean isFinished = false;
        Scanner inp = new Scanner(System.in);
        do {
            System.out.println("Choose an option of program 0 - login 1 - register 2 - close program.");
            switch (inp.nextInt()) {
                case 0:
                    main.checkCredentials();
                    break;
                case 1:
                    main.register();
                    break;
                case 2:
                    System.out.println("Program finish");
                    isFinished = true;
                    break;
                default:
                    System.out.println("Incorrect value! Reenter P:");
            }
        }
        while (!isFinished);
    }

    private void registerUser() {
        System.out.println("Please set your password");
        Scanner input = new Scanner(System.in);
        boolean found;
        String passwordToSave;
        do {
            found = false;
            passwordToSave = input.nextLine();
            for (String password : passwords) {
                if (passwordToSave.equals(password)) {
                    System.out.println("Password already exists!");
                    found = true;
                    break;
                }
            }
        } while (found);

        String[] temp1 = new String[passwords.length + 1];
        for(int i = 0; i < passwords.length; i++){
            temp1[i] = passwords[i];
        }
        temp1[temp1.length - 1] = passwordToSave;
        passwords = temp1;
        System.out.println("Password saved!");


    }
}









