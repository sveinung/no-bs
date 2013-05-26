requirejs.config({
    paths: {
        'jquery': 'vendor/jquery-1.9.1',
        'underscore': 'vendor/underscore',
        'text': 'components/requirejs-text/text',
        'mustache': 'vendor/mustache',
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
