package com.nanmolrao;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        log.log(Level.INFO, ()->"Hello World !");
    }
}