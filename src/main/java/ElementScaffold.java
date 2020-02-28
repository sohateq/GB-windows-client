public class ElementScaffold {

    private String name;
    private int count = 0;
    private int defectiveCount = 0;
    private double weight;
    private double buyingPrice;

    public ElementScaffold(String name, int count, int defectiveCount, double weight, double buyingPrice) {
        this.name = name;
        this.count = count;
        this.defectiveCount = defectiveCount;
        this.weight = weight;
        this.buyingPrice = buyingPrice;
    }

    public ElementScaffold(String name, double weight, double buyingPrice) {
        this.name = name;
        this.weight = weight;
        this.buyingPrice = buyingPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDefectiveCount() {
        return defectiveCount;
    }

    public void setDefectiveCount(int defectiveCount) {
        this.defectiveCount = defectiveCount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public void countAppend (int append) {
        this.count += append;
    }

    public void defectiveCountAppend ( int append) {
        this.defectiveCount += append;
    }

    @Override
    public String toString() {
        return "ElementScaffold{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", defectiveCount=" + defectiveCount +
                ", weight=" + weight +
                ", buyingPrice=" + buyingPrice +
                '}';
    }
}
