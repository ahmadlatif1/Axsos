package Java_OOP.AbstractArt;

public class Museum {

    static String[] modelStorage={
            "",
            "",
            ""
    };
    public static void main(String[] args) {
        Art[] arts=new Art[]{
                new Painting("Screaming Man","unknown","",Painting.canvasStorage[0]),
                new Painting("Starry Night","Vincent Van Gogh","he was clinically insane",Painting.canvasStorage[1]),
                new Painting("Dancing squidward","unknown","",Painting.canvasStorage[2]),
                new Sculpture("a vase","old neighbor","nice lady",modelStorage[0])

        };


        for (Art item : arts){
            item.viewArt();
        }
    }


}


