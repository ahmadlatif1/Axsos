package Java_OOP.AbstractArt;

public class Sculpture extends Art{
    private String model;

    public Sculpture(String title, String author, String description, String model) {
        super(title, author, description);
        this.model = model;
    }

    public Sculpture() {
        System.out.println(model);
    }

    @Override
    void viewArt() {
        super.viewArt();
        System.out.println(model);
    }
}
