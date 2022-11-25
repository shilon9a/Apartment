package entity;

public class t {
    private Integer id;
    private String name;

    public t(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public t() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "t{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
