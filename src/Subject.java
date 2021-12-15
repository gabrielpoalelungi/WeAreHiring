import javax.management.Notification;

public interface Subject {
     void addObserver(User user);
     void removeObserver(User c);
     void notifyAllObservers(Notification notification);
}
