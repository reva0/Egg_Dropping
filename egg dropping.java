package com.interview.dynamic;

public class EggDrop {

    public int calculate(int egg, int floor){
        
        int T[][] = new int[egg+1][floor+1];
        int c =0;
        for(int i=0; i <= floor; i++){
            T[1][i] = i;
        }
        
        for(int e = 2; e <= egg; e++){
            for(int f = 1; f <=floor; f++){
                T[e][f] = Integer.MAX_VALUE;
                for(int k = 1; k <=f ; k++){
                    c = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    if(c < T[e][f]){
                        T[e][f] = c;
                    }
                }
            }
        }
        return T[egg][floor];
    }
    
    public int calcRec(int egg, int floor){
        if(egg == 1){
            return floor;
        }
        if(floor == 0){
            return 0;
        }
        int min = 1000;
        for(int i=1; i <= floor; i++){
            int val = 1 + Math.max(calcRecegg-1, i-1),calcRec(egg, floor-i));
            if(val < min){
                min = val;
            }
        }
        return min;
    }
    
    public static void main(String args[]){
        EggDropping ed = new EggDrop();
        int r = ed.calculate(3,100);
        System.out.println(r);
    }
}