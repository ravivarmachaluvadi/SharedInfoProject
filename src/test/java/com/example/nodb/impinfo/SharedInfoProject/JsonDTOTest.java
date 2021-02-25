package com.example.nodb.impinfo.SharedInfoProject;

import com.example.nodb.impinfo.SharedInfoProject.guru.Child;
import com.example.nodb.impinfo.SharedInfoProject.guru.Parent;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class JsonDTOTest {

    @Test
    public void testJson(){

        try (BufferedReader br = new BufferedReader(new FileReader("src/test/resources/JsonFiles/DATA.json"))) {
            Parent[] parent=new Gson().fromJson(br,Parent[].class);
            System.out.println(parent);

            //code for you
            List<Parent> parentList= Arrays.asList(parent.clone());

            Map<String,Parent> stringListMap=new HashMap<>();
            parentList.stream().forEach(parent1 -> {
                if(stringListMap.containsKey(parent1.getField())){
                    stringListMap.get(parent1.getField()).getChild().addAll(parent1.getChild());
                }else {
                    stringListMap.put(parent1.getField(), parent1);
                }
            });

            //sorting children
            stringListMap.forEach((s, parent1) -> {
                List<Child> children=parent1.getChild().stream().sorted((o1, o2) -> o1.getId().compareTo(o2.getId())).collect(Collectors.toList());
                Set set = new LinkedHashSet(children);
                parent1.setChild(set);
                stringListMap.put(s,parent1);
            });


            stringListMap.forEach((s, children) -> System.out.println(s+" "+children));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
