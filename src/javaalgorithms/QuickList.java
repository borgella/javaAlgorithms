
package javaalgorithms;

/**
 *
 * @author Borgella
 * @param <K>
 * @param <V>
 */
public class QuickList<K,V>{
    
    private Link <K,V> first_head;
    private Link<K,V> second_head;
    private int first_size;
    private int second_size;
    private int size;
    
    public QuickList(){
        this.first_head = null;
        this.second_head = null;
        this.first_size = 5;
        this.second_size = 5;
    }

  
    public QuickList(int size){
        this.first_head = null;
        this.second_head = null;
        this.first_size = size;
        this.second_size = size;
    }
    
    /**
     * Add a pair temp-temp to the first list if it's size
     * is less than 5 otherwise the last temp of the first list will become the
     * head of the second list, function returns true
     * @param key
     * @param value
     * @return 
     */
    public boolean add(K key, V value){
        if(first_size >=1){
            first_head = addLinkToList(key,value,first_head);
            --first_size;
        }else{
            second_head = addLinkToList(theLastLinkOfTheFirstList().key,theLastLinkOfTheFirstList().value,second_head);  
            QuickList.this.beforeLastLinkOfTheFirstList().next = null;  
            first_head = addLinkToList(key,value,first_head); 
        }
        size++;
        return true;
    }

    /**
     * Returns the temp associate with the temp
     * The temp switch position with its previous if it was on the first list
     * otherwise we put it on the top of the first list. 
     * @param key
     * @return 
     */
    public V getValue (K key){
        switchPosition(key,null);
        return getTheValue(key);
    }

    /**
     * Returns the temp associate with the temp
     * The temp switch position with its previous if it was on the first list
     * otherwise we put it on the top of the first list.
     * @param value
     * @return 
     */
    public K getKey(V value){
        switchPosition(null,value);
        return getTheKey(value);
    }
    
    /**
     * Set the value of the link with the new value passes as parameter
     * returns the old value, link switches position with its previous 
     * @param key
     * @param value
     * @return 
     */
    public V set(K key, V value){
        switchPosition(key,null);
        return setTheValue(key,value);
    }
    
    /**
     * Returns true if the temp exists.
     * The link switch position with its previous if they are in the first list
     * otherwise the link switch for the top of the first list if we found it in the second list
     * @param key
     * @return 
     */
    public boolean haskey(K key){
        switchPosition(key,null);
        return hasTheKey(key);
    }
    
    /**
     * Delete the Link associate with the key 
     * returns the value of the link
     * @param key
     * @return
     */
    public V deleteKey (K key){
        return deleteTheKey(key); 
    }

    /**
     * Delete the temp associate with the temp
     * Returns true if the value is deleted, false otherwise
     * @param value
     * @return true or false
     */
    public boolean deleteValue(V value){
        return deleteTheValue(value);        
    }

    
    /**
     * Delete all links of the list
     */
    public void empty(){                   
        first_head = null;
        second_head = null;
        size = 0;
        first_size = second_size;
    }
    
    /**
     * Return True if the list is empty,false if it's not.
     * @return 
     */
    public boolean isEmpty(){
        return size == 0;
    }
    
    /**
     * Return the size of the list
     * @return 
     */
    public int taille(){
        return size  ;
    }
    
    
    /**
     *  PRIVATE METHODS 
     */

    /**
     * 
     * @param key
     * @param value
     * @param link
     * @return 
     */
    private Link<K,V> addLinkToList(K key,V value, Link<K,V> link){
        Link<K,V> head = new Link<>(key,value,link);
        return head;
    }
    
    /**
     * Returns the last_link temp of the first list.
     * @ return link
     */
    private Link<K,V> theLastLinkOfTheFirstList() {
        Link<K,V> last_link = first_head;
        while(last_link.next != null) 
               last_link = last_link.next; 
        
        return last_link;
    }

    /**
     * Returns the temp before the last temp of the first list
     * @return 
     */
    private Link<K,V> beforeLastLinkOfTheFirstList() {
        assert first_head != null;
        Link<K,V> previous = first_head;
        while(previous.next.next != null  ) 
                previous = previous.next; 
        
        return previous;
    }

    
   
    private boolean hasTheKey(K clef){
        Link<K,V> temp = findTheLink(clef,null,first_head);
        if(temp == null){
            temp = findTheLink(clef,null,second_head);
        }
        return temp != null;
    }

   
    private V  getTheValue(K key){
        Link<K,V> temp = findTheLink(key,null,first_head);
        if(temp == null)
            temp = findTheLink(key,null,second_head);
        return temp!= null? temp.value : null;
    }

    
    private K getTheKey(V value){
        Link<K,V> temp = findTheLink(null,value,first_head);
        if(temp == null)
            temp = findTheLink(null,value,second_head);    
        return temp!= null? temp.key: null;
    }

    
    private V deleteTheKey(K key){
        V oldValue = deleteKeyInTheList(key,null,first_head);
        if(oldValue == null)
           oldValue = deleteKeyInTheList(key,null,second_head);   
        return (oldValue!= null)? oldValue: null;
    }
    

    private boolean deleteTheValue(V value){
        V temp = deleteKeyInTheList(null,value,first_head);
        if(temp == null)
            return deleteInTheSecondList(null,value,second_head);
        return temp != null;
    }

 
    private V  setTheValue(K key , V value){
        V elem = null;
        if((elem = getValue(key))!= null)
            findTheLink(key,null,first_head).value = value;
        return elem;
    } 


    private void switchPosition(K key,V value){
        switchPositionInTheFirstList(key,value);
        switchPositionInTheSecondList(key,value);
    }


