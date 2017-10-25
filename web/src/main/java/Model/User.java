package Model;

import java.time.LocalDate;

/**
 * Created by Ника on 16.03.2017.
 */
public class User {

    private int id;
    public static String FIRST_NAME_KEY = "firstName";
    public static String USER_ID = "userId";
    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private boolean langRu;

    private String email;

    private String password; //

    private Boolean isMale;


    private byte[] photo;

    public User(int id,
                String firstName,
                String lastName,
                LocalDate dateOfBirth,
                boolean langRu,
                String email,
                String password,
                Boolean isMale,
                byte[] photo){
        this.id=id;
       this.firstName=firstName;
       this.lastName=lastName;
       this.dateOfBirth=dateOfBirth;
       this.langRu=langRu;
       this.email=email;
       this.password=password;
       this.photo=photo;
       this.isMale = isMale;
    }

    public User(int id_user, String first_name, String last_name) {
        this.id=id_user;
        this.firstName=first_name;
        this.lastName=last_name;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName(){ return firstName+" "+lastName; }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean getLangRu() {
        return langRu;
    }

    public String getEmail() {
        return email;
    }

    public Object getPasswordHash() {
        return password;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Boolean getIsMale() {
        return isMale;
    }
}
