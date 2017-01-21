var personWithBomb = readline();
var totalNumberOfQuestions = readline();
var timeLimit = 210;
var questionInfo = [];

for (var i = 0; i < totalNumberOfQuestions; i++) {
  var input = readline();
  input = input.split(" ");
  questionInfo.push(input);
}
while (timeLimit >= 0) {
  for (var i = 0; i < totalNumberOfQuestions; i++) {
    timeLimit -= questionInfo[i][0];
    if(timeLimit <= 0){
      break;
    }
    if (questionInfo[i][1] == ('T')) {
      ++personWithBomb;
      personWithBomb = personWithBomb % 8;
    }
  }
}
if(personWithBomb == 0){
  personWithBomb = 8;
}
print(personWithBomb);
