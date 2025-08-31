package cleancodepatterns;

import java.util.List;
import java.util.UUID;

public class UserProcessor {
    private List<UserStorageInterface> storages;
    private List<NotificationInterface> notifiers;
    private UserInputInterface inputHandler;
    private UserValidatorInterface validator;

    public UserProcessor(List<UserStorageInterface> storages, List<NotificationInterface> notifiers, UserInputInterface inputHandler, UserValidatorInterface validator) {
        this.storages = storages;
        this.notifiers = notifiers;
        this.inputHandler = inputHandler;
        this.validator = validator;
    }

    public void processUser() {
        UserData data = inputHandler.getUserData();

        if (!validator.validate(data)) {
            return;
        }

        String userId = UUID.randomUUID().toString();
        User user = new User(userId, data.name, data.email, data.phone, data.age);

        for (UserStorageInterface storage : storages) {
            storage.save(user);
        }

        for (NotificationInterface notifier : notifiers) {
            notifier.notify(user);
        }

        System.out.println("User processed successfully!");
    }


}

