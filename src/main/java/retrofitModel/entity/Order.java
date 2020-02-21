package retrofitModel.entity;

import com.google.gson.annotations.Expose;

public class Order {

    @Expose
    private Integer orderId;
    @Expose
    private String clientName;
    @Expose
    private String creationDate;
    @Expose
    private String acceptionDate;
    @Expose
    private String returnDate;
    @Expose
    private long typeOneCount;
    @Expose
    private long typeTwoCount;
    @Expose
    private long typeThreeCount;
    @Expose
    private long typeFourCount;
    @Expose
    private long typeFiveCount;
    @Expose
    private long typeSixCount;
    @Expose
    private long typeSevenCount;
    @Expose
    private String orderStatus;

    public Order(Integer orderId, String clientName, String creationDate,
                 String acceptionDate, String returnDate, long typeOneCount,
                 long typeTwoCount, long typeThreeCount, long typeFourCount, long typeFiveCount,
                 long typeSixCount, long typeSevenCount, String orderStatus) {
        this.orderId = orderId;
        this.clientName = clientName;
        this.creationDate = creationDate;
        this.acceptionDate = acceptionDate;
        this.returnDate = returnDate;
        this.typeOneCount = typeOneCount;
        this.typeTwoCount = typeTwoCount;
        this.typeThreeCount = typeThreeCount;
        this.typeFourCount = typeFourCount;
        this.typeFiveCount = typeFiveCount;
        this.typeSixCount = typeSixCount;
        this.typeSevenCount = typeSevenCount;
        this.orderStatus = orderStatus;
    }

    public Order(String clientName, String creationDate, String acceptionDate,
                 String returnDate, long typeOneCount, long typeTwoCount, long typeThreeCount,
                 long typeFourCount, long typeFiveCount, long typeSixCount, long typeSevenCount,
                 String orderStatus) {

        this.clientName = clientName;
        this.creationDate = creationDate;
        this.acceptionDate = acceptionDate;
        this.returnDate = returnDate;
        this.typeOneCount = typeOneCount;
        this.typeTwoCount = typeTwoCount;
        this.typeThreeCount = typeThreeCount;
        this.typeFourCount = typeFourCount;
        this.typeFiveCount = typeFiveCount;
        this.typeSixCount = typeSixCount;
        this.typeSevenCount = typeSevenCount;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientName='" + clientName + '\'' +
                ", creationDate=" + creationDate +
                ", acceptionDate=" + acceptionDate +
                ", returnDate=" + returnDate +
                ", typeOneCount=" + typeOneCount +
                ", typeTwoCount=" + typeTwoCount +
                ", typeThreeCount=" + typeThreeCount +
                ", typeFourCount=" + typeFourCount +
                ", typeFiveCount=" + typeFiveCount +
                ", typeSixCount=" + typeSixCount +
                ", typeSevenCount=" + typeSevenCount +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
