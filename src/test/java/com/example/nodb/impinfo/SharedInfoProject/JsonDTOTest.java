package com.example.nodb.impinfo.SharedInfoProject;

import com.example.nodb.impinfo.SharedInfoProject.guru.Child;
import com.example.nodb.impinfo.SharedInfoProject.guru.Parent;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JsonDTOTest {

    @Test
    public void testJson(){

        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/JsonFiles/DATA.json"))) {
            Parent[] parent=new Gson().fromJson(br,Parent[].class);

            System.out.println(parent);

            //this is the code for you
            List<Child> collect = Arrays.stream(parent).flatMap(parent1 -> parent1.getChild().stream()).collect(Collectors.toList());

            System.out.println(collect.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
