import java.util.function.Consumer;

public class CustomStack {
    private int[] items;
    private int size;
    final int initialCapacity=4;
    private int capacity;


    public CustomStack(){
        this.capacity=initialCapacity;
        this.items=new int[this.capacity];
    }
    public void resize(){
        if(this.capacity==this.size){
            int[] newArr=new int[this.capacity*2];
            System.arraycopy(this.items, 0, newArr, 0, this.items.length);
            this.items=newArr;
        }
    }

    void push(int element){
        this.size++;
        resize();
        this.items[this.size-1]=element;
    }
    int peek(){
        return this.items[this.size-1];
    }
    int pop(){
        int cur=this.items[this.size-1];
        this.items[this.size-1]=0;
        this.size--;
        return cur;
    }
    void forEach(Consumer<Integer> consumer){
        for(int i=0;i<this.size;i++){
            consumer.accept(this.items[i]);
        }
    }
}


