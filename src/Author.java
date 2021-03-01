
public class Author {
    private String firstName;
    private String lastName;
    private String middleName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName(){
        return String.format("%s %s %s", this.lastName, this.firstName, this.middleName);
    }

    @Override
    public String toString() {
        if(middleName == null){
            return String.format("%s %s", this.lastName, this.firstName);
        }
        else{
            return String.format("%s %s %s", this.lastName, this.firstName, this.middleName);
        }
    }

}
