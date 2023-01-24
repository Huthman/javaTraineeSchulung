package com.materna.exercises.dataStructures;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UniqueIterator<E> implements Iterator<E> {
  private Iterator<? extends E> iterator;
  private E next;
  private HashSet<E> returnedBefore = new HashSet<>();

  public UniqueIterator(Iterator<? extends E> iterator){
    this.iterator = iterator;
    E next = null;
  }
  @Override
  public boolean hasNext() {
    while(iterator.hasNext() && next == null){
      next = iterator.next();
      if(returnedBefore.contains(next)){
        next = null;
      }
    }
    if(next == null){
      return false;
    }
    return true;
  }

  @Override
  public E next() {
    if(!hasNext()){
      throw new NoSuchElementException();
    }
    returnedBefore.add(next);
    E toReturn = next;
    next = null;
    return toReturn;
  }
}
