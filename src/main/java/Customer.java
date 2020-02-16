import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private List<StorageMovement> movementList = new ArrayList<>();

    public Customer(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void addMovement (StorageMovement movement) {
        this.movementList.add(movement);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<StorageMovement> getMovementList() {
        List<StorageMovement> storageMovements = new ArrayList<>(movementList);
        return storageMovements;
    }
}
