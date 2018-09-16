var exec = require('cordova/exec');


module.exports.startServiceNow = function(arg0) {
    exec('NetworkSpeed1', 'startServiceNow', arg0);
}
