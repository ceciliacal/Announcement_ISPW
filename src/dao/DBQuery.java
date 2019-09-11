package dao;

public class DBQuery {
    public static final String insertAnnounce = "INSERT INTO TenantAnnounce VALUES (?, ?,?,?,?,?,?,?,?,?,?,?,?)" ;
    public static final String searchUserType= "SELECT userType FROM User where id= ?  AND password= ?";
    public static final String searchUser= "SELECT id, password FROM user where id= ? AND password= ?";


}
