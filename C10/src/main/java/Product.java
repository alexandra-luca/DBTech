@ActiveRecordEntity(tableName = "products", keyColumnName = "code")
public class Product extends ActiveRecord {

    public String code;
    public String name;
    public String description;
    public int stock;
    public float price;


    Product()
    {

    }

    public Product(String code, String name, String description, int stock, float price) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.stock = stock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
