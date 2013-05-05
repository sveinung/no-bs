requirejs.config({
    paths: {
        'jquery': 'vendor/jquery-1.9.1',
        'underscore': 'vendor/underscore'
    },
    shim: {
        'jquery': {
            exports: 'jQuery'
        },
        'underscore': {
            exports: '_'
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