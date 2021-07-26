package java8.features;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    String city;
    String state;
    int pinCode;

}
