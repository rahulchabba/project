var radius =[1,2,3,4,1,2,3,4]

var area =  (radius) =>  {
return Math.PI * radius * radius;
}
var greaterThanTwo =   (value) => {
return value > 2;
}

var calculate = function (radius, logic ){
    var result =  [];
    for(var i =0; i< radius.length; i++){
    result.push(logic(radius[i]));
    }
    return result;
}

console.log(`${calculate(radius,area)}`);
console.log(radius.map(area));
console.log('Number greater than 2 : '+  radius.filter(greaterThanTwo));
console.log('Sum of Number'+ radius.reduce(function (acc, curr){
            acc = acc+curr;
            return acc;
},0));
console.log(!!radius.find((a) => a==2));

