var a = 10;
a = "Hello";
console.log(a);

function add() {
    console.log(arguments);
    var sum = 0;
    for (let i = 0; i < arguments.length; i++) {
        // console.log(arguments[i]);
        sum += arguments[i];
    }
    return sum;
}

const result = add(5, 10, 23, 34, 45);
console.log(result);