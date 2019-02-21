package ArrayListInteger;

public interface ListInteger {
	/**
	 * Adds an Integer e to the end of the ArrayList
	 * @param e the Integer to add
	 * @return true if added
	 */
	public boolean add(Integer e);
	
	/**
	 * Adds an Integer e to the specified index index in the ArrayList
	 * @param index the index at which to add the element
	 * @param e the Integer to add
	 */
	public void add(int index, Integer e);
	
	/**
	 * Gets the Integer at the index
	 * @param index the index to retrieve the integer at
	 * @return the integer at the index
	 */
	public Integer get(int index);
	
	/**
	 * Removes the integer at the index
	 * @param index the index to remove the integer at
	 * @return the removed integer
	 */
	public Integer remove(int index);
	
	/**
	 * Finds the index of the integer
	 * @param e the integer to find
	 * @return the index of the integer
	 */
	public int indexOf(Integer e);
	
	/**
	 * Sets the integer at the index to <code>e</code>
	 * @param index the index to set at
	 * @param e the integer to set to
	 * @return the integer set
	 */
	public Integer set(int index, Integer e);
	
	/**
	 * Gets the size of the ArrayList
	 * @return the size of the ArrayList
	 */
	public int size();
	
	/**
	 * Gets string form of the ArrayList
	 * @return the string containing the elements of the ArrayList
	 */
	String toString();
	
}
