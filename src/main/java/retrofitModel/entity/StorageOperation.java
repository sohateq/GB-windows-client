package retrofitModel.entity;

import com.google.gson.annotations.Expose;

public class StorageOperation {

    @Expose
    private Integer id;
    @Expose
    private String date;
    @Expose
    private String customerName;
    @Expose
    private String type;
    @Expose
    private Integer stairsFrameCount;
    @Expose
    private Integer passFrameCount;
    @Expose
    private Integer diagonalConnectionCount;
    @Expose
    private Integer horizontalConnectionCount;
    @Expose
    private Integer crossbarCount;
    @Expose
    private Integer deckCount;
    @Expose
    private Integer supportsCount;
    @Expose
    private Integer stairsFrameBadCount;
    @Expose
    private Integer passFrameBadCount;
    @Expose
    private Integer diagonalConnectionBadCount;
    @Expose
    private Integer horizontalConnectionBadCount;
    @Expose
    private Integer crossbarBadCount;
    @Expose
    private Integer deckBadCount;
    @Expose
    private Integer supportsBadCount;
    @Expose
    private Boolean performed;

    public StorageOperation(String date, String customerName, String type, Integer stairsFrameCount,
                            Integer passFrameCount, Integer diagonalConnectionCount, Integer horizontalConnectionCount,
                            Integer crossbarCount, Integer deckCount, Integer supportsCount, Integer stairsFrameBadCount,
                            Integer passFrameBadCount, Integer diagonalConnectionBadCount,
                            Integer horizontalConnectionBadCount, Integer crossbarBadCount, Integer deckBadCount,
                            Integer supportsBadCount, Boolean performed) {
        this.date = date;
        this.customerName = customerName;
        this.type = type;
        this.stairsFrameCount = stairsFrameCount;
        this.passFrameCount = passFrameCount;
        this.diagonalConnectionCount = diagonalConnectionCount;
        this.horizontalConnectionCount = horizontalConnectionCount;
        this.crossbarCount = crossbarCount;
        this.deckCount = deckCount;
        this.supportsCount = supportsCount;
        this.stairsFrameBadCount = stairsFrameBadCount;
        this.passFrameBadCount = passFrameBadCount;
        this.diagonalConnectionBadCount = diagonalConnectionBadCount;
        this.horizontalConnectionBadCount = horizontalConnectionBadCount;
        this.crossbarBadCount = crossbarBadCount;
        this.deckBadCount = deckBadCount;
        this.supportsBadCount = supportsBadCount;
        this.performed = performed;
    }

    public StorageOperation(Integer id, String date, String customerName, String type, Integer stairsFrameCount,
                            Integer passFrameCount, Integer diagonalConnectionCount, Integer horizontalConnectionCount,
                            Integer crossbarCount, Integer deckCount, Integer supportsCount, Integer stairsFrameBadCount,
                            Integer passFrameBadCount, Integer diagonalConnectionBadCount,
                            Integer horizontalConnectionBadCount, Integer crossbarBadCount, Integer deckBadCount,
                            Integer supportsBadCount, Boolean performed) {
        this.id = id;
        this.date = date;
        this.customerName = customerName;
        this.type = type;
        this.stairsFrameCount = stairsFrameCount;
        this.passFrameCount = passFrameCount;
        this.diagonalConnectionCount = diagonalConnectionCount;
        this.horizontalConnectionCount = horizontalConnectionCount;
        this.crossbarCount = crossbarCount;
        this.deckCount = deckCount;
        this.supportsCount = supportsCount;
        this.stairsFrameBadCount = stairsFrameBadCount;
        this.passFrameBadCount = passFrameBadCount;
        this.diagonalConnectionBadCount = diagonalConnectionBadCount;
        this.horizontalConnectionBadCount = horizontalConnectionBadCount;
        this.crossbarBadCount = crossbarBadCount;
        this.deckBadCount = deckBadCount;
        this.supportsBadCount = supportsBadCount;
        this.performed = performed;
    }

    @Override
    public String toString() {
        return "StorageOperation{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", customerName='" + customerName + '\'' +
                ", type='" + type + '\'' +
                ", stairsFrameCount=" + stairsFrameCount +
                ", passFrameCount=" + passFrameCount +
                ", diagonalConnectionCount=" + diagonalConnectionCount +
                ", horizontalConnectionCount=" + horizontalConnectionCount +
                ", crossbarCount=" + crossbarCount +
                ", deckCount=" + deckCount +
                ", supportsCount=" + supportsCount +
                ", stairsFrameBadCount=" + stairsFrameBadCount +
                ", passFrameBadCount=" + passFrameBadCount +
                ", diagonalConnectionBadCount=" + diagonalConnectionBadCount +
                ", horizontalConnectionBadCount=" + horizontalConnectionBadCount +
                ", crossbarBadCount=" + crossbarBadCount +
                ", deckBadCount=" + deckBadCount +
                ", supportsBadCount=" + supportsBadCount +
                ", performed=" + performed +
                '}';
    }
}
