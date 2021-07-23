package com.timbhuchalka;

import java.util.ArrayList;
import java.util.Scanner;

class Contact
{
    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String pNum;
    private String email;


    public Contact(){
    }

    public Contact(String firstName, String lastName, String city, String state, String pNum, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.state = state;
        this.pNum = pNum;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public ArrayList<Contact> addAPersonInList(ArrayList<Contact> contacts, int i)
    {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter firstname, lastname,  city, state, phone number, emailID");
        firstName = sc.nextLine();
        lastName = sc.nextLine();
        city = sc.nextLine();
        state = sc.nextLine();
        pNum = sc.nextLine();
        email = sc.nextLine();
        contacts.add(i,new Contact(firstName, lastName, city, state, pNum, email));
        return contacts;
    }

    public void showPeopleList(ArrayList<Contact> contacts)
    {
        for (Contact contact : contacts) {
            String s = " " + contact.toString();
            System.out.println(s);
        }
    }

    public ArrayList<Contact> editContactList(ArrayList<Contact> contacts, String fname)
    {
        int m = 0;
        for (Contact contact : contacts) {
            int i = contacts.indexOf(contact);
            if(contacts.get(i).getFirstName().equals(fname)){
                contacts=contacts.get(i).addAPersonInList(contacts,i);
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

    public ArrayList<Contact> deleteContact(ArrayList<Contact> contacts, String fname){
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

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", pNum='" + pNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

class AddressBookManager{

    public static ArrayList<Contact> addressBookOperation(ArrayList<Contact> contactList){
        Contact contacts = new Contact();
        Scanner sc =new Scanner(System.in);

        System.out.println("enter number of people you want to add");
        int numOfPerson = sc.nextInt();
        for(int i= 0;i<numOfPerson;i++){
            contactList = contacts.addAPersonInList(contactList,i);
        }
        System.out.println("*** This is the List *****");
        contacts.showPeopleList(contactList);

        System.out.println("Enter first name of Contact which you want to edit");
        Scanner sname =new Scanner(System.in);
        String pname = sname.nextLine();
        contactList = contacts.editContactList(contactList,pname);
        System.out.println("*****  this is edited list  *****");
        contacts.showPeopleList(contactList);

        System.out.println("Enter first name of Contact which you want to delete");
        String dname = sname.nextLine();
        contactList = contacts.deleteContact(contactList,dname);
        System.out.println("****  this is edited list after deleting contact  *****");
        contacts.showPeopleList(contactList);

        return contactList;
    }
}

public class AdressB {
    public static void main(String[] args) {
        System.out.println("Welcome");
        Contact contacts = new Contact();

        System.out.println("Contact list of Student");
        ArrayList<Contact> contactListStud = new ArrayList<>();
        AddressBookManager.addressBookOperation(contactListStud);

        System.out.println("Contact list of Employees");
        ArrayList<Contact> contactListEmp = new ArrayList<>();
        AddressBookManager.addressBookOperation(contactListEmp);

        System.out.println("#####  ALL CONTACT-LISTS  #####");
        contacts.showPeopleList(contactListStud);
        System.out.println("");
        contacts.showPeopleList(contactListEmp);
    }
}