package dao;

import java.util.List;
import model.Consumer;

public interface ConsumerDao {

    // create -> void
    void add(Consumer consumer);

    // read -> List
    List<Consumer> selectAll(); // select * from consumer
    List<Consumer> selectUsernameAndPassword(String username, String password); // select * from consumer where username=? and password=?
    List<Consumer> selectById(int id); // retrieve data by ID
    List<Consumer> selectByUsername(String username);

    // update -> void
    void update(Consumer consumer); // retrieve data and update it

    // delete -> void
    void delete(int id);

}
