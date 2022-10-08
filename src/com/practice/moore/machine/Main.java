package com.practice.moore.machine;

import com.practice.moore.machine.ones.complement.Machine;

public class Main {
    public static void main(String[] args){
        String str = "1101011100001100110101010";
        System.out.println(str);
        System.out.println(Machine.startMachine().getOneComplement(str));
    }
}
