//²âÊÔRegexValidatorµÄÇý¶¯³ÌÐò

import java.util.*;

public class RegexValidatorTest {

public static void main(String[] args)  {
    Scanner sc = new Scanner(System.in);

 	String email = RegexValidator.validateEmail(sc, "Please enter your email address: ");
 	System.out.println("Your email is " + email);

	String ssn = RegexValidator.validateSNN(sc, "Please enter your SSN (xxx-xx-xxxx): ");
 	System.out.println("Your SSN is " + ssn);

	String phoneNumber = RegexValidator.validatePhoneNumber(sc, "Please enter your phone number: ");
 	System.out.println("Your Phone number is " + phoneNumber);
  }

 }