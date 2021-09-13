package com.timbhuchalka;
import java.util.ArrayList;
import java.util.Scanner;

/**
 AddressBook Manager Manages Operations
 */
public class AddressBookOperationsManager {

    public static ArrayList<Contact> addressBookOperation(ArrayList<Contact> contactList){
        Scanner sc =new Scanner(System.in);



        int maintainOp = 0;

        while (maintainOp == 0) {
            System.out.println("\n****** Enter the Operation you want perform on AddressBook ******");
            System.out.println("1.Add Contact   2.Edit Contact  3.Delete Contact  4.Print The Contacts  5.Sort AddressBook By Name  6.Sort AddressBook By City  7.Exit from This AddressBook");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add a Contact");
                    contactList = AddressBookOperationsManager.addAPersonInList(contactList);
                    break;

                case 2:
                    System.out.println("Enter first name of Contact which you want to edit");
                    Scanner sname = new Scanner(System.in);
                    String pname = sname.nextLine();
                    contactList = AddressBookOperationsManager.editContactList(contactList, pname);
                    break;

                case 3:
                    Scanner sdname = new Scanner(System.in);
                    System.out.println("Enter first name of Contact which you want to delete");
                    String dname = sdname.nextLine();
                    contactList = AddressBookOperationsManager.deleteContact(contactList, dname);

                    break;

                case 4:
                    System.out.println("******** This is the List **********");
                    AddressBookOperations.showPeopleList(contactList);
                    break;

                case 5:
                    contactList = AddressBookOperations.sortByName(contactList);
                    break;

                case 6:
                    contactList = AddressBookOperations.sortByCity(contactList);
                    break;

                case 7:
                    System.out.println("AddressBook Operation --> EXIT <--");
                    maintainOp = 1;
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }

        return contactList;
    }
}