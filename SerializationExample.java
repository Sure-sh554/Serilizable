package Serilizable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {

    public static void main(String[] args) {
        Person person = new Person("Suresh", 26, "password");
        // Serialize the object

        try {
            FileOutputStream fileOutput = new FileOutputStream("person.per");
            ObjectOutputStream out = new ObjectOutputStream(fileOutput);
            out.writeObject(person);
            out.close();
            fileOutput.close();
            System.out.println("Object serialized Successfully");

        } catch (IOException e) {
            e.printStackTrace();
        }
        // Deserialize the Object
        Person deserializePerson = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("person.per");
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            deserializePerson = (Person) inputStream.readObject();
            inputStream.close();
            fileInputStream.close();
            System.out.println("Object deserialized successfully!");
            System.out.println("Name:" + deserializePerson.getName());
            System.out.println("Age:" + deserializePerson.getAge());
            // The password field is null because it is marked as transient
            System.out.println("Password:" + deserializePerson.getPassword());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        File file = new File("person.per");
        String path = file.getAbsolutePath();
        System.out.println("Serialized object written to: " + path);

    }

}
