var tests = Object.keys(window.__karma__.files).filter(function (file) {
    return /Spec\.js$/.test(file);
});

var preIncluded = ['sinon', 'jasmine-sinon'];

var deps = preIncluded.concat(tests);

requirejs.config({
    baseUrl: '/base/src/main/webapp',
    paths: {
        'components': 'bower_components',
        'jquery': 'bower_components/jquery/jquery',
        'underscore': 'bower_components/underscore/underscore',
        'text': 'bower_components/requirejs-text/text',
        'mustache': 'bower_components/mustache/mustache',
        'backbone': 'bower_components/backbone/backbone',
        'base': 'modules/base',

        'sinon': 'bower_components/sinonjs/sinon',
        'jasmine-sinon': 'bower_components/jasmine-sinon/lib/jasmine-sinon',
        'responseFaker': 'modules/components/responseFaker',
        'po': 'bower_components/po.js/po'
    },
    shim: {
        'jquery': {
            exports: 'jQuery'
        },
        'underscore': {
            exports: '_'
        },
        'backbone': {
            exports: 'Backbone',
            deps: ['jquery', 'underscore']
        },
        'sinon': {
            exports: 'sinon'
        },
        'jasmine-sinon': ['sinon']
    },
    map: {
        '*': {
            'css': 'components/require-css/css'
        }
    },
    deps: deps,
    callback: window.__karma__.start
});
