package com.example.michael.deliveryapp;

/**
 * ItemIterator interface is considered a well created class interface.
 * <p/>
 * Cohesion: This iterator pattern Works with  abstractions of Items
 * <p/>
 * Clarity: operators share the same names of common methods from the
 * Java Library
 * <p/>
 * Completeness: An essential unit that works in the ItemAdapter subclasses
 * and other activities that need to generate input data.
 * <p/>
 * Convenience: Eliminates the complexity of forLoops and Case and Switches.
 * <p/>
 * Consistency: The methods are only focused on methods that help with a
 * list iterator
 * Created by michael on 12/1/2015.
 */
public interface ItemIterator {
    boolean hasNext();

    Item next();
}


