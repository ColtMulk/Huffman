public class HuffmanNode implements Comparable<HuffmanNode> {
    int value;
    int charval;
    HuffmanNode left;
    HuffmanNode right;
    HuffmanNode(int value, int c){
        this.value = value;
        charval = c;
    }
    HuffmanNode(int value, HuffmanNode l, HuffmanNode r){
        this.value = value;
        left = l;
        right = r;
    }

    public int compareTo(HuffmanNode a){ //makes smaller frequencies greater when compared
        if(a == null)
            throw new IllegalArgumentException();
            return value - a.value;

    }

    public String toString(){
        return (charval + " " + value);
    }
}
