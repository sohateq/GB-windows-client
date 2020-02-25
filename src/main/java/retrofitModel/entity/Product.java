package retrofitModel.entity;

import com.google.gson.annotations.Expose;

public class Product {

    @Expose
    private Integer id;
    @Expose
    private String name; // Название элемента
    @Expose
    private String source;
    @Expose
    private String status; // Статус элемента (бу/брак)
    @Expose
    private long count; // Количество элемента

    public Product(Integer id, String name, String source, String status, long count) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.status = status;
        this.count = count;
    }

    public Product(String name, String source, String status, long count) {
        this.name = name;
        this.source = source;
        this.status = status;
        this.count = count;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSource() {
        return source;
    }

    public String getStatus() {
        return status;
    }

    public long getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                ", status='" + status + '\'' +
                ", count=" + count +
                '}';
    }
}
