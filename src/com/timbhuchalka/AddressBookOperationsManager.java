package com.timbhuchalka;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;

/**
 * Class Holds the methods used to  perform different operation on AddressBook
 */
class AddressBookManager
{
    /**
     * Add person method

     * @return
     */
    public static ArrayList<Contact> addAPersonInList(ArrayList<Contact> contacts)
    {
        boolean contactPresent = false;
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

        // Checking If Contact Present Or Not If Not present then Add new Contact
        for (Contact contact : contacts){
            if(contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName) ){
                contactPresent = true;
                System.out.println("Contact already Present add another Contact");
            }
        }
        if(contactPresent == false){
            contacts.add(new Contact(firstName, lastName, city, state, pNum, email));
        }

        return contacts;
    }

    /**
     * Show person method

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
     * edit person method

     * @return
     */
    public static  ArrayList<Contact> editContactList(ArrayList<Contact> contacts, String fname)
    {
        int m = 0;
        for (Contact contact : contacts) {
            int i = contacts.indexOf(contact);
            if(contacts.get(i).getFirstName().equals(fname)){
                boolean contactPresent = false;
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

                // Checking If Contact Present Or Not If Not present then Add new Contact
                contacts.add(i,new Contact(firstName, lastName, city, state, pNum, email));
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
     * delete person method

     * @return
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

    /**
     * Search Contact By city or a State and Count

     */
    public static void searchContactByCityOrState(ArrayList<Contact> contacts, String city){
        int m = 0;
        int count = 0;
        for (Contact contact : contacts) {
            int i = contacts.indexOf(contact);
            if(contacts.get(i).getCity().equals(city) || contacts.get(i).getState().equals(city)){
                System.out.println("Contact with : "+city+" : "+contacts.get(i).toString());
                m = 1;
                count++;
            }
        }
        System.out.println(count+" Number Of people Found with City/State : "+city+" in this AddressBook");
        if(m == 0){
            System.out.println("Contact not found with this City Or State");
        }
    }

    /**
     * Sort AddressBook By Names

     * @return
     */
    public static ArrayList<Contact> sortByName(ArrayList<Contact> contactList) {
        List<String> names = new ArrayList();
        for (Contact contact: contactList) {
            names.add(contact.getFirstName());
        }

        Stream<String> sortedNames = names.stream().sorted();

        ArrayList<Contact> sortedContactList = new ArrayList<>();

        sortedNames.forEach(name -> {
            for (Contact contact: contactList) {
                if(contact.getFirstName().equals(name)) {
                    sortedContactList.add(contact);
                    contactList.remove(contact);
                    break;
                }
            }
        });
        System.out.println("*** AddressBook Sorted Out By Name ***");
        return sortedContactList;
    }

    /**
     * Sort By City

     * @return
     */
    public static ArrayList<Contact> sortByCity(ArrayList<Contact> contactList) {
        List<String> names = new ArrayList();
        for (Contact contact: contactList) {
            names.add(contact.getCity());
        }

        Stream<String> sortedNames = names.stream().sorted();

        ArrayList<Contact> sortedContactList = new ArrayList<>();

        sortedNames.forEach(name -> {
            for (Contact contact: contactList) {
                if(contact.getCity().equals(name)) {
                    sortedContactList.add(contact);
                    contactList.remove(contact);
                    break;
                }
            }
        });
        System.out.println("*** AddressBook Sorted Out By City ***");
        return sortedContactList;
    }
}