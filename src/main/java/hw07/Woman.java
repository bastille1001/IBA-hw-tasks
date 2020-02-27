package hw07;

public class Woman extends Human {
    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public Woman() {
    }

    public Woman(String name, String surname, int year, int iq, String[][] schedule) {
        super(name, surname, year, iq, schedule);
    }

    public void greetPet() {
        System.out.printf("Hello, %s\n", getFamily().getPet().getNickname());
    }

    public void makeup() {
        System.out.println("Makeup time!");
    }
}
