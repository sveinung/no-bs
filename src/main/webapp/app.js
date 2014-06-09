requirejs.config({
    paths: {
        'jquery': 'bower_components/jquery/jquery',
        'underscore': 'bower_components/underscore/underscore',
        'backbone': 'bower_components/backbone/backbone',
        'text': 'bower_components/requirejs-text/text',
        'mustache': 'bower_components/mustache/mustache',
        'base': 'modules/base',
        'components': 'bower_components'
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
        }
    },
    map: {
        '*': {
            'css': 'bower_components/require-css/css'
        }
    }
})

define(function(require) {

    require('modules/base-styles/base-styles');

    var $ = require('jquery');

    var LibraryView = require('modules/library/libraryView');
    var Library = require('modules/library/library');

    $(function() {
        var library = new Library();

        var libraryView = new LibraryView({
            library: library
        });

        library.fetch().done(function() {
            libraryView.setElement($(".library"));
            libraryView.render();
        });
    });
});
