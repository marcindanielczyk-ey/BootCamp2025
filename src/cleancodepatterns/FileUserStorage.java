package cleancodepatterns;

import java.io.FileWriter;
import java.io.IOException;

class FileUserStorage implements UserStorageInterface {
    @Override
    public void save(User user) {
        try {
            FileWriter writer = new FileWriter("user.log", true);
            writer.write("User created: " + user.toString() + "\n");
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
