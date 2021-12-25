package com.saraya.contactform.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

/**
 * @author NdourCodeur
 **/
public class ContactForm {

    @Size(min = 2, max = 100)
    private String firstName;
    
    @Size(max = 150)
    private String lastName;

    @Size(max = 180)
    @Email(message = "Please, enter a valid email.")
    private String email;

    @Size(max = 20)
    private String phone;

    @Size(max = 300)
    private String message;

    public ContactForm() {
    }

    public ContactForm(String firstName, String lastName, String email, String phone, String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }

    /**
     * @return String return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return String return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

}
