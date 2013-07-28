var tests = Object.keys(window.__karma__.files).filter(function (file) {
    return /Spec\.js$/.test(file);
});

var preIncluded = ['sinon', 'jasmine-sinon'];

var deps = preIncluded.concat(tests);

requirejs.config({
    baseUrl: '/base/src/main/webapp',
    paths: {
        'jquery': 'components/jquery/jquery',
        'underscore': 'components/underscore/underscore',
        'text': 'components/requirejs-text/text',
        'mustache': 'components/mustache/mustache',
        'rivets': 'components/rivets/dist/rivets',
        'base': 'modules/base',

        'sinon': '/base/src/main/webapp/components/sinonjs/sinon',
        'jasmine-sinon': '/base/src/main/webapp/components/jasmine-sinon/lib/jasmine-sinon',
        'responseFaker': 'modules/components/responseFaker'
    },
    shim: {
        'jquery': {
            exports: 'jQuery'
        },
        'underscore': {
            exports: '_'
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

require(['rivets'], function(rivets) {
    rivets.configure({
        adapter: {
            preloadData: false,
            subscribe: function(obj, keypath, callback) {
            },
            read: function(obj, keypath) {
                return obj;
            }
        }
    });
});

