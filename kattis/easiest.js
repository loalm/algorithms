var X = [];
input = readline();
while(X[X.length-1] != 0){
  X.push(input);
  input = readline();
  if(input == 0){
    break;
  }
}
for (var i = 0; i < X.length; i++) {
  var N = X[i];


var p = 11;
var sumN = 0,
    sumTest = 0;
var temp = N;

while(temp){
  sumN += temp % 10;
  temp = Math.floor(temp/10);
}
var test = 0;
function testIt(){
   test = p*N;
   sumTest = 0;
  while(test){
    sumTest += test % 10;
    test = Math.floor(test/10);
  }

  if(sumN == sumTest) {
    print(p);
  } else {
    ++p;
    testIt();
  }
}
testIt();
}
