requirejs.config({
    paths: {
        'jquery': 'vendor/jquery-1.9.1',
        'underscore': 'vendor/underscore',
        'text': 'components/requirejs-text/text',
        'mustache': 'vendor/mustache'
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

    var $ = require('jquery');

    var LibraryView = require('modules/library/libraryView');
    var LibraryRepository = require('modules/library/libraryRepository');

    $(function() {
        var libraryView = LibraryView({
            el: $(".library"),
            libraryId: 1,
            libraryRepository: LibraryRepository()
        });
        libraryView.render();
    });
});