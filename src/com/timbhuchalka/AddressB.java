package com.timbhuchalka;

import java.util.*;

public class AddressBook {
     /*
        Main Method
      */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + " *-*-*-*-*-*-*-*-*-*-*-*-*     WELCOME!     *-*-*-*-*-*-*-*-*-*-*-*-*" + ANSI_RESET);
        Scanner sc = new Scanner(System.in);

        Map<String, ArrayList<Contact>> drive = new HashMap<String, ArrayList<Contact>>(10);   //Map Of ArrayList to create A big Drive Of Addressbooks


        int maintain = 0;
        while(maintain == 0)
        {
            System.out.println("Enter a choice");
            System.out.println("1.Add a new AddressBook   2.Perform Operation on AddressBook  3.Display all AdressBooks   4.EXIT");
            int choice = sc.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter Address Book name to add");
                    Scanner sc1 = new Scanner(System.in);
                    String addressBookName1 = sc1.nextLine();
                    drive = ContactList.add(addressBookName1,drive);
                    System.out.println(addressBookName1+" AddressBook added");

                    break;

                case 2:
                    System.out.println("Enter Address Book name to Perform Operation On");
                    Scanner sc2 = new Scanner(System.in);
                    String addressBookName2 = sc2.nextLine();
                    AddressBookOperationsManager.addressBookOperation(drive.get(addressBookName2));
                    break;

                case 3:
                    Set<String> abKeySet = drive.keySet();
                    System.out.println("\n#####  ALL ADDRESSBOOKS-LISTS  #####");
                    for(String conName : abKeySet){
                        System.out.println("AddressBook :::::: "+conName);
                        AddressBookOperations.showPeopleList(drive.get(conName));
                    }
                    break;

                case 4:
                    System.out.println("------>   EXIT   <------");
                    System.out.println(ANSI_RED + "    *-*-*-*-*-*-*-*-*-*-*-*-*           Good Bye!            *-*-*-*-*-*-*-*-*-*-*-*-*   " + ANSI_RESET);
                    maintain = 1;
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;

            }
        }
    }
}

