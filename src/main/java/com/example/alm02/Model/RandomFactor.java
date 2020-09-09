package com.example.alm02.Model;

import java.util.concurrent.ThreadLocalRandom;

public class RandomFactor {
    public int getRF(){
        return ThreadLocalRandom.current().nextInt(1, 11);
    }
}
