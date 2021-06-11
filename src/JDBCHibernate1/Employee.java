package JDBCHibernate1;

public class Employee {
    private int idEmploeey;
    private int idPosition;
    private String fName;
    private String sName;
    private String lName;
    private String phoneNumber;

    public Employee() {
    }

    public Employee(int idEmploeey, int idPosition, String fName, String sName, String lName, String phoneNumber) {
        this.idEmploeey = idEmploeey;
        this.idPosition = idPosition;
        this.fName = fName;
        this.sName = sName;
        this.lName = lName;
        this.phoneNumber = phoneNumber;
    }

    public int getIdEmploeey() {
        return idEmploeey;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public String getfName() {
        return fName;
    }

    public String getsName() {
        return sName;
    }

    public String getlName() {
        return lName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmploeey=" + idEmploeey +
                ", idPosition=" + idPosition +
                ", fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", lName='" + lName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
