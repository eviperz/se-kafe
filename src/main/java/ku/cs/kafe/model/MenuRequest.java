package ku.cs.kafe.model;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuRequest {
    private UUID categoryId;
    private String name;
    private double price;
}