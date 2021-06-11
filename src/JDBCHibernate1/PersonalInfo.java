package JDBCHibernate1;

import java.sql.Date;

public class PersonalInfo {

    private int id;
    private int idEmployee;
    private int married;
    private Date birthday;
    private String address;

    public PersonalInfo(){
    }

    public PersonalInfo(int id, int idEmployee, int married, Date birthday, String address) {
        this.id = id;
        this.idEmployee = idEmployee;
        this.married = married;
        this.birthday = birthday;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public int getMarried() {
        return married;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getAddress() {
        return address;
    }
}
