package org.example.characterAndStringProcessing;

public class YZswapper {
    public static void main(String[] args) {
        printSwappedYZSwitch("yootaxz");
        printSwappedYZSwitch("yanthoxzl");
        printSwappedYZSwitch("YZyz");
    }

    static void printSwappedYZSwitch(String string){
        for(int i = 0; i<string.length(); i++){
            string = switch(string.charAt(i)){
                case 'y' -> { yield changeCharAt(string, i, 'z'); }
                case 'z' -> { yield changeCharAt(string, i, 'y'); }
                case 'Y' -> { yield changeCharAt(string, i, 'Z'); }
                case 'Z' -> { yield changeCharAt(string, i, 'Y'); }
                default -> { yield string; }
            };
        }
        System.out.println(string);
    }

    static void printSwappedYZ(String string){
        for(int i = 0; i<string.length(); i++){
            char current = string.charAt(i);
            if(current == 'y'){
                string = changeCharAt(string, i, 'z');
            }else if(current == 'z'){
                string = changeCharAt(string, i, 'y');
            }else if(current == 'Y'){
                string = changeCharAt(string, i, 'Z');
            }else if(current == 'Z'){
                string = changeCharAt(string, i, 'Y');
            }
        }
        System.out.println(string);
    }

    static String changeCharAt(String toChange, int index, char replacement){
        return toChange.substring(0,index) +replacement+(index+1<toChange.length()?toChange.substring(index+1,toChange.length()):"");
    }
}
