requirejs.config({
    paths: {
        'components': 'bower_components/',
        'jquery': 'bower_components/jquery/jquery',
        'underscore': 'bower_components/underscore/underscore',
        'text': 'bower_components/requirejs-text/text',
        'mustache': 'bower_components/mustache/mustache',
        'rivets': 'bower_components/rivets/dist/rivets',
        'base': 'modules/base'
    },
    shim: {
        'jquery': {
            exports: 'jQuery'
        },
        'underscore': {
            exports: '_'
        }
    },
    map: {
        '*': {
            'css': 'components/require-css/css'
        }
    }
})

define(function(require) {

    require('modules/base-styles/base-styles');

    var $ = require('jquery'),
        rivets = require('rivets');

    var LibraryView = require('modules/library/libraryView');
    var LibraryRepository = require('modules/library/libraryRepository');

    $(function() {
        rivets.configure({
            adapter: {
                preloadData: false,
                subscribe: function(obj, keypath, callback) {
                    console.log("subscribe: ", obj, keypath, callback);
                },
                read: function(obj, keypath) {
                    console.log("read: ", obj, keypath);
                    return obj;
                }
            }
        });

        var libraryView = LibraryView({
            el: $(".library"),
            libraryId: 1,
            libraryRepository: LibraryRepository()
        });
        libraryView.render();
    });
});
