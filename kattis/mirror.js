var numberOfTests = readline();
var arr = [];
for (var i = 0; i < numberOfTests; i++) {
  arr.push([]);
}
for (var i = 0; i < numberOfTests; i++) {
  var dimensionInput = readline();
  for (var u = 0; u < dimensionInput[0]; u++) {
    var row = readline();
    row = row.split("");
    // left to right..
    for (var k = 0; k < Math.floor(row.length/2); k++) {
      var temp = row[row.length-1-k];
      row[row.length-1-k] = row[k];
      row[k] = temp;
    }
    row = row.join("");
    arr[i].push(row);
  }
}
// up to down..
for (var i = 0; i < arr.length; i++) {
  for (var j = 0; j < Math.floor(arr[i].length/2); j++) {
    var temp = arr[i][arr[i].length-1-j];
    arr[i][arr[i].length-1-j] = arr[i][j];
    arr[i][j] = temp;
  }
  print("Test "+(1+i));
  for (var j = 0; j < arr[i].length; j++) {
    print(arr[i][j]);
  }

}
