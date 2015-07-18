function Dice( sum ) {
	//sum is one of properties
	this.sum  = sum,
	//this is an anynomus function
	//rollDice is a method
	this.rollDice = function() {
		return Math.floor((Math.random() * this.sum) + 1); 
	}
}
