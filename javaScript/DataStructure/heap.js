"use strict";

/*
Basically heap is a priority Queue.
It can be represented as a binary tree as Heap is a complete binary three.
However, it can be represented as an array. In this representation, 
we need to define the index of the parents and both left and right children.
parent  = (index-1)/2
left    = index*2 + 1;
right  =  index*2 + 2;
The most important operation in Heap is trickle up and trickle down element.
trickle up is used during insertion, trickle down is used during deleting...
Trickle up is basically an iteration process of these following operation. 
1) The value of element is compared to its parent. if the value is higher, 
   we swap the value between them, update the index and parent.
2) if parent < 0 or the value of parent is greater than the element, 
   we break the iteration.
 
 Trickle down is opposite operation of trickle up.
 1) We compare the value of the element with its children 
 (i.e. we choose the maximum value of its children).
 2) If the maximum value of its children is lesser than the current value, exachange. 
 Otherwise, we break the iteration,
 
Compare to array/Linked list, insertion in heap is quite slow (i.e. O(logN)).
However Heap is good for finding maximum/ minimum entity.

As usual, I put the implementation of Heap data structure in my github.
Next time, we will talk about recursion.
*/

function Heap() {
  this.itemList = []; 
}

Heap.prototype.swap = function(i,j) {
  var temp = this.itemList[i];
  this.itemList[i] = this.itemList[j];
  this.itemList[j] = temp;
}

Heap.prototype.insert = function ( value ) {
 this.itemList.push(value);
 this.switchUp(this.itemList.length-1); 
}

Heap.prototype.delete = function () {
  if(this.itemList.length < 1) return;
  var value = this.itemList[0];
  this.itemList[0] = this.itemList[this.itemList.length-1];
   this.swithDown(0);
   return value;
}


//trickle up and down the progress... NEAT
Heap.prototype.switchUp = function (index) {
 if(index > (this.itemList.length -1) || index < 0) return; //this is invalid index
 var idx = index;
 var p = Math.floor((idx-1)/2);
 while(p>=0) {
    if(this.itemList[p] < this.itemList[idx]) {
      this.swap(p,idx);
      idx = p;
      p = Math.floor((idx-1)/2);
    } else {
      break;
    }
 }
}

Heap.prototype.swithDown = function (index) {
  var idx = index;
  var left = (index*2)+1;
  while(left < this.itemList.length) {
        var right = left+1;
        var max = left;
        //check if it has right child
        if( right < this.itemList.length) {
           if(this.itemList[right] > this.itemList[left]) {
           max = right;
           }
        }
        
     //compare the parents to the maximum of its child
        if(this.itemList[idx] < this.itemList[max]) {
           this.swap(idx, max);
           idx = max;
           left = (idx*2)+1;
        } else {
          break; 
        }
   }
}//end of method

