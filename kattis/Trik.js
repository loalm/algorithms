var line;

while (line = readline()) {
  function trik(str){
    var position = 1;
    for (var i = 0; i < str.length; i++) {
      if (str[i] == 'A') {
        position = position === 1 ? 2 : position === 2 ? 1 : position;
      } else if (str[i] == 'B') {
        position = position === 2 ? 3 : position === 3 ? 2 : position;
      } else {
        position = position === 1 ? 3 : position === 3 ? 1 : position;
      }
    }
    print(position);
  }
  trik(line);
}
