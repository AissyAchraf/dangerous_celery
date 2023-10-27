package Beans;

import java.util.Random;

public class User {

    public Boolean isGranted() {
        return new Random().nextBoolean();
    }
}
