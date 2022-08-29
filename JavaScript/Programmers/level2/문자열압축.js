//문제 : https://programmers.co.kr/learn/courses/30/lessons/60057
// 입력되는 문자열을 압출할 수 있는 만큼 압축해서 압축된 문자열 길이를 리턴

let word = "aaaabbbbabab";

// var? let? const?
// 1. 자르는 단어와 단어의 길이를 따로 보관
//  - 자르는 단어의 최대 길이는 2n or 2n -1
// 2. 자르는 단어로 s로 들어오는 문자열을 잘라낸다.
//  -

// function solution(s) {
//   let inputLength = s.length;
//   console.log(inputLength);
//   let answer = 0;
//   let zipUnit = 0;
//   return answer;
// }

var i = 0;
let input = "";
for (i = 0; i < 10; i++) {
    // console.log("i : " + i);
    window.prompt(`${i}번째 입력을 입력해주세요.`);
    window.alert(input);
}

console.log(input);

// solution(word);
