package bk201.dev.autoledger;

public class clients {
    private String clFirstName;
    private String clLastName;
    private String clStreet;
    private String clCity;
    private String clZCode;
    private String clEmail;
    private String clNumber;
    private String clClientID;

    public clients(String clFirstName, String cLastName, String cStreet, String cCity, String cZCode, String cEmail, String cNumber, String cClientID) {
        this.clFirstName = clFirstName;
        this.clLastName = cLastName;
        this.clStreet = cStreet;
        this.clCity = cCity;
        this.clZCode = cZCode;
        this.clEmail = cEmail;
        this.clNumber = cNumber;
        this.clClientID = cClientID;
    }

    public String getClFirstName() {
        return clFirstName;
    }

    public void setClFirstName(String clFirstName) {
        this.clFirstName = clFirstName;
    }

    public String getClLastName() {
        return clLastName;
    }

    public void setClLastName(String clLastName) {
        this.clLastName = clLastName;
    }

    public String getClStreet() {
        return clStreet;
    }

    public void setClStreet(String clStreet) {
        this.clStreet = clStreet;
    }

    public String getClCity() {
        return clCity;
    }

    public void setClCity(String clCity) {
        this.clCity = clCity;
    }

    public String getClZCode() {
        return clZCode;
    }

    public void setClZCode(String clZCode) {
        this.clZCode = clZCode;
    }

    public String getClEmail() {
        return clEmail;
    }

    public void setClEmail(String clEmail) {
        this.clEmail = clEmail;
    }

    public String getClNumber() {
        return clNumber;
    }

    public void setClNumber(String clNumber) {
        this.clNumber = clNumber;
    }

    public String getClClientID() {
        return clClientID;
    }

    public void setClClientID(String clClientID) {
        this.clClientID = clClientID;
    }
}
