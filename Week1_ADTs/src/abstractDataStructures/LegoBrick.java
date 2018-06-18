
package abstractDataStructures;

/*
 * Authors: Bernard, Emmanuel Kabeya, and Salmane
 */
public class LegoBrick {
   private int length;
   private int width;
   private int numberOfHeads;
   public String color;
   
   public LegoBrick(int length, int width, int numberOfHeads, String color){
       this.length = length;
       this.width= width;
       this.numberOfHeads = numberOfHeads;
       this.color = color;
   }
   
   public boolean equals(LegoBrick compareObject){
       return this.length == compareObject.length && 
               this.color == compareObject.color && 
               this.width == compareObject.width && 
               this.numberOfHeads == compareObject.numberOfHeads;
       
   }
}