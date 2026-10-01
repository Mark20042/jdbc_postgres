import java.sql.*;

public class DemoJdbc {

    public static void main() {
        /*
            import package
            load register
            create connection
            create statement
            process the results
            close
         */


        String url = "jdbc:postgresql://localhost:5432/demo";
        String uname = "postgres";
        String pass = "Makoy20042";


        int sid = 6;

        String sname = "Christine";
        int marks = 98;

//        String sql =  "SELECT sname from student where sid = 1";
        String sql = "SELECT * from student";
//        String insertsql = "INSERT INTO student VALUES (" + sid + ",'" + sname + "', " + marks + ")";
        String insertsql = "INSERT INTO student VALUES (?,?,?)";
        String updatesql = "UPDATE student set sname='Max' where sid=4";
        String deletesql = "DELETE FROM student where sid=5";
        try {
//            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,uname,pass);

            System.out.println("koneksyon establis");


            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(insertsql);
            ps.setInt(1,8);
            ps.setString(2, "Makoy");
            ps.setInt(3, 100);
            ps.execute();

//            st.execute(insertsql);


            ResultSet result = st.executeQuery(sql);


            while(result.next()){
                System.out.print(result.getInt(1) + " - " );
                System.out.print(result.getString(2) + " - ");
                System.out.println(result.getInt(3));
       }



//            if(result.next())
//                System.out.println("Student name : " + result.getString("sname"));
//            else
//                System.out.println("Student not found.");


//            while(result.next()){
//                System.out.print(result.getInt(1) + " - " );
//                System.out.print(result.getString(2) + " - ");
//                System.out.println(result.getInt(3));
//            }
//


            con.close();
            System.out.println("Connection Close");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
