package com.example.schedulingtasks;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class MakeText {

    private static final String ACCOUNT_SID = System.getenv("AS");
    private static final String AUTH_TOKEN = System.getenv("AT");


    public static String send (String text){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message.creator(new PhoneNumber(System.getenv("SENDTO")),
                new PhoneNumber(System.getenv("SENDFROM")),
                text).create();
        return "Message sent";
    }

}
