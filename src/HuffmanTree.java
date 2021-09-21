import java.io.*;
import java.util.*;
public class HuffmanTree {
    int highest;
    HuffmanNode tree;
    public HuffmanTree(int[] count){
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>();
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0) {
                HuffmanNode b = new HuffmanNode(count[i], i);
                queue.add(b);
            }

        }
        highest = count.length;
        HuffmanNode exitCha = new HuffmanNode(1, highest);
        queue.add(exitCha);
        while(queue.size() != 1){
            HuffmanNode b = queue.poll();
            HuffmanNode c = queue.poll();
            HuffmanNode a = new HuffmanNode(b.value + c.value, b, c);
            //System.out.println(a.charval + " " + a.value);
            queue.add(a);
        }
        tree = queue.poll();

    }

    HuffmanTree(Scanner input){
        tree = new HuffmanNode(0, 0);
        HuffmanNode temp;
        while(input.hasNextLine()){
            temp = tree;
            int a = Integer.parseInt(input.nextLine());
            String b = input.nextLine();

            for(int i = 0; i < b.length(); i++){

                if(b.charAt(i) == '0') {
                    if (temp.left != null)
                        temp = temp.left;
                    else {
                        temp.left = new HuffmanNode(0, a);
                        temp = temp.left;
                    }
                }

                else {
                    if (temp.right != null)
                        temp = temp.right;
                    else {
                        temp.right = new HuffmanNode(0, a);
                        temp = temp.right;
                    }
                }
            }

        }
    }

    void write(PrintStream output){
        if(tree != null);
             tree(tree, output, "");
    }

    private void tree(HuffmanNode a, PrintStream output, String psdcod){

        if(a.left != null) {
            tree(a.left, output, psdcod + "0");
            tree(a.right,output, psdcod + "1");
        }
        else {
            output.println(a.charval);
            output.println(psdcod);
        }
    }

    void decode(BitInputStream input, PrintStream output, int eof){
        int val = 0;
        HuffmanNode temp;
        while(val != eof){
            if(val != 0)
                output.write(val);
            temp = tree;



            while (temp.left != null) {
                if (input.readBit() == 0)
                    temp = temp.left;
                else {
                    temp = temp.right;

                }
            }
            val = temp.charval;

        }

    }

}
