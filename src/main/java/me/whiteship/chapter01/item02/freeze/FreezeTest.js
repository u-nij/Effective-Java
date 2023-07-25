'use strict'; // freezing은 strict 모드에서만 가능하다.

const keesun = { // var, const
    'name': 'Keesun',
    'age': 40
};

// var일 때는 가능
/*
keesun = {
    'name': 'whiteship'
};
*/

keesun.name = "whiteship";

Object.freeze(keesun);

// keesun.kids = ["서연"]; // freeze 이후 불가능. 실행시 에러 발생.

console.info(keesun.name);