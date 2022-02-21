package sat.recruitment.api.repository;

import org.springframework.stereotype.Repository;
import sat.recruitment.api.enums.UserType;
import sat.recruitment.api.model.User;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public List<User> loadUsers(){

        List<User> users = new ArrayList<User>();

        InputStream fstream;
        try {
            fstream = getClass().getResourceAsStream("/users.txt");

            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            while ((strLine = br.readLine()) != null) {
                String[] line = strLine.split(",");
                User savingUser = new User();
                savingUser.setName(line[0]);
                savingUser.setEmail(line[1]);
                savingUser.setPhone(line[2]);
                savingUser.setAddress(line[3]);
                savingUser.setType(UserType.valueOf(line[4]));
                savingUser.setMoney(Double.valueOf(line[5]));
                users.add(savingUser);

            }
            fstream.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return users;
    }
}
