package Annotation;

public class MyObject {
    private String name;

    public MyObject() {
    }

    public String getName() {
        return name;
    }
    @MyAnnotation
    public void setName(String name) {
        this.name = name;
    }
}
