package Java_OOP.AbstractArt;

public abstract class Art {

    private String title;
    private String author;
    private String description;

    public Art() {
    }

    public Art(String title, String author, String description) {
        this.title = title;
        this.author = author;
        this.description = description;
    }

    void viewArt(){
        System.out.println("title: "+title);
        System.out.println("author: "+author);
        System.out.println("description: "+description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
