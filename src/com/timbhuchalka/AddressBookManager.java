package com.timbhuchalka;

import java.util.ArrayList;
import java.util.Scanner;
/**
 AdressBook Manager Manages Operations
 */
public class AddressBookManager{

    public static ArrayList<Contact> addressBookOperation(ArrayList<Contact> contactList){
        Scanner sc =new Scanner(System.in);



        int maintainOp = 0;
        int i=0;
        while (maintainOp == 0) {
            System.out.println("\n****** Enter the Operation you want perform on AddressBook ******");
            System.out.println("1.Add Contact   2.Edit Contact  3.Delete Contact  4.Print The Contacts  5.Exit from This AddessBook");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Add a Contact");
                    contactList = AddressBookOperations.addAPersonInList(contactList, i);
                    i++;
                    break;

                case 2:
                    if(i==0){ System.out.println("No Contact available to edit"); }
                    else {
                        System.out.println("Enter first name of Contact which you want to edit");
                        Scanner sname = new Scanner(System.in);
                        String pname = sname.nextLine();
                        contactList = AddressBookOperations.editContactList(contactList, pname);
                    }
                    break;

                case 3:
                    if(i==0){ System.out.println("No Contact available to delete"); }
                    else {
                        Scanner sdname = new Scanner(System.in);
                        System.out.println("Enter first name of Contact which you want to delete");
                        String dname = sdname.nextLine();
                        contactList = AddressBookOperations.deleteContact(contactList, dname);
                        int check = i-1;
                        if(contactList.size() == check) {
                            i--;
                        }
                    }
                    break;

                case 4:
                    if(i==0){ System.out.println("No Contact available to SHOW"); }
                    else {
                        System.out.println("******** This is the List **********");
                        AddressBookOperations.showPeopleList(contactList);
                    }
                    break;

                case 5:
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