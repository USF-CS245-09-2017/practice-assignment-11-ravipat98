import java.util.ArrayList;


public class Hashtable<k,v>
{
    
    private int size;
    private ArrayList<HashNode<k,v>> slots;
    private double LAMBDA = 0.5;
    private int arrsize = 11;

    
    
    // constructer

    public Hashtable()
    {
        size = 0;
        slots = new ArrayList();
        for(int i=0; i < arrsize; i++ )
        {
            slots.add(null);
        }
    }

    

    // this is a function that gives us the slot of a specific key
    private int getSlot(String key)
    {
        int slot  = key.hashCode();
        return slot%slots.size();
    }

    

    
    public boolean containsKey(String key)
    {
        int slot = getSlot(key);
        HashNode node = slots.get(slot);
        while(node!=null){
            if(node.getKey()==key){
                return true;
            }
        }

        return false;
    }

    

    // we find the key and give back (return it) 
    public String get (String key)
    {
        int slot =  getSlot(key);
        HashNode node = slots.get(slot);

        while(node != null && node.getKey()!=key)
        {
            node.getNext();
        }
        if (node == null){
            return null;
        }

        return node.getValue();
    }

    

    
    protected void grow_array(){
        // we want to make a temp that is double in size
        
        ArrayList<HashNode<k,v>> temp = new ArrayList<>();
        // we copy the elements of the previous array into the temp 
        

        int i =0;
        for(i=0; i < arrsize*2; i++)
        {
            temp.add(null);
        }

        for(int j = 0; j < arrsize; j++)
        {
            temp.add(slots.get(j));
        }

        arrsize=arrsize*2;

        
        slots=temp; // arr = new arr


    }

    // this function places the value in the key we want it to in the array
    public void put (String key, String value)
    {


        int slot = getSlot(key);
        HashNode node = slots.get(slot);

        while(node != null && node.getKey()!=key)
        {
            node.getNext();
        }

        if (node!=null){
            node.setValue(value);
        }
        else{
            if(size/slots.size()>=LAMBDA)
            {
                grow_array();
            }

            HashNode newnode = new HashNode(key,value);
            newnode.setKey(key);
            newnode.setValue(value);
            newnode.setNext(node);
            slots.set(slot,newnode);
            size++;
        }


    }

    
    //remove function given a key
    public String remove (String key)
    {

        int slot = getSlot(key);

        HashNode node = slots.get(slot);
        HashNode prev = null;

        while(node.getNext()!= null && node.getKey()!=key)
        {
            prev = node;
            node = node.getNext();
        }

        if(node.getKey()==key && node==null)
        {
            return null;
        }
        if (prev == null)
        {
            slots.set(slot,node.getNext());
        }
        else
        {
            prev.setNext(node.getNext());
            size--;
        }
        return node.getValue();
    }

}