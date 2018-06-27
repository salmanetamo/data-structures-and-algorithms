package extension_activities;

/**
 *
 * @author Salmane Tamo
 * 26/06/2018
 */
public class CacheItem {
    private int frequency;
    private String cacheItemContent;
    
    
    public CacheItem(){
        this.frequency = 0;
        this.cacheItemContent = "Empty cache item";
    }
    
    public CacheItem(String cacheItemContent){
        this.frequency = 0;
        this.cacheItemContent = cacheItemContent;
    }
    
    public CacheItem(String cacheItemContent, int frequency){
        this.frequency = frequency;
        this.cacheItemContent = cacheItemContent;
    }

    /**
     * @return the frequency
     */
    public int getFrequency() {
        return frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    /**
     * @return the cacheItemContent
     */
    public String getCacheItemContent() {
        return cacheItemContent;
    }
    
    @Override
    public boolean equals(Object o){
        if(o instanceof CacheItem){
            CacheItem item = (CacheItem)o;
            return item.cacheItemContent.equals(this.cacheItemContent);
        }
        return false;
    }
    
    @Override
    public String toString(){
        return "Content:" + this.cacheItemContent + ", Frequency: " + this.frequency;
    }
}
