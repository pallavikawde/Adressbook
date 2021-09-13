package com.timbhuchalka;

import java.util.ArrayList;
import java.util.Scanner;

  public class AddressBookOperations
    {
        /**
         Add person method
         */
        public static ArrayList<Contact> addAPersonInList(ArrayList<Contact> contacts, int i)
        {
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter firstname :");
            String firstName = sc.nextLine();
            System.out.println("Enter lastname :");
            String lastName = sc.nextLine();
            System.out.println("Enter city :");
            String city = sc.nextLine();
            System.out.println("Enter state :");
            String state = sc.nextLine();
            System.out.println("Enter phone number :");
            String pNum = sc.nextLine();
            System.out.println("Enter emailID :");
            String email = sc.nextLine();
            contacts.add(i,new Contact(firstName, lastName, city, state, pNum, email));
            return contacts;
        }

        /**
         Show person method
         */
        public static void showPeopleList(ArrayList<Contact> contacts)
        {
            System.out.println("----------------------------------------------------------");
            for (Contact contact : contacts) {
                String s = "-- >>" + contact.toString();
                System.out.println(s);
            }
            System.out.println("----------------------------------------------------------");
        }

        /**
         edit person method
         */
        public static  ArrayList<Contact> editContactList(ArrayList<Contact> contacts, String fname)
        {
            int m = 0;
            for (Contact contact : contacts) {
                int i = contacts.indexOf(contact);
                if(contacts.get(i).getFirstName().equals(fname)){
                    contacts= AddressBookOperations.addAPersonInList(contacts,i);
                    contacts.remove(contact);
                    m = 1;
                    break;
                }
            }
            if(m == 0){
                System.out.println("Contact not found with this name");
            }
            return contacts;
        }

        /**
         delete person method
         */
        public static ArrayList<Contact> deleteContact(ArrayList<Contact> contacts, String fname){
            int m = 0;
            for (Contact contact : contacts) {
                int i = contacts.indexOf(contact);
                if(contacts.get(i).getFirstName().equals(fname)){
                    contacts.remove(contact);
                    System.out.println("contact of "+fname+" has been deleted");
                    m = 1;
                    break;
                }
            }
            if(m == 0){
                System.out.println("Contact not found with this name");
            }
            return contacts;
        }
    }



