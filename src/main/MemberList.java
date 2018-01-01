package main;

import core.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by nagatea on 2017/12/01.
 */
public class MemberList {
    public ArrayList<String[]> memberList;
    private File f;
    public MemberList(){
        try{
            if (Main.isDebug){
                f = new File("test/sample.csv");
            }else{
                f = new File("res/list.csv");
            }
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

    public int nowPriority(){
        int res = 100; //適当な大きい値
        int tmp;
        String[] data;
        for (int i = 0; i < getSize(); i++) {
            data = memberList.get(i);
            tmp = Integer.parseInt(data[3]);
            if(tmp < res){
                res = tmp;
            }
        }
        return res;
    }

    public int getSize(){
        int res = memberList.size();
        return res;
    }

    public String[] popList(){
        String[] res;
        int nowPriority = nowPriority();
        int resPrioroty;
        for (int i = 0; i < getSize(); i++) {
            res = memberList.remove(0);
            resPrioroty = Integer.parseInt(res[3]);
            if(resPrioroty == nowPriority){
                return res;
            } else {
                memberList.add(res);
            }
        }
        throw new IllegalArgumentException("Error");
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
