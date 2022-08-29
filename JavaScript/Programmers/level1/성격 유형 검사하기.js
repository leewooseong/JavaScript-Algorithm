// # 문제
// https://school.programmers.co.kr/learn/courses/30/lessons/118666

// # inputs
const SURVEY1 = ["AN", "CF", "MJ", "RT", "NA"];
const CHOICES1 = [5, 3, 2, 7, 5];
// result = "TCMA"
const SURVEY2 = ["TR", "RT", "TR"];
const CHOICES2 = [7, 1, 3];
// result = "RCJA"

const survey = SURVEY2;
const choices = CHOICES2;

function solution(survey, choices) {
    var answer = "";

    const personalityType = {
        R: 0,
        T: 0,
        F: 0,
        C: 0,
        M: 0,
        J: 0,
        A: 0,
        N: 0,
    };

    // 1. 점수 매기기
    for (let i = 0; i < survey.length; i++) {
        const choiceValue = choices[i] - 4;

        if (choiceValue < 0) {
            personalityType[survey[i].slice(0, 1)] += Math.abs(choiceValue);
        } else if (choiceValue > 0) {
            personalityType[survey[i].slice(1)] += Math.abs(choiceValue);
        }
    }

    // 2. 결과 내기
    function selectResultType(type1, type2) {
        if (personalityType[type1] === personalityType[type2]) {
            return type1.charCodeAt(0) < type2.charCodeAt(0) ? type1 : type2;
        } else {
            return personalityType[type1] > personalityType[type2]
                ? type1
                : type2;
        }
    }

    answer += selectResultType("T", "R");
    answer += selectResultType("C", "F");
    answer += selectResultType("M", "J");
    answer += selectResultType("A", "N");

    return answer;
}

console.log(solution(survey, choices));

// map과 구조분해할당, 삼항 연산자를 이용하면 더 간단하게 코드를 정리할 수 있다.
