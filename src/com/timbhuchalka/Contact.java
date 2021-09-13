package com.timbhuchalka;

import java.util.ArrayList;

/**
 Contact Class used to create One Contact
 */
public class Contact
{
        private String firstName;
        private String lastName;
        private String city;
        private String state;
        private String pNum;
        private String email;

        /*
            Contact Class constructor
        */
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

        /*
            Getter Of First Name
         */
        public String getFirstName() {
                return firstName;
        }

        public String getLastName() { return lastName; }

        public String getCity() { return city; }

        public String getState() { return state; }

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