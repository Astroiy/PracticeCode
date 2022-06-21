package DataStructuresAndAlgorithm.Recursion;

public class WordsPuzzle {
    public static void findWord(String[][] characters,String[] wordList){
        int rows = characters.length;
        int columns = characters[0].length;
        boolean found = false;
        StringBuilder tmp=new StringBuilder();
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                tmp.delete(0,tmp.length());
                /**遍历对比横向左右两个方向*/
                int traversJ = j;
                while(traversJ<columns){
                    tmp.append(characters[i][traversJ]);
                    traversJ++;
                }
                for(String s:wordList){
                    if(tmp.toString().equals(s) || tmp.toString().contains(s)){
                        System.out.println("found "+s+" start at ("+i+","+j+")"+" to the right");
                        found = true;
                    }
                }
                tmp.delete(0, tmp.length());
                traversJ=j;
                while(traversJ>=0){
                    tmp.append(characters[i][traversJ]);
                    traversJ--;
                }
                for (String s : wordList) {
                    if (tmp.toString().equals(s) || tmp.toString().contains(s)) {
                        System.out.println("found " + s + " start at (" + i + "," + j + ")" + " to the left");
                        found = true;
                    }
                }

                /**遍历对比纵向上下两个方向*/
                tmp.delete(0, tmp.length());
                int traversI = i;
                while(traversI<rows){
                    tmp.append(characters[traversI][j]);
                    traversI++;
                }
                for(String s:wordList){
                    if(tmp.toString().equals(s) || tmp.toString().contains(s)){
                        System.out.println("found "+s+" start at ("+i+","+j+")"+" downwards");
                        found = true;
                    }
                }
                tmp.delete(0, tmp.length());
                traversI=i;
                while(traversI>=0){
                    tmp.append(characters[traversI][j]);
                    traversI--;
                }
                for(String s:wordList){
                    if(tmp.toString().equals(s) || tmp.toString().contains(s)){
                        System.out.println("found "+s+" start at ("+i+","+j+")"+" upwards");
                        found = true;
                    }
                }

                /**遍历主对角线*/

                int[] traversMainD = new int[]{i,j};
                tmp.delete(0,tmp.length());
                while(traversMainD[0]<rows && traversMainD[1]<columns){
                    tmp.append(characters[traversMainD[0]][traversMainD[1]]);
                    traversMainD[0]++;
                    traversMainD[1]++;
                }
                for(String s:wordList){
                    if(tmp.toString().equals(s) || tmp.toString().contains(s)){
                        System.out.println("found "+s+" start at ("+i+","+j+")"+" in diagonal direction downwards");
                        found = true;
                    }
                }
                tmp.delete(0, tmp.length());
                traversMainD[0]=i;
                traversMainD[1]=j;
                while(traversMainD[0]>=0 && traversMainD[1]>=0){
                    tmp.append(characters[traversMainD[0]][traversMainD[1]]);
                    traversMainD[0]--;
                    traversMainD[1]--;
                }
                for(String s:wordList){
                    if(tmp.toString().equals(s) || tmp.toString().contains(s)){
                        System.out.println("found "+s+" start at ("+i+","+j+")"+" in diagonal direction upwards");
                        found = true;
                    }
                }

                /**遍历副对角线*/

                int[] traversCounterD = new int[]{i,j};
                tmp.delete(0,tmp.length());
                while(traversCounterD[0]>=0 && traversCounterD[1]<columns){
                    tmp.append(characters[traversCounterD[0]][traversCounterD[1]]);
                    traversCounterD[0]--;
                    traversCounterD[1]++;
                }
                for(String s:wordList){
                    if(tmp.toString().equals(s) || tmp.toString().contains(s)){
                        System.out.println("found "+s+" start at ("+i+","+j+")"+" in diagonal direction upwards");
                        found = true;
                    }
                }
                tmp.delete(0, tmp.length());
                traversCounterD[0]=i;
                traversCounterD[1]=j;
                while(traversCounterD[0]<rows && traversCounterD[1]>=0){
                    tmp.append(characters[traversCounterD[0]][traversCounterD[1]]);
                    traversCounterD[0]++;
                    traversCounterD[1]--;
                }
                for(String s:wordList){
                    if(tmp.toString().equals(s) || tmp.toString().contains(s)){
                        System.out.println("found "+s+" start at ("+i+","+j+")"+" in diagonal direction downwards");
                        found = true;
                    }
                }
            }
        }
        if(!found)
            System.out.println("Match no words in Table");

    }







    public static class Test{
        public static void main(String[] args) {
            String[][] table = new String[][]{{"t","h","i","s"},{"w","a","t","s"},{"o","a","h","g"},{"f","g","d","t"}};
            String[] wordList = {"this","fat","two","that"};
            findWord(table,wordList);
        }
    }
}

