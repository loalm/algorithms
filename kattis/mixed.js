var input = readline();
input = input.split(" ");
var arr = [input];

while (arr[arr.length-1][0] != 0) {
  input = readline();
  input = input.split(" ");
  if(input[0] == 0) {
    break;
  }
  arr.push(input);
}

for (var i = 0; i < arr.length; i++) {
  var numerator = arr[i][0];
  var denominator = arr[i][1];

  print(Math.floor(numerator/denominator)+ " " + (numerator % denominator) + " / "+denominator);

}
