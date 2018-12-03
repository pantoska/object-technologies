package com.studia.to;

import com.studia.to.phone.PhoneNumber;
import com.studia.to.phone.PhoneNumberRepository;

import java.util.Arrays;
import java.util.Set;

public class TelephoneBookApp {
    public static void main(String[] args) {

        PhoneNumberRepository phoneNumberRepository = new PhoneNumberRepository();

        phoneNumberRepository.addNumber("Patrycja","Zań",new PhoneNumber("43534346"));
        phoneNumberRepository.addNumber("Bartek", "Ziomek",new PhoneNumber("435342346"));
        phoneNumberRepository.addNumber("Bartek", "Ziętek",new PhoneNumber("666666666"));
        phoneNumberRepository.addNumber("Bartek","Wnuk",new PhoneNumber("666246666"));
        phoneNumberRepository.addNumber("Julia","Walter",new PhoneNumber("666246666"));


        Set<PhoneNumber> findNumbers = phoneNumberRepository.findPhoneNumbers("Bartek", "null");
        for (PhoneNumber phoneNumber: findNumbers) {
            System.out.println(phoneNumber.getNumber());
        }

        //phoneNumberRepository.showContent();
    }

}
