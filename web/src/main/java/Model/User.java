package Model;

import java.time.LocalDate;

/**
 * Created by Ника on 16.03.2017.
 */
public class User {

    private int id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private boolean langRu;

    private String email;

    private String password; //

    //private ??? photo
    private byte[] photo;

    public User(int id,
                String firstName,
                String lastName,
                LocalDate dateOfBirth,
                boolean langRu,
                String email,
                String password,
                byte[] photo){
        this.id=id;
       this.firstName=firstName;
       this.lastName=lastName;
       this.dateOfBirth=dateOfBirth;
       this.langRu=langRu;
       this.email=email;
       this.password=password;
       this.photo=photo;
    }

}
