package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    public static void main(String[] args) {


      boolean optionFlag = true;
      while(optionFlag){

          System.out.println("Please select a choice");
          System.out.println("Adding a contact:  1");
          System.out.println("Modify a contact:  2");
          System.out.println("Search for a contact:  3");
          System.out.println("Remove a contact:  4");
          System.out.println("Printing contact list:  5");
          System.out.println("Quit:  6");
          System.out.println();

          if(scanner.hasNextInt()){

              int choice = scanner.nextInt();

              switch (choice){
                  case 1:
                      addContact();
                      break;
                  case 2:
                      modifyContact();
                      break;
                  case 3:
                      findContact();
                      break;
                  case 4:
                      remove();
                      break;
                  case 5:
                      print();
                      break;
                  case 6:
                      optionFlag = false;
                      break;
                  default:
                      optionFlag = false;
                      break;
              }
          }else{
              System.out.println("Please enter a number");

          }
          scanner.nextLine();

      }

    }

    public static String readName(){
        System.out.print("Please add name ");
        String name = scanner.next();
        return  name;
    }
    public static String readPhone() {
        System.out.print("Please add phone number ");
        String phone = scanner.next();
        return phone;
    }
    //clean up code duplication - add the printLNs in the loop above after removing top message from loop. pass the stored variables name and phone from scanner in loop into each method in the case statement
    public static void addContact(){

        String name = readName();
        String phone = readPhone();

        mobilePhone.addContact(name,phone);
    }

    public static void remove(){

        String name = readName();
        String phone = readPhone();
        mobilePhone.removeContact(name,phone);
    }

    public static void modifyContact(){
        String name = readName();
        String phone = readPhone();
        mobilePhone.modifyContact(name,phone);
    }

    public static void findContact(){
        System.out.println("Please write name to find");
        String name = readName();
//        System.out.println("Please add phone number");
//        String phone = scanner.nextLine();
        mobilePhone.SearchContact(name);
    }


    public static void print(){


        mobilePhone.printArrayList();

    }
}
