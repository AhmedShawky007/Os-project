//import java.sql.*;
//import java.util.ArrayList;
//
//public class DBcontroller {
//    public static Connection connect() throws SQLException {
//        return DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_reservation","root","");
//    }
//
//    public static void insert(String clientNo) {
//        try {
////            Connection con = connect();
//            Connection con=DriverManager.getConnection("insert into Plane values (?)");
//            Statement stmt=con.createStatement();
//            ResultSet rs=stmt.executeQuery("select clientNo from plane");
//
//            while(rs.next()){
//                System.out.println(rs.getString(1));
//            }
////            p.setString(1, clientNo);
////            p.execute();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//    }
//
//    public static ArrayList<Client> Display() {
//
//        ArrayList<Client> list = new ArrayList<>();
//        try {
//            Connection con = connect();
//            PreparedStatement p = con.prepareStatement("select * from plane ");
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//                list.add(new Client(r.getInt("seats"), r.getInt("clientNo")));
//
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//        return list;
//    }
//    public static int seatcount() {
//        int column_count = 0;
//        try {
//
//            Connection con = connect();
//            PreparedStatement p = con.prepareStatement("SELECT COUNT(seats) from plane");
//            ResultSet r = p.executeQuery();
//            ResultSetMetaData rsmd = r.getMetaData();
//             column_count = rsmd.getColumnCount();
//
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//
//        }
//
//        return column_count;
//    }
//
//
//    public static void update (int seatno,Client id){
//        try {
//            Connection con = connect();
//            PreparedStatement p = con.prepareStatement(" UPDATE `plane` SET `clientNo` = id WHERE `plane`.`seats` = "+id);
//
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    public static void numofseats (){
//        for (int count=0; count<10; count++) {
//            try {
//                Connection con = connect();
//                PreparedStatement p = con.prepareStatement("INSERT INTO `plane` (`seats`, `clientNo`) VALUES (?, null);"+ count);
//            }
//            catch (SQLException e) {
//                System.out.println(e.getMessage());
//            }
//    }
//
//}
//}
