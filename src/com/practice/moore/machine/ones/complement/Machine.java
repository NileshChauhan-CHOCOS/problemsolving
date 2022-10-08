package com.practice.moore.machine.ones.complement;

public class Machine {
    private static Machine instance=null;
    private static final char[][] TRANSITION_TABLE={
            {'1', '2'},
            {'1', '2'},
            {'1', '2'}
    };
    static class STATE{
        char id;
        char outputSymbol;
        public STATE(char id, char outputSymbol){
            this.id=id;
            this.outputSymbol=outputSymbol;
        }
    }
    private static final STATE[] STATES = {
            new STATE('0', '0'),
            new STATE('1', '1'),
            new STATE('2', '0')
    };

    private Machine(){}
    public static Machine startMachine(){
        if(Machine.instance == null){
            instance=new Machine();
        }
        return instance;
    }

    public String getOneComplement(String inputSymbol){
        StringBuilder str = new StringBuilder();
        STATE currentState = STATES[0];
        for(int i = 0; i < inputSymbol.length(); i += 1){
            str.append(currentState.outputSymbol);
            int j = currentState.id - 48;
            int k = inputSymbol.charAt(i) - 48;
            currentState = STATES[TRANSITION_TABLE[j][k] - 48];
        }
        str.append(currentState.outputSymbol);
        return str.substring(1);
    }
}
