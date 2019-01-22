package src.questions;

public class RemoveExtraSpaces {

    public static void removeSpaces(char[] str){
        int i=0,j=0;

        while(i < str.length){
            if(str[i]==' '){
                i++;
            }else{
                while(i < str.length && str[i] !=' '){
                    str[j] = str[i];
                    j++;
                    i++;
                }
                if(i < str.length && str[i]==' '){
                    str[j] = ' ';
                    j++;
                }
            }
        }
        while(j < str.length){
            str[j] = ' ';
            j++;
        }
    }

}
