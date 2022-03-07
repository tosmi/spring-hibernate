package at.stderr.jackson.json.demo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

    public static void main(String[] args) {
        try {
            var mapper = new ObjectMapper();
            var student = mapper.readValue(new File("data/sample-full.json"), Student.class);

            System.out.println("First name: " + student.getFirstName());
            System.out.println("Last name: " + student.getLastName());

            var address = student.getAddress();

            System.out.println("Street: " + address.getStreet());
            System.out.println("City: " + address.getCity());

            for( var l : student.getLanguages()) {
                System.out.println(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
