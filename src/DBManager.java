
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBManager{
    private Connection connection;

    public void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Создаем подключение.
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/javase_bitlab?useUnicode=true&serverTimezone=UTC","root", ""
            );
            System.out.println("CONNECTED");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public ArrayList<Cars> getAllCars(){
        ArrayList<Cars> cars = new ArrayList<>();
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM cars");

            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                double engineVolume = rs.getDouble("engine_volume");

                cars.add(new Cars(id,name,price,engineVolume));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return cars;
    }

    public void addCar(Cars car){
        try{
            PreparedStatement st = connection.prepareStatement("INSERT INTO cars(id, name, price, engine_volume) values(NULL,?,?,?)");

            st.setString(1,car.getName());
            st.setInt(2,car.getPrice());
            st.setDouble(3,car.getEngineVolume());
            st.setLong(4,car.getId());


            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateCar(Cars car){
        try{
            PreparedStatement st = connection.prepareStatement("UPDATE cars set name = ?, price = ?, engine_volume = ? where id = ?");
            st.setString(1, car.getName());
            st.setInt(2, car.getPrice());
            st.setDouble(3, car.getEngineVolume());
            st.setLong(4, car.getId());

            //Запускаем запрос на обновление данных
            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteCar(Long id){
        try{
            PreparedStatement st = connection.prepareStatement("DELETE FROM cars where id = ?");

            st.setLong(1, id);
            st.executeUpdate();

            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

