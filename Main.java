import java.util.Random;

public class Main {

    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        Random random = new Random();


        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(1000);
            String name = "Name_" + i;
            MyTestingClass key = new MyTestingClass(id, name);
            table.put(key, "Value_" + i);
        }

    }

}
