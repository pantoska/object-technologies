package com.studia.to;

import com.studia.to.phone.PhoneNumber;
import com.studia.to.phone.PhoneNumberRepository;

import java.util.Set;

public class TelephoneBookApp {
    public static void main(String[] args) {
        PhoneNumberRepository phoneNumberRepository = new PhoneNumberRepository();

        phoneNumberRepository.addNumber("Patrycja","Zań",new PhoneNumber("43534346"));
        phoneNumberRepository.addNumber("Bartek", "Ziomek",new PhoneNumber("4123232346"));
        phoneNumberRepository.addNumber("Bartek", "Ziętek",new PhoneNumber("666666666"));
        phoneNumberRepository.addNumber("Bartek","Ziętek",new PhoneNumber("666246666"));
        phoneNumberRepository.addNumber("Julia","Walter",new PhoneNumber("6662464466"));
        phoneNumberRepository.addNumber("Bartek","Wnuk",new PhoneNumber("66624221666"));


        Set<PhoneNumber> findNumbers = phoneNumberRepository.findPhoneNumbers("Bartek", "Ziętek");
        for (PhoneNumber phoneNumber: findNumbers) {
            System.out.println(phoneNumber.getNumber());
        }

//        Set<PhoneNumber> findNumbers2 = phoneNumberRepository.findPhoneNumbers("Patrycja", "Zań");
//        for (PhoneNumber phoneNumber: findNumbers2) {
//            System.out.println(phoneNumber.getNumber());
//        }

//        phoneNumberRepository.showContent();
    }

}
