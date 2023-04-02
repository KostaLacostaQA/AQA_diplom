package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.DriverManager;

public class DBInteraction {

    @SneakyThrows
    public static void deleteUser() {
        var runner = new QueryRunner();
        var deletePayment = "DELETE FROM payment_entity";
        var deleteOrder = "DELETE FROM order_entity";
        var deleteCredit = "DELETE FROM credit_request_entity";

        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")) {
            runner.update(conn, deletePayment);
            runner.update(conn, deleteOrder);
            runner.update(conn, deleteCredit);
        }
    }

    @SneakyThrows
    public static String checkUser() {
        var runner = new QueryRunner();
        var checkUser = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";

        try (var conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass")) {
            var status = runner.query(conn, checkUser, new ScalarHandler<String>());
            return status;
        }
    }
}
