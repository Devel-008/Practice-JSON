package com.java8;
//Basic Encoding and Decoding
import java.util.Arrays;
import java.util.Base64;
public class Base64BasicEncryptionExample {
        public static void main(String[] args) {
        // Getting encoder
        Base64.Encoder encoder = Base64.getEncoder();
        // Creating byte array
                byte[] byteArr = {1,2};
        // encoding byte array
                byte[] byteArr2 = encoder.encode(byteArr);
                System.out.println("Encoded byte array: "+ Arrays.toString(byteArr2));
        byte[] byteArr3 = new byte[5];                // Make sure it has enough size to store copied bytes
        int x = encoder.encode(byteArr,byteArr3);    // Returns number of bytes written
        System.out.println("Encoded byte array written to another array: "+ Arrays.toString(byteArr3));
        System.out.println("Number of bytes written: "+x);

        // Encoding string
        String str = encoder.encodeToString("JavaTPoint".getBytes());
        System.out.println("Encoded string: "+str);
        // Getting decoder
        Base64.Decoder decoder = Base64.getDecoder();
        // Decoding string
        String dStr = new String(decoder.decode(str));
        System.out.println("Decoded string: "+dStr);

        //URL Encoding and Decoding
                // Getting encoder
                Base64.Encoder encoder1 = Base64.getUrlEncoder();
                // Encoding URL
                String eStr = encoder1.encodeToString("http://www.javatpoint.com/java-tutorial/".getBytes());
                System.out.println("Encoded URL: "+eStr);
                // Getting decoder
                Base64.Decoder decoder1 = Base64.getUrlDecoder();
                // Decoding URl
                String dStr1 = new String(decoder1.decode(eStr));
                System.out.println("Decoded URL: "+dStr1);

                // Getting MIME encoder
                Base64.Encoder encoder2 = Base64.getMimeEncoder();
                String message = "Hello, \nYou are informed regarding your inconsistency of work";
                String eStr2 = encoder2.encodeToString(message.getBytes());
                System.out.println("Encoded MIME message: "+eStr2);

                // Getting MIME decoder
                Base64.Decoder decoder2 = Base64.getMimeDecoder();
                // Decoding MIME encoded message
                String dStr2 = new String(decoder2.decode(eStr2));
                System.out.println("Decoded message: "+dStr2);
        }
        }
