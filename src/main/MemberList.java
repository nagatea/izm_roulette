package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by nagatea on 2017/12/01.
 */
public class MemberList {
    public ArrayList<String[]> data;
    public MemberList(){
        try{
            File f = new File("test/sample.csv");
            BufferedReader br = new BufferedReader(new FileReader(f));

            data = new ArrayList<String[]>();
            String line = br.readLine();
            for (int row = 0; line != null ; row++) {
                data.add(line.split(",", 0));
                line = br.readLine();
            }
            br.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public ArrayList<String[]> getMemberList(){
        return data;
    }
}