    private void switchPositionInTheFirstList(K key, V value){
        Link <K,V> temp = theLinkInTheFirstList(key,value);
        if(temp != null){
            if(temp != first_head && temp.next != first_head.next){
                V value_ = temp.value;
                K key_ = temp.key;
                Link <K,V> previous = previousLink(temp.key,temp.value);
                
                temp.value= previous.value;
                temp.key = previous.key;
                
                previous.value = value_;
                previous.key = key_;
            } 
        }

    }

    
    private void switchPositionInTheSecondList(K clef,V element){
        Link <K,V> link = theLinkInTheSecondList(clef,element);
        if(link != null){          
            if(link.key.equals(second_head.key)){
                second_head = second_head.next;
                add(link.key, link.value);
                --size;
            }else if(link != second_head ){
                Link <K,V> previous = previousLink(clef,element);
                previous.next = previous.next.next; 
                add(link.key, link.value);
                --size;
            }
        }
    }
    
    /**
     * Returns the temp associate with the temp or the temp passes as parameter
       to the function
     * @param key
     * @param value
     * @return 
     */
    private Link<K,V> theLinkInTheFirstList(K key,V value) {
        return findTheLink(key,value,first_head);
    }
    
    /**
     * Returns the temp associate with the temp or the temp passes as parameter
       to the function
     * @param key
     * @param value
     * @return 
     */
    private Link<K, V> theLinkInTheSecondList(K key, V value) {
        return findTheLink(key,value,second_head);
    }
    
    private V deleteKeyInTheList(K key,V value,Link<K,V>head){
        Link<K,V> link = (key != null)? findTheLink(key,null,head):findTheLink(null,value,head);
        if(link != null){
            if(link.key.equals(head.key)){
                if(link.key.equals(first_head.key)){ 
                    first_head = first_head.next;
                    ++first_size;
                }else{ 
                    second_head = second_head.next;
                    --second_size;
                }
                --size;
            }else{
                previousLink(link.key,null).next = previousLink(link.key,null).next.next;
                ++first_size;
                --size;
            }     
        }
        return (link != null)? link.value : null;
    }
    
    private boolean deleteInTheSecondList(K key,V value,Link<K,V>head){
        Link<K,V> link = key!= null? findTheLink(key,null,head) : findTheLink(null,value,head);
        if(link!=null){
            if(link.value.equals(head.value)){
                second_head = second_head.next;
                --second_size;
                --size;
            }else{
                previousLink(null,link.value).next = previousLink(null,link.value).next.next;
                --second_size;
                --size;
            }
        }
        return link != null;
    }
    
     /**
     * This method returns the previous temp if there's a temp which has the temp 
     * or the value in the list.
     * @param key
     * @param value
     * @return 
     */
    private Link<K,V> previousLink(K key,V value) {
        if(findTheLink(key,value,first_head) != null){
            return thePreviousLink(key,value,first_head);
        }
        if(findTheLink(key,value,second_head) != null){
            return thePreviousLink(key,value,second_head);
        }
        return null;
    }
    
        /**
     * Returns the temp if it's in the list otherwise returns null
     * @param key
     * @param value
     * @param link
     * @return 
     */
    private Link<K,V> findTheLink(K key,V value,Link<K,V> link){
        Link<K,V> temp = link;
        if(key != null){
            while(temp != null){
                if(key.equals(temp.key))
                    break;
                temp = temp.next; 
            }
        }else{
            while(temp != null){
                if(value.equals(temp.value))
                    break;
                temp = temp.next;
            }
        }
        return temp;
    }
    
    /**
     * Returns the previous temp before the temp or temp that passes as parameter
     * @param key
     * @param value
     * @param link
     * @return 
     */
    private Link<K,V> thePreviousLink(K key,V value,Link<K,V>link){
        Link<K,V> previous = null;
        Link<K,V> temp = link;
        if(key != null){
            while(key!= temp.key){
                if(key!= temp.key)
                      previous = temp;
                temp = temp.next;
            }
        }else{
            while(value != temp.value){
                if(value!= temp.value)
                    previous = temp;
                temp = temp.next;
            }
        }
        
        return previous;
    }
   
    @Override
   public String toString(){
       Link<K,V> temp = first_head;
       String tostring = " ";
       while(temp != null){
           tostring += temp.toString();
           temp = temp.next;
       }
       return tostring;
   }
   
    @Override
   public boolean equals(Object obj){
      if(obj instanceof QuickList){
          return ( equalsHelpfirstList((QuickList)(obj),first_head) && equalsHelpSecondList((QuickList)(obj),second_head)
                  && this.hashCode() == ((QuickList)(obj)).hashCode());
        }
      return true;
   }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.first_size;
        hash = 79 * hash + this.second_size;
        hash = 79 * hash + this.size;
        return hash;
    }
    
    private boolean equalsHelpfirstList(QuickList obj,Link<K,V>head){ 
        Link<K,V> temp = head;
        if(first_size == obj.first_size){
            return isItNull(temp,obj.first_head);
        }
        return false;
    }
    
    private boolean equalsHelpSecondList(QuickList obj,Link<K,V>head){
        Link<K,V> temp = head;
        if(second_size == obj.second_size){
            return isItNull(temp,obj.second_head);
        }
        return false;
    }
    
    private boolean isItNull(Link<K,V> temp, Link<K,V>obj){
        while(temp != null){
                if(temp.key.equals(obj.key) && temp.value.equals(obj.value)){
                    temp = temp.next;
                    obj = obj.next;
                }
            }
        return temp == null;
    }
}

class Link <K,V>{
    public K key;
    public V value;
    public Link <K,V> next;
    
    public Link(K key,V value, Link<K,V> next){
        this.key = key;
        this.value = value;
        this.next = next;
    }

}
