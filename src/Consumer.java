import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public abstract class Consumer {

    private Resume resume;
    private LinkedList<Consumer> friends;

    public Consumer() {
        resume = null;
        friends = new LinkedList<>();
    }

    public Consumer (Resume resume) {
        this.resume = resume;
        friends = new LinkedList<>();
    }

    public Consumer (Resume resume, LinkedList<Consumer> friends) {
        this.resume = resume;
        this.friends = friends;
    }

    public Resume getResume() {
        return resume;
    }

    public LinkedList<Consumer> getFriends() {
        return friends;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public void add(Education education){
        resume.addToEduBackground(education);
    }

    public void add(Experience experience){
        resume.addToExpBackground(experience);
    }

    public void add(Consumer consumer){
        friends.add(consumer);
    }

    public void setFriends(LinkedList<Consumer> friends) {
        this.friends = friends;
    }

    public int getDegreeInFriendship(Consumer consumer){
        {
            int degree = 0;
            int level_size;
            LinkedList<Consumer> visited = new LinkedList<Consumer>();
            LinkedList<Consumer> queue = new LinkedList<Consumer>();
            visited.add(this);
            queue.add(this);

            while(queue.size() != 0) {
                level_size = queue.size();

                while(level_size > 0) {
                    Consumer searchedOne = queue.poll();
                    if (searchedOne.equals(consumer)) {
                        return degree;
                    }
                    Iterator<Consumer> it = searchedOne.friends.iterator();
                    while (it.hasNext()) {
                        Consumer searchedOneFriend = it.next();
                        if (visited.contains(searchedOneFriend) == false) {
                            visited.add(searchedOneFriend);
                            queue.add(searchedOneFriend);
                        }
                    }
                    level_size--;
                }
                degree++;
            }
            return 1000;
        }
    }

    public void remove(Consumer consumer) {
        friends.remove(consumer);
    }

    public Integer getGraduationYear() {
        TreeSet<Education> eduBackground = resume.getEduBackgnd();
        Iterator<Education> it = eduBackground.iterator();
        Integer gradYear = 0;
        while(it.hasNext()) {
            Education ed = it.next();
            if (ed.getLevel().compareTo("college") == 0) {
                if(ed.getEnd() != null)
                    gradYear = (Integer)ed.getEnd().getYear();
            }
        }
        return gradYear;
    }

    public Double meanGPA() {
        TreeSet<Education> eduBackground = resume.getEduBackgnd();
        Iterator<Education> it = eduBackground.iterator();
        Double sum = 0.0;
        Integer cnt = eduBackground.size();
        while(it.hasNext()) {
            Education ed = it.next();
            sum += ed.getGPA();
        }
        return sum/cnt;
    }
}
