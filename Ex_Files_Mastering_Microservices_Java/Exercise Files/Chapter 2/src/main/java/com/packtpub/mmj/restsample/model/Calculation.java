package com.packtpub.mmj.restsample.model;

import java.util.ArrayList;
import java.util.List;

public class Calculation{

    public List<String> input;
    public List<String> output;
    public String mapping;

    public Calculation(List<String> input, List<String> output, String mapping){
        this.input = input;
        this.output = output;
        this.mapping = mapping;
    }
}
