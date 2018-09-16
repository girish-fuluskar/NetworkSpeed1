var exec = require('cordova/exec');

module.exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'NetworkSpeed1', 'coolMethod', [arg0]);
};

module.exports.startServiceNow = function() {
    exec('NetworkSpeed1', 'startServiceNow');
}
