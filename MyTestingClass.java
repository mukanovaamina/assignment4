public class MyTestingClass {
    private int id;
    private String name;

    public MyTestingClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Custom hashCode method
    public int hashCode() {
        int result = 17;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


    public int getId() { //returns the value of the id instance variable
        return id;
    }

    public void setId(int id) { //sets the value of the id instance variable
        this.id = id;
    }

    public String getName() { //returns the value of the name instance variable
        return name;
    }

    public void setName(String name) { // sets the value of the name instance variable
        this.name = name;
    }
}
