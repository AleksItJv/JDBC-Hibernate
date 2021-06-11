package JDBCHibernate1;

public class Main {
    public static void main(String[] args) {

        MyJoinsDB myJoinsDB = new MyJoinsDB();

        myJoinsDB.getPhoneAddress();
        System.out.println("---------------------------------------");

        myJoinsDB.getNotMarriedEmployee();
        System.out.println("---------------------------------------");

        myJoinsDB.getManagers();
        System.out.println("---------------------------------------");

    }
}
