var output = [];
var listLength = readline();
while(listLength != 0){
  var list1 = [],
  list2 = [];
  var listOrder = [];
  var sortedList = [];
  var sortedList2 = [];
  for (var i = 0; i < listLength; i++) {
    var x = readline();
    list1.push(x);
    sortedList.push(x);
  }
  for (var i = 0; i < listLength; i++) {
    var x = readline();
    list2.push(x);
    sortedList2.push(x);
  }
  function getSortIndex(item) {
    sortedList = sortedList.sort(function(a, b){return a-b});
    for (var i = 0; i < listLength; i++) {
      if (item == sortedList[i]) {
        return i;
      }
    }
  }
  function getSortIndex2(item) {
    sortedList2 = sortedList2.sort(function(a, b){return a-b});
    for (var i = 0; i < listLength; i++) {
      if (item == sortedList2[i]) {
        return i;
      }
    }
  }
  function getListOrder() {
    var newList = [];
    for (var i = 0; i < listLength; i++) {
      newList.push(getSortIndex(list1[i]));
    }

    return newList;
  }
  function fixOtherList() {
    output.push([]);
    var newList = getListOrder();
    for (var i = 0; i < listLength; i++) {
      for(var u = 0; u < listLength; u++) {
        if (newList[i] == getSortIndex2(list2[u])) {
          output[output.length-1].push(list2[u]);
        }
      }
    }
  }
  fixOtherList();
  listLength = readline();
  if(listLength == 0){
    break;
  }
}
for (var i = 0; i < output.length; i++) {
  for (var u = 0; u < output[i].length; u++) {
    print(output[i][u]);
  }
  if(i != output.length-1){
    print(" ");
  }
}
