var input2 = "*.**";
input2 = input2.split("");

for (var i = 0; i < input2.length/2; i++) {
  var temp = input2[input2.length-1-i];
  input2[input2.length-1-i] = input2[i];
  input2[i] = temp;
}
print(input2.join(""));
