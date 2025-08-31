package cleancodepatterns;

import java.util.HashMap;
import java.util.Map;

class MemoryUserStorage implements UserStorageInterface {
    private static final Map<String, User> inMemoryUserDatabase = new HashMap<>();

    @Override
    public void save(User user) {
        inMemoryUserDatabase.put(user.getId(), user);
    }
}
