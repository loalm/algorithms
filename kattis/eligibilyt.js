var numberOfStudents = readline();
var res = [];
for (var i = 0; i < numberOfStudents; i++) {

  var input = readline();
  input = input.split(" ");
  var name = input[0];
  var beganStudyYear = input[1];
  beganStudyYear = beganStudyYear.split("/");
  var birthdate = input[2];
  birthdate = birthdate.split("/");
  var courses = parseInt(input[3]);

  if (parseInt(beganStudyYear[0]) >= 2010) {
    res.push(name+" eligible");
  } else if (parseInt(birthdate[0]) >= 1991) {
    res.push(name+" eligible");
  } else if (courses > 40) {
    res.push(name+" ineligible");
  } else {
    res.push(name+" coach petitions");
  }
}
for (var i = 0; i < res.length; i++) {
  print(res[i]);
}
