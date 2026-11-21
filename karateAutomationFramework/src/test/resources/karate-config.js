
function fn() {

    var UUID = Java.type('java.util.UUID');

    var config = {
        env: karate.env || 'qa',
        baseUrl: 'https://api.demoblaze.com/'
    };

    config.generateUsername = function() {
        return 'sofka' + UUID.randomUUID().toString().replace('-', '');
    };

    return config;
}
