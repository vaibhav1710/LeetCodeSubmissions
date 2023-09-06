/**
 * @return {Function}
 */
function createHelloWorld() {
    return function y(...args) {
      return "Hello World";
    }
    
};

//createHelloWorld();


  const f = createHelloWorld();
 console.log(f); // "Hello World"
 