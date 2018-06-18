/*
 * Authors: Bernard, Emmanuel Kabeya, and Salmane
 */
package abstractDataStructures;


public class Bag implements ILegoBag<LegoBrick>{
    private LegoBrick[] array;
    private int currentSize;
    private int maxSize;
   
   
   public Bag(int maxSize){
        this.currentSize = 0;
        this.array = new LegoBrick[maxSize];
   }

    @Override
    public void add(LegoBrick objectToAdd) {
        //check if there is space
        if(this.getCurrentSize() < this.getMaxSize()){
            if(this.getCurrentSize() == 0){
                this.getArray()[0] = objectToAdd;
            } else{
                this.getArray()[currentSize - 1] = objectToAdd;
            }
            this.currentSize++;
        } else {
            System.out.println("Bag is full");
        }
    }

    @Override
    public void add(int index, LegoBrick objectToAdd) {
        //check if index is available
        if(index < this.getMaxSize() && index >= 0){
            this.getArray()[index] = objectToAdd;
            this.currentSize++;
        } else {
            System.out.println("Index is out of bounds or the bag is just full");
        }
    }

    @Override
    public void remove(int index) {
        if(index < this.getMaxSize() && index >= 0){
            if(index == this.getMaxSize() - 1){
                this.array[index] = null;
            } else {
                for(int i = index; i < this.getCurrentSize(); i++){
                    this.array[i] = this.array[i + 1];
                }
                this.array[this.currentSize - 1] = null;
            }
            this.currentSize--;
        }
    }

    @Override
    public void remove(LegoBrick objectToRemove) {
        if(!this.contains(objectToRemove)){
            System.out.println("Brick does not exist");
        } else {
            int index; 
            for(int i = 0; i < this.currentSize; i++){
                if(array[i].equals(objectToRemove)){
                    index = i;
                    this.remove(index);
                    break;
                }
            }
        }
    }

    @Override
    public void removeAll() {
        for(LegoBrick legoBrick : this.array){
            legoBrick = null;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    @Override
    public boolean contains(LegoBrick object) {
        for(LegoBrick legoBrick : array){
            if(legoBrick.equals(object)){
                return true;
            }
        }
        return false;
    }

    /**
     * @return the array
     */
    public LegoBrick[] getArray() {
        return array;
    }

    /**
     * @return the currentSize
     */
    public int getCurrentSize() {
        return currentSize;
    }

    /**
     * @param currentSize the currentSize to set
     */
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    /**
     * @return the maxSize
     */
    public int getMaxSize() {
        return maxSize;
    }
   
}