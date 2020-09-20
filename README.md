# Project1
Introduction: This is a project for my CS 5343.001 - Algorithm Analysis and Data Structures course

In this project I will add methods to an existing linked list class and
make a stack to solve the balanced symbol problem.
  

Part 1 

   Modified the author's "MyLinkedList" class to add the following methods:

   a.  swap
        receives two index positions as parameters, and swaps the nodes at
        these positions by changing the links, provided both positions are 
        within the current size

   b.  shift
        receives an integer (positive or negative) and shifts the list this
        many positions forward (if positive) or backward (if negative).  
           1,2,3,4    shifted +1    2,3,4,1
           1,2,3,4    shifted -1    4,1,2,3

   c.  erase 
        receives an index position and number of elements as parameters, and
        removes elements beginning at the index position for the number of 
        elements specified, provided the index position is within the size
        and together with the number of elements does not exceed the size

   d.  insertList
        receives another MyLinkedList and an index position as parameters, and 
        copies the list from the passed list into the list at the specified
        position, provided the index position does not exceed the size.

   e.  main
        add code to the main method to demonstrate each of your methods
  

Part 2

  Create a MyStack class that uses an ArrayList to make a stack.

