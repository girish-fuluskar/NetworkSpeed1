var exec = require('cordova/exec');


module.exports.startServiceNow = function(arg0, success, error) {
    exec(success, error, 'NetworkSpeed1', 'startServiceNow', arg0);
}
