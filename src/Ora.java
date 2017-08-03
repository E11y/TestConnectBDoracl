import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class Ora {
    private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private String DB_Connection = "jdbc:oracle:thin:@";
    private String ip, DbUser, DbPassword, BdName;
    private int BdPort;


    public Connection getDBConnection(String ip, int BdPort, String BdName, String DbUser, String DbPassword) {
        this.ip = ip;
        this.BdPort = BdPort;
        this.BdName = BdName;
        this.DbPassword = DbPassword;
        this.DbUser = DbUser;
        DB_Connection = DB_Connection + this.ip + ":" + BdPort + ":" + BdName;
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
            Locale.setDefault(Locale.ENGLISH);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_Connection, this.DbUser, this.DbPassword);
            System.out.println("Connected Successfully to Oracle");
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
