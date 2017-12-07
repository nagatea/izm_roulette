package main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by nagatea on 2017/12/01.
 */
public class MemberList {
    public ArrayList<String[]> memberList;
    public MemberList(){
        try{
            File f = new File("test/sample.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f),"Shift-JIS"));

            memberList = new ArrayList<String[]>();
            String line = br.readLine();
            line = br.readLine();
            for (int row = 0; line != null ; row++) {
                memberList.add(line.split(",", 0));
                line = br.readLine();
            }
            br.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public ArrayList<String[]> getMemberList(){
        return memberList;
    }

    public void shuffleList(){
        Collections.shuffle(memberList);
    }

    public int getSize(){
        int res = memberList.size();
        return res;
    }

    public String[] popList(){
        String[] res = memberList.remove(0);
        return res;
    }

    public String[] getList(){
        String[] res = memberList.get(0);
        return res;
    }

    public String[] getNumber(){
        String[] res = new String[getSize()];
        for (int i = 0; i < getSize(); i++){
            res[i] = memberList.get(i)[0];
        }
        return res;
    }
}
