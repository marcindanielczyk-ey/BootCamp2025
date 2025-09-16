package cleancodepatterns;

class EmailNotification implements NotificationInterface {
    @Override
    public void notify(User user) {
        System.out.println("sending email to client " + user.toString());
    }
}
