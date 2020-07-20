 1.1) Install connect and serve-static with NPM
    
    ```$ npm install connect serve-static```

    1.2) Create server.js file with this content:
    ```var connect = require('connect');
       var serveStatic = require('serve-static');
       connect().use(serveStatic(__dirname)).listen(8080, function(){
           console.log('Server running on 8080...');
       });
    ```
    
    1.3 Run with Node.js
    ```
    $ node server.js
    ```

2) Open the included html using Chrome or Safari (will not work with Firefox), make sure the 
port is as set in step 1.2.
    ```
    http://localhost:8080/yourfile.html.
    ```


__Checking the Test Result__
