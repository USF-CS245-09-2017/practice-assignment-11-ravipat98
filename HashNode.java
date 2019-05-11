

public class HashNode<k,v>
{
    


    private String key;
    private String value;
    private HashNode<String,String> next;

    
    public HashNode(String key, String value)
    
    {
        this.key = key;
        this.value = value;
        next = null;
    }

    // getters 
    public String getValue()
    
    {
        return value;
    }
   
    public String getKey()
    
    {
        return key;
    }
    
    public HashNode getNext()
    
    {
        return next;
    }
    
    // the setters 
    public void setValue(String value)
    
    {
        this.value = value;
    }

    public void setKey(String key)
    
    {
        this.key = key;
    }
    
    public void setNext(HashNode<String,String> next)
    
    {
        this.next = next;
    }




}