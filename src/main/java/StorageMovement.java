import java.util.Date;

public class StorageMovement {
    private Date date;
    private MovementType type;
    private Customer customer;
    private Construction construction;
    private boolean isImplemented = false;

    public StorageMovement(Date date, MovementType type, Customer customer, Construction construction) {
        this.date = date;
        this.type = type;
        this.customer = customer;
        this.construction = construction;
    }

    public StorageMovement(Date date, MovementType type, Construction construction) {
        this.date = date;
        this.type = type;
        this.construction = construction;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MovementType getType() {
        return type;
    }

    public void setType(MovementType type) {
        this.type = type;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Construction getConstruction() {
        return construction;
    }

    public void setConstruction(Construction construction) {
        this.construction = construction;
    }

    public boolean isImplemented() {
        return isImplemented;
    }

    public void setImplemented(boolean implemented) {
        isImplemented = implemented;
    }
}
