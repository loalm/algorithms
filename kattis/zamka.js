var L = readline();
var D = readline();
var X = readline();

var max = 0;
var first = false;

for ( ; L <= D; L++) {
  var testDigitSum = 0;
  var check = L;
  while (check) {
    testDigitSum += check % 10;
    check = Math.floor(check/10);
  }
  if (testDigitSum == X && !first) {
    print(L);
    first = true;
  }
  if (testDigitSum == X) {
    max = L;
  }
}
print(max);
