import lombok.Getter;

@Getter
public class IdPost {
    public IdPost(int id, int petId, int quantity, String shipDate,String status, boolean complete ){
        this.id = id;
        this.petId = petId;
        this.quantity = quantity;
        this.shipDate = shipDate;
        this.status = status;
        this.complete = complete;

    }
    int id;
    int petId;
    int quantity;
    String shipDate;
    String status;
    boolean complete;
}
