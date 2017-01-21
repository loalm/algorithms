var input = readline();
input = input.split(" ");
var operators = ["+","-","*","/"];
function checkMath(input) {
  print(parseInt("5+10"));

  for (var i = 0; i < operators.length; i++) {
    var x = parseInt(input[0])+ operators[i] + parseInt(input[1]);
    print(x == 8);
  }

  if (parseInt(input[0]) + parseInt(input[1]) == input[2]) {
    print(input[0]+"+"+input[1]+"="+input[2])
  } else if (parseInt(input[0]) - parseInt(input[1]) == input[2]) {
    print(input[0]+"-"+input[1]+"="+input[2])
  } else if (parseInt(input[0]) / parseInt(input[1]) == input[2]) {
    print(input[0]+"/"+input[1]+"="+input[2])
  } else if (parseInt(input[0]) * parseInt(input[1]) == input[2]) {
    print(input[0]+"*"+input[1]+"="+input[2])
  } else {
    input.unshift(input[input.length-1]);
    input.pop();
    checkMath(input);
  }
}
checkMath(input);
