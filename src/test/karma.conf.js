module.exports = function (config) {
    return config.set({
        frameworks: ['jasmine'],
        basePath: '../..',
        files: [
            'node_modules/chai/chai.js',

            'target/webjars/jquery/jquery.min.js',
            'target/webjars/angularjs/angular.min.js',
            'target/webjars/angularjs/angular-animate.min.js',
            'target/webjars/angularjs/angular-mocks.js',

            'app/app.coffee',

            'src/test/karma/**/*.coffee'
        ],
        reporters: ['dots'],
        port: 9876,
        urlRoot: '/karma/',
        browsers: ['PhantomJS'],
        captureTimeout: 60000,
        logLevel: config.LOG_INFO,
        preprocessors: {
            '**/*.coffee': ['coffee']
        },
        coffeePreprocessor: {
            options: {
                sourceMap: true
            }
        }
    });
};