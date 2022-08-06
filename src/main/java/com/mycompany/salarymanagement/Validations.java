/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.salarymanagement;

/**
 *
 * @author w10
 */
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;

public class Validations {

    //Function to check if the mobile number is valid or not
    public boolean isValidMobileNumber(String str) {
        // (0/91) : number starts with 0 or 91
        // [7-9] :  starting of the number can conatin digit from 7 to 9
        // [0-9] :ending of the number can contain digit from 0-9
        Pattern ptr = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        // matcher() method creates a matcher that matches the given input against the given pattern
        Matcher match = ptr.matcher(str);
        return (match.find() && match.group().equals(str));   // returns a boolean value
    }

    public void isValidName(java.awt.event.KeyEvent evt, javax.swing.JLabel label) {
        label.setVisible(false);
        char ch = evt.getKeyChar();
        if (Character.isLetter(ch) || ch == KeyEvent.VK_SPACE || ch == KeyEvent.VK_BACK_SPACE) {
        } else {
            label.setVisible(true);
            label.setText("Invalid Character " + ch);
            evt.consume();
        }
    }

    public String currentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/ yyyy");
        Date date = new Date();
        return (formatter.format(date));
    }

    public String currentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return (formatter.format(date));
    }
    int count = 0;

    public void isValidNumber(java.awt.event.KeyEvent evt, javax.swing.JLabel label) {
        label.setVisible(false);
        char ch = evt.getKeyChar();
        if (Character.isDigit(ch) || ch == '.' || ch == KeyEvent.VK_BACK_SPACE) {
            if (ch == '.') {
                count++;
                if (count > 1) {
                    label.setVisible(true);
                    label.setText("Decimal should be used only once");
                    evt.consume();
                }
            }

        } else {
            label.setVisible(true);
            label.setText("Inavlid Character " + ch);
            evt.consume();
        }
    }

    public void isValidContact(java.awt.event.KeyEvent evt, javax.swing.JLabel label) {
        label.setVisible(false);
        char ch = evt.getKeyChar();
        if (Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE) {
        } else {
            label.setVisible(true);
            label.setText("Invalid Character " + ch);
            evt.consume();
        }
    }
    int count1 = 0, count2 = 0;
    char lastChar = 'a';

    

    public boolean isValidEmailID(String email, javax.swing.JLabel label) {
        label.setVisible(false);
        String regex = "^(.+)@(gmail.com)$";
        Pattern ptrn = Pattern.compile(regex);
        Matcher matcher = ptrn.matcher(email);
        if(matcher.matches()==false){
        label.setText("Invalid Email ID");
        label.setVisible(true);}
        return matcher.matches();

    }

    public boolean passwordValidation(String password) {
        if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.!@#\\$%/^&*])(?=.*{10,})")) {
            System.out.println("Strong Password");
        } else if (password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*{10,})")) {
            System.out.print("Medium Password");
        } else if (password.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*{10,})")) {
            System.out.println("Weak Password");
        } else if (password.matches("^(?=.*[a-z])(?=.*[0-9])(?=.*{10,})")) {
            System.out.println("Weak Password");
        } else {
            System.out.println("Password is very weak");
        }
        return false;
    }
    int isUpper = 0;
    int isLower = 0;
    int isSpecial = 0;
    int isDigit = 0;
    char lastCharacter = '~';

    public void isValidPassword(String password, java.awt.event.KeyEvent evt, javax.swing.JLabel label) {
        label.setVisible(false);
        char ch = evt.getKeyChar();
        int length = password.length();
        if (ch == KeyEvent.VK_BACK_SPACE) {
            label.setVisible(false);
            switch (lastCharacter) {
                case 'u' -> {
                    isUpper--;
                    break;
                }
                case 'l' -> {
                    isLower--;
                    break;
                }
                case 'd' -> {
                    isDigit--;
                    break;
                }
                case 's' -> {
                    isSpecial--;
                    break;
                }
                default -> {
                }
            }

        }
        if (Character.isUpperCase(ch)) {
            isUpper++;
            lastCharacter = 'u';

        } else if (Character.isLowerCase(ch)) {
            isLower++;
            lastCharacter = 'l';
        } else if (Character.isDigit(ch)) {
            isDigit++;
            lastCharacter = 'd';
        } else if (ch == '.' || ch == '@' || ch == '*' || ch == '$' || ch == '#' || ch == '!' || ch == '/' || ch == '^' || ch == '%' || ch == '&' || ch == '\\') {
            isSpecial++;
            lastCharacter = 's';
        } else {
            label.setVisible(true);
            label.setText("Invalid Character " + ch);
            evt.consume();
        }
        System.out.println(isUpper + " " + isLower + " " + isDigit + " " + isSpecial + " " + length);
        if (isUpper >= 1 && isLower >= 1 && isDigit >= 1 && isSpecial >= 1 ) {
            label.setForeground(new Color(0, 204, 51));
            label.setText("Strong Password");
            label.setVisible(true);
        } else if (isUpper >= 1 && isLower >= 1 && isDigit >= 1 ) {
            label.setForeground(new Color(255, 153, 0));
            label.setText("Medium Password");
            label.setVisible(true);
        } else if ((isUpper >= 1 || isLower >= 1 || isDigit >= 1)) {
            label.setForeground(new Color(255, 0, 0));
            label.setText("Weak Password");
            label.setVisible(true);
        }
        if (ch == KeyEvent.VK_BACK_SPACE) {
            label.setVisible(false);
            switch (lastCharacter) {
                case 'u' -> {
                    isUpper--;
                    break;
                }
                case 'l' -> {
                    isLower--;
                    break;
                }
                case 'd' -> {
                    isDigit--;
                    break;
                }
                case 's' -> {
                    isSpecial--;
                    break;
                }
                default -> {
                }
            }
        }
    }

    public void isValidAadharNumber(String adhar, java.awt.event.KeyEvent evt, javax.swing.JLabel label) {
        label.setVisible(false);
        char ch = evt.getKeyChar();
        int length = adhar.length();

        if (Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE) {
            label.setVisible(false);
        } else {
            label.setVisible(true);
            label.setText("Invalid Character " + ch);
            evt.consume();
        }
        if (length == 11) {
            System.out.println("Adhar Number valid ");
            label.setForeground(new Color(0, 204, 51));
            label.setText("Valid Adhar Number");
            label.setVisible(true);
        } else {
            label.setForeground(new Color(255, 0, 0));
            label.setText("Invalid Adahr Number");
            label.setVisible(true);
        }
    }

    public void courseCodeValidation(java.awt.event.KeyEvent evt, javax.swing.JLabel label) {
        label.setVisible(false);
        char ch = evt.getKeyChar();
        if (Character.isLetter(ch) || Character.isDigit(ch) || ch == '.' || ch == KeyEvent.VK_BACK_SPACE || ch == KeyEvent.VK_SPACE) {
        } else {
            label.setVisible(true);
            label.setText("Invalid Character " + ch);
            evt.consume();
        }
    }

    public void isValidInteger(java.awt.event.KeyEvent evt, javax.swing.JLabel label) {
        label.setVisible(false);
        char ch = evt.getKeyChar();
        if (Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE) {
        } else {
            label.setVisible(true);
            label.setText("Invalid Character " + ch);
            evt.consume();
        }
    }
}
