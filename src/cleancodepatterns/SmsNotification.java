package cleancodepatterns;

class SmsNotification implements NotificationInterface {
    @Override
    public void notify(User user) {
        System.out.println("sending sms to client " + user.toString());
    }
}
