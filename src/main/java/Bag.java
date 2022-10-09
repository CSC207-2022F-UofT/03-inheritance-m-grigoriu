/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    /*
     * TODO: Create the following private instance variables
     *       - a String named color
     *       - an int named numberOfContents
     *       - an int named capacity
     *       - an array of Strings named contents
     */
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;

    /**
     * TODO: Create a constructor that takes two arguments:
     *       - a String representing the Bag's colour
     *       - an int representing the Bag's capacity
     *
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     *
     * Creates a new Bag object with the given color and capacity.
     *
     * @param color The color of the bag
     * @param capacity The capacity of the bag
     */
    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[] {};
    }

    /*
     * TODO: Create a variety of 'getter' functions.
     *       These should be named:
     *           - getColor
     *           - getNumberOfContents
     *           - getCapacity
     */

    /**
     * Returns the color of the Bag
     *
     * @return the color of this Bag
     */
    public String getColor() {
        return this.color;
    }

    /**
     * Returns the number of contents in the Bag
     *
     * @return the number of contents in this Bag
     */
    public int getNumberOfContents() {
        return this.numberOfContents;
    }

    /**
     * Returns the capacity of the Bag
     *
     * @return the capacity of this Bag
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * TODO: Create a setter function called setColor which sets the
     *       color of this bag to the given color.
     *
     * Changes the color of the Bag to the given color
     *
     * @param color The new color of the Bag
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * TODO: Create a method called addItem that takes in a String
     *       representing an item in the Bag.
     *       The item is added into the Bag if the number of items
     *       in the bag is < the capacity of the Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     *       This method should return true if the item was added
     *       and false otherwise.
     *
     * Adds the given item to the contents of this Bag and updates numberOfContents if Bag is not full
     * Returns true if item was added to the bag, false if the Bag is full and item cannot be added
     *
     * @param item The item to be added to the Bag
     * @return whether the item was added to the Bag
     */
    public boolean addItem(String item) {
        if (this.numberOfContents >= this.capacity) {
            return false;
        }
        String[] newContents = new String[this.contents.length + 1];

        for (int i = 0; i < this.contents.length; i++) {
            newContents[i] = this.contents[i];
        }

        newContents[this.contents.length] = item;
        this.contents = newContents;
        this.numberOfContents += 1;
        return true;
    }

    /**
     * TODO: Create a method called popItem that returns a String.
     *       The string should be the last item added to this Bag
     *       and the item should be removed from this Bag.
     *       Remember to modify numberOfContents accordingly.
     *
     * Removes the last item in the Bag from contents and updates numberOfContents.
     * If there are no items in this Bag, return null.
     *
     * @return the item removed from this Bag, or null if contents is empty
     */
    public String popItem() {
        if (this.numberOfContents == 0) {
            return null;
        }

        String[] newContents = new String[this.contents.length - 1];

        for (int i = 0; i < newContents.length; i++) {
            newContents[i] = this.contents[i];
        }

        String poppedItem = this.contents[this.contents.length - 1];

        this.contents = newContents;
        this.numberOfContents -= 1;
        return poppedItem;
    }

    /**
     * Increase this bag's capacity by n.
     *
     * @param n The amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        // TODO: Implement this method.
        this.capacity += n;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return A string representing the details of this Bag
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}