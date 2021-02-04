import java.util.function.Consumer;

public class SmartArray {
    private int[] arr=new int[8];
    private int countOfNumbers=0;


    public void resize(){
        if(this.countOfNumbers==this.arr.length){
            int[] newArr=new int[this.arr.length*2];
            System.arraycopy(this.arr, 0, newArr, 0, arr.length);
            this.arr=newArr;
        }
    }
    public void add(int element){
        this.countOfNumbers++;
        resize();
        this.arr[countOfNumbers-1]=element;
    }

    public int get(int index){
        validate(index);
        return this.arr[index];

    }

    public void validate(int index){
        if(index>=this.arr.length||index<0){
            String message=String.format("Index %d out of bounds for length %d",index,this.arr.length);
            throw new IndexOutOfBoundsException(message);
        }
    }
    void shiftLeft(int index){
        for(int i=index+1;i<this.countOfNumbers;i++){
            this.arr[i-1]=this.arr[i];
        }
        this.arr[--countOfNumbers]=0;
    }

    void shiftRight(int index){
        this.countOfNumbers++;
        resize();
        for(int i=this.countOfNumbers;i>index;i--){
            this.arr[i]=this.arr[i-1];
        }


    }
    void add(int firstIndex, int element){
shiftRight(firstIndex);
this.arr[firstIndex]=element;
    }



    public int remove(int index){
        validate(index);
        int removed=this.arr[index];
       shiftLeft(index);

        return removed;
    }

    public boolean contains(int element){
        for(int i=0;i<this.countOfNumbers;i++){
            if(this.arr[i]==element){
                return true;
            }
        }
        return false;
    }


    void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.countOfNumbers; i++) {
            System.out.print("Position: "+i+" -> ");
            consumer.accept(this.arr[i]);
        }
    }


}
