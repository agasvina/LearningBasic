"use strict";
/*
This is just implementation of shunting yards algoritm.
You have two stack:
  numberStack and operatorStack;
The algoritm goes like this. 
for n in equation;
1) if n = number put into numberStack;
2) if n = operator, if last element of operatorStack is higher/equal operator
   pop the operator, and apply calculation
   Push the operator to operatorStack
3) if n = "("; push to operator Stack
4) if n = ")"; pop from operatorStack and apply calculation until you find ")"

5) iterate until operatorStack is empty and apply the calculation back and forth

You can find the simple implementation of this algorithm in my github (i.e. written in javascript)
shuntingYard.js

Enjoy ^^
*/

//Some cool Regex
//using Regex find the quation inside []
var regex = /\[(.*?)\]/;
var sentences = "[ 2+(3*(8-4)) ] experiments were conducted this year";
//take the second arrays..
var eq = regex.exec(sentences);
console.log( eval(eq[1]) );

//shunting yard
function shunting( eq ) {
  var numberStack = [];
  var operatorStack = [];
  var equation = eq.replace(/ /g,'');
  for(var i = 0; i < equation.length; i++) {
    var temp = equation.charAt(i);
     if(!isNaN(temp)) {
      //check next element until it cannot find number:
       //dealing with number more than one character
       for(var j = i+1; j < equation.length;j++) {
          if(isNaN(equation.charAt(j))) break;
          temp = temp+equation.charAt(j);
          i++;
       }
       numberStack.push(parseInt(temp)); 
       
     } else {
      if(temp == "+") {
        //check last element of operator stack
        var last = operatorStack[operatorStack.length-1];
        if(last == "x" || last == "/" || last == "-") {
          var b = numberStack.pop();
          var a = numberStack.pop();
          var calc = calculate(a,b, last);
          numberStack.push(calc);
        }
        operatorStack.push(temp);
        console.log(operatorStack.length);
      } else if(temp == "-") {
        //check last element of operator stack
        var last = operatorStack[operatorStack.length-1];
        if(last == "x" || last == "/" || last == "+") {
          var b = numberStack.pop();
          var a = numberStack.pop();
          var calc = calculate(a,b, last);
          numberStack.push(calc);
        }
        operatorStack.push(temp); 
      } else if(temp == "x") {
        //check last element of operator stack
        var last = operatorStack[operatorStack.length-1];
        if(last == "/") {
          var b = numberStack.pop();
          var a = numberStack.pop();
          var calc = calculate(a,b, last);
          numberStack.push(calc);
        }
        operatorStack.push(temp); 
      } else if(temp == "/") {
        //check last element of operator stack
        var last = operatorStack[operatorStack.length-1];
        if(last == "x") {
          var b = numberStack.pop();
          var a = numberStack.pop();
          var calc = calculate(a,b, last);
          numberStack.push(calc);
        }
        operatorStack.push(temp); 
      } else if( temp == "(" ) {
          operatorStack.push(temp); 
      } else if( temp == ")" ) {
        var last = operatorStack.pop();
        while(last != "(") {
          var b = numberStack.pop();
          var a = numberStack.pop();
          var calc = calculate(a,b, last);
          numberStack.push(calc);
          last = operatorStack.pop();
        }
      }
       
     } //end of if 
  }//end of loop
  
  while(operatorStack.length>0) {
      var oper = operatorStack.pop();
      var b = numberStack.pop();
      var a = numberStack.pop();
      var calc = calculate(a,b, oper);
      numberStack.push(calc);
  }
  
  return numberStack[0];
  
}

function calculate(a, b, operator) {
  switch(operator) {
      case "x":
        return a*b;
      case "/": 
        return a/b;
      case "+": 
        return a+b;
      case "-": 
        return a-b;
      default:
        return NaN;
  }
}



