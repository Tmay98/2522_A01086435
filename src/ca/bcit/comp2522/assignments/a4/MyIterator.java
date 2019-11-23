package ca.bcit.comp2522.assignments.a4;

/**
 * A generic means to iterate over elements of a set.
 *
 * @author Frances Mach
 * @author Tommy May
 * @version 2019
 */
public interface MyIterator<E> {
    
    /**
     * Checks if there are more objects in the set to iterate over.
     * @pre true
     * @post true
     * @return true if there are more objects in the set to iterate over, false otherwise
     */
    boolean hasNext();

    /**
     * Returns the next object of the set the iterator walks over.
     * @pre hasNext() == true
     * @post Iterator points to the next object in the set
     * @return The object in the set the iterator was pointing to when the method was called.
     */
    Object next(); 
}
